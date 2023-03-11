package pl.sda.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.entity.PersonEntity;
import pl.sda.service.PersonService;

import java.util.List;

@RestController
@RequestMapping(path = "/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    @PostMapping
    public void createPerson(@RequestBody PersonEntity requestBody){
        personService.savePerson(requestBody);

    }
    @GetMapping(path = "/{pesel}")
    public PersonEntity getPersonByPesel(@PathVariable String pesel){
        return personService.getByPesel(pesel);
    }

    @GetMapping
    public List<PersonEntity> getAllPersons(){
        return personService.getAllPersons();
    }

    @PutMapping(path = "/pesel")
    public void updatePersonByPesel(
        @RequestBody PersonEntity requestBody,
        @PathVariable String pesel){
        personService.updatePersonByPesel(pesel, requestBody);
    }

    @DeleteMapping(path = "/{pesel}")
    public void deletePersonByPesel(
            @PathVariable String pesel){
        personService.deletePerson(pesel);
    }

}
