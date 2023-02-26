package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.entity.PersonEntity;


@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    PersonEntity findByPesel(String pesel);
}
