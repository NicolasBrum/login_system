package nicolas.brum.loginspringsec.model;


import nicolas.brum.loginspringsec.validators.ContainsBlank;

public record UserLoginDto(
        @ContainsBlank
        String email,
        @ContainsBlank
        String password
) {
}
