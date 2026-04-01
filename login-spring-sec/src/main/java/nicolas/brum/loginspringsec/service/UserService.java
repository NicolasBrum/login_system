package nicolas.brum.loginspringsec.service;

import lombok.RequiredArgsConstructor;
import nicolas.brum.loginspringsec.exceptions.EmailDuplicatedException;
import nicolas.brum.loginspringsec.exceptions.PasswordException;
import nicolas.brum.loginspringsec.model.UserCreateDto;
import nicolas.brum.loginspringsec.model.UserModel;
import nicolas.brum.loginspringsec.model.UserResponseDto;
import nicolas.brum.loginspringsec.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(12);

    public void createUser(UserCreateDto userCreateDto) {
        try{
            if(!userCreateDto.password().equals(userCreateDto.confirmPassword())) {
                throw new PasswordException("Senhas não coincidem!");
            }
            var userModel = new UserModel();
            userModel.setId(null);
            userModel.setEmail(userCreateDto.email());
            userModel.setPassword(bcrypt.encode(userCreateDto.password()));
            userModel.setSurname(userCreateDto.surname());
            userModel.setUsername(userCreateDto.username());
            userModel.setPhone(userCreateDto.phone());
            userRepository.save(userModel);
        }catch(DataIntegrityViolationException e){
            throw new EmailDuplicatedException("email ja existente no banco!");
        }
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(new  Function<UserModel, UserResponseDto>() {
            @Override
            public UserResponseDto apply(UserModel userModel) {
                return new UserResponseDto(userModel.getUsername(),userModel.getEmail());
            }
        }).toList();
    }
}
