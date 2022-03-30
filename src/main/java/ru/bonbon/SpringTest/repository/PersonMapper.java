package ru.bonbon.SpringTest.repository;

import org.springframework.jdbc.core.RowMapper;
import ru.bonbon.SpringTest.entity.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        return person;
    }
}
