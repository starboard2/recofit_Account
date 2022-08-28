package recofit.account.domain.requestDto;

import lombok.Data;

@Data
public class UpdateRequestDto {
    private String userId;
    private String password;
    private String email;
    private String zipCode;
    private String roadAddress;
    private String detailAddress;
    private Double weight;
}
