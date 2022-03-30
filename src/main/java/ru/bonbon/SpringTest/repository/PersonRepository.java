package ru.bonbon.SpringTest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bonbon.SpringTest.entity.Person;

import java.util.List;

@Component
public class PersonRepository {
    private final String TABLE_PERSON = "\"Person\"";
    private final String PERSON_ID = "\"id\"";
    private final String PERSON_NAME = "\"name\"";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createPerson(Person person){
        return jdbcTemplate.update("insert into ? (?) values (?)", TABLE_PERSON, PERSON_ID, person.getName());
    }

    public int deletePerson(int id){
        return jdbcTemplate.update("delete from \"Person\" where \"id\"=?", id);
    }

    public Person getPerson(int id){
        return jdbcTemplate.queryForObject("select * from \"Person\" where \"id\"=?", new PersonMapper(), id);
    }

    public List<Person> getAllPersons(){
        return jdbcTemplate.query("select * from \"Person\"", new PersonMapper());
    }

    public int updatePerson(Person person){
        return jdbcTemplate.update("update \"Person\" set \"name\" = ? where \"id\" = ?",
                person.getName(), person.getId());
    }
}
