package nl.ordina.jpademo.controllers;

import nl.ordina.jpademo.model.Person;
import nl.ordina.jpademo.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public final class PersonController {

    private final PersonRepository personRepo;

    @Autowired
    public PersonController(final PersonRepository personRepo) {
        this.personRepo = personRepo;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Person createPerson(@RequestBody final Person person) {
        personRepo.save(person);
        return person;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person retrievePerson(@PathVariable final Long id) {
        return personRepo.findById(id).get();
    }
    
}
