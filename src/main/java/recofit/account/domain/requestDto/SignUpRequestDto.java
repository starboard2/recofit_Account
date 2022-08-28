package recofit.account.domain.requestDto;

import lombok.Data;

@Data
public class SignUpRequestDto {
    private String userId;
    private String password;
    private String userName;
    private String userType;
    private String email;
    private String zipCode;
    private String roadAddress;
    private String detailAddress;
    private String weight;
}
