package recofit.account.domain.responseDto;

import lombok.Builder;
import lombok.Data;
import recofit.account.domain.VO.Address;

@Data
public class AccountInfoDto {
    private String userId;
    private String userName;
    private String userType;
    private String userEmail;
    private Address address;
    private Double userRating;
    private Double userWeight;

    @Builder
    public AccountInfoDto(String userId, String userName, String userType, String userEmail, Address address, Double userRating, Double userWeight) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.userEmail = userEmail;
        this.address = address;
        this.userRating = userRating;
        this.userWeight = userWeight;
    }
}
