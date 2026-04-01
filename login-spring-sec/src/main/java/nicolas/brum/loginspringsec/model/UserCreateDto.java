package nicolas.brum.loginspringsec.model;

import jakarta.validation.constraints.*;
import nicolas.brum.loginspringsec.validators.ContainsBlank;

public record UserCreateDto(
        @ContainsBlank
        @NotBlank(message = "Campo 'usuário' não pode ser nulo!")
        String username,

        @NotBlank(message = "Campo 'sobrenome' não pode ser nulo!")
        @ContainsBlank
        String surname,

        @NotBlank(message = "Campo 'email' não pode ser nulo!")
        @ContainsBlank
        String email,

        @NotBlank(message = "Campo 'telefone' não pode ser nulo!")
        @ContainsBlank
        @Pattern(regexp = "^[\\d()-]+$", message = "Campo 'telefone' contém caracteres não permitidos!!")
        String phone,

        String password,

        @NotBlank(message = "Campo 'confirmar senha' não pode estar em branco!")
        @ContainsBlank
        String confirmPassword
) {
}
