package recofit.account.domain.requestDto;

import lombok.Data;

@Data
public class SignInRequestDto {
    private String userId;
    private String password;
}
