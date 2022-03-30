package ru.bonbon.SpringTest.repository;

import org.springframework.jdbc.core.RowMapper;
import ru.bonbon.SpringTest.entity.Person;
import ru.bonbon.SpringTest.entity.Phone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneMapper implements RowMapper<Phone> {
    @Override
    public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
        Phone phone = new Phone();
        phone.setId(rs.getInt("id"));
        phone.setValue("value");
        return phone;
    }
}
