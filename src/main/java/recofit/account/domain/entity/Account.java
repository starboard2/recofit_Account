package recofit.account.domain.entity;

import lombok.Builder;
import recofit.account.domain.VO.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    String userId;
    String password;
    String userName;
    String email;
    @Embedded
    Address address;

    //    @Column(name = "USER_TYP", insertable = false, updatable = false)
    String userType;

    Double weight;

    Double ratings;

    String gymName;

    public Account() {
    }

    @Builder
    public Account(String userId, String password, String userName, String email, Address address, String userType, Double weight, Double ratings, String gymName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.userType = userType;
        this.weight = weight;
        this.ratings = ratings;
        this.gymName = gymName;
    }

    public void updateAccountInfo(String password, String email, Address address,
                                  Double weight) {
        this.password = password;
        this.email = email;
        this.address = address;
        this.weight = weight;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getUserType() {
        return userType;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getRatings() {
        return ratings;
    }

    public String getGymName() {
        return gymName;
    }
}
