package nl.ordina.jpademo.controllers;

import nl.ordina.jpademo.model.Person;
import nl.ordina.jpademo.persistence.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public final class PersonController {

    private List<Person> personList = new ArrayList<>();

    private final PersonDAO personDAO;

    @Autowired
    public PersonController(final PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Person createPerson(@RequestBody final Person person) {
        personList.add(person);
        personDAO.save(person);
        return person;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person retrievePerson(@PathVariable final Long id) {
        return personList.stream().
                filter(entity -> entity.getId().equals(id)).
                findFirst().get();
    }

}
