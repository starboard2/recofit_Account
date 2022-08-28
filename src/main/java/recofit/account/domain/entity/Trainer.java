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
//@DiscriminatorValue("TRAINER")
//public class Trainer extends Account {
//    Double Ratings;
//
//    public Trainer() {
//    }
//
//    @Builder
//    public Trainer(String userId, String password, String userName, String email, Address address, Double ratings) {
//        super(userId, password, userName, email, address);
//        Ratings = ratings;
//    }
//
//    public Double getRatings() {
//        return Ratings;
//    }
//
//    public void setRatings(Double ratings) {
//        Ratings = ratings;
//    }
//}
