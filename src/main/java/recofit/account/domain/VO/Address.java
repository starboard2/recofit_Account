package recofit.account.domain.VO;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    String zipCode;
    String detail;
    Double latitude;
    Double longitude;

    public Address() {
    }

    public Address(String zipCode, String detail, Double latitude, Double longitude) {
        this.zipCode = zipCode;
        this.detail = detail;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
