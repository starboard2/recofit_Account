package recofit.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recofit.account.domain.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByUserId(String userId);

    List<Account> findByUserType(String userType);
}
