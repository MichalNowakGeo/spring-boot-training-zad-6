package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import pl.sda.entity.PersonEntity;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByPesel(String pesel);

    Optional<PersonEntity> findByPeselOrId(String pesel, Long id);

    @Modifying
    void deleteByPesel(String pesel);
}
