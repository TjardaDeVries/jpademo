package nl.ordina.jpademo.controllers;

import nl.ordina.jpademo.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public final class PersonController {

    private List<Person> entityList = new ArrayList<>();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> findAll() {
        return entityList;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Person createPerson(@RequestBody final Person person) {
        entityList.add(person);
        return person;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person retrievePerson(@PathVariable final Long id) {
        return entityList.stream().
                filter(entity -> entity.getId().equals(id)).
                findFirst().get();
    }
}
