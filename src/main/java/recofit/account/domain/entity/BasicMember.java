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
//@DiscriminatorValue("MEMBER")
//public class BasicMember extends Account {
//    Double weight;
//
//    public BasicMember() {
//    }
//
//    @Builder
//    public BasicMember(String userId, String password, String userName, String email, Address address, Double weight) {
//        super(userId, password, userName, email, address);
//        this.weight = weight;
//    }
//
//    public Double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(Double weight) {
//        this.weight = weight;
//    }
//}
