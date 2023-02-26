package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.entity.AccountEntity;


@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

}
