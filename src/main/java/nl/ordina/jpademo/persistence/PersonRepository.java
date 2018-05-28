package nl.ordina.jpademo.persistence;

import nl.ordina.jpademo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Person save(final Person person) {
        String statement = String.format("insert into person values (%d, '%s');",
                person.getId(), person.getName());
        jdbcTemplate.execute(statement);
        return person;
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person;",
                (rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("name"))
        );
    }

}
