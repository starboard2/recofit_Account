//package recofit.account.domain.entity;
//
//
//import lombok.Builder;
//import recofit.account.domain.VO.Address;
//
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//
//@Entity
//@DiscriminatorValue("GYMOWNER")
//public class GymOwner extends Account {
//    String gymName;
//
//    public GymOwner() {
//    }
//
//    @Builder
//    public GymOwner(String userId, String password, String userName, String email, Address address, String gymName) {
//        super(userId, password, userName, email, address);
//        this.gymName = gymName;
//    }
//
//    public String getGymName() {
//        return gymName;
//    }
//
//    public void setGymName(String gymName) {
//        this.gymName = gymName;
//    }
//}
