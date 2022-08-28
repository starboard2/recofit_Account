package recofit.account.domain.responseDto;

import lombok.Builder;
import lombok.Data;
import recofit.account.domain.VO.Address;
import recofit.account.domain.entity.Account;
//import recofit.account.domain.entity.BasicMember;

@Data
public class SignInResponseDto {
    private String userId;
    private String userName;
    private String userType;
    private Address address;

    private String accessToken;

    @Builder
    public SignInResponseDto(String userId, String userName, String userType, Address address, String accessToken) {
        this.userId = userId;
        this.userName = userName;
        this.userType = userType;
        this.address = address;
        this.accessToken = accessToken;
    }

    public SignInResponseDto(Account account) {
        this.userId = account.getUserId();
        this.userName = account.getUserName();
        this.userType = account.getUserType();
        this.address = account.getAddress();
    }
}
