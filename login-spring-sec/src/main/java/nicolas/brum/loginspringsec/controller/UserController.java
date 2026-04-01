package nicolas.brum.loginspringsec.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nicolas.brum.loginspringsec.model.UserCreateDto;
import nicolas.brum.loginspringsec.model.UserLoginDto;
import nicolas.brum.loginspringsec.model.UserResponseDto;
import nicolas.brum.loginspringsec.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<Void> userRegister(@RequestBody @Valid UserCreateDto userCreateDto, HttpServletRequest request) {
        userService.createUser(userCreateDto);
        return ResponseEntity.created(URI.create(request.getRequestURI())).build();
    }

    @PostMapping("/auth")
    public ResponseEntity<?> userAuth(@RequestBody UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDto.email(),
                        userLoginDto.password()
                )
        );

        return ResponseEntity.ok().build();
}

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
