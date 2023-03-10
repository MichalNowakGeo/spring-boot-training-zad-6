package pl.sda.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.entity.PersonEntity;
import pl.sda.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonEntity> getAllPersons(){
        return personRepository.findAll();
    }

    public void savePerson(PersonEntity personEntity){
        personRepository.save(personEntity);
    }

    public void deletePerson(String pesel) {
        //pobranie i usuniecie
        personRepository.findByPesel(pesel)
                //znajdujemy obiekt PersonEntity
                // po peselu, i zwracamy go jako Optional
                .ifPresent(personEntity -> personRepository.delete(personEntity));

        //wykonanie query usuwajacego
        personRepository.deleteByPesel(pesel);
    }

    public PersonEntity getByPesel(String pesel) {
        return personRepository.findByPesel(pesel)
                .orElseThrow();
    }

    //    @Transactional
    public void updatePersonByPesel(String pesel, PersonEntity updatedData) {
        personRepository.findByPesel(pesel)
                .map(objectInsideOptional -> {
                    objectInsideOptional.setFirstName(updatedData.getFirstName());
                    objectInsideOptional.setLastName(updatedData.getLastName());
                    return objectInsideOptional;
                })
                .ifPresent(updatedEntity -> personRepository.save((updatedEntity)));
    }
}
