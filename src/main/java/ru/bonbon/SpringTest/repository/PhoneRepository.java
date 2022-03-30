package ru.bonbon.SpringTest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bonbon.SpringTest.entity.Person;
import ru.bonbon.SpringTest.entity.Phone;

import java.util.List;

@Component
public class PhoneRepository {
    private final String TABLE_PHONE= "\"Phone\"";
    private final String PHONE_ID = "\"id\"";
    private final String PHONE_VALUE = "\"value\"";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createPhone(Phone phone){
        return jdbcTemplate.update("insert into ? (?) values (?)", TABLE_PHONE, PHONE_VALUE, phone.getValue());
    }

    public int deletePhone(int id){
        return jdbcTemplate.update("delete from ? where ?=?", TABLE_PHONE, PHONE_ID,
                id);
    }

    public Phone getPhone(int id){
        return jdbcTemplate.queryForObject("select * from ? where ?=?", new PhoneMapper(), TABLE_PHONE, PHONE_ID,
                id);
    }

    public List<Phone> getAllPhones(){
        return jdbcTemplate.query("select * from ?", new PhoneMapper(), TABLE_PHONE);
    }

    public int updatePhone(Phone phone){
        return jdbcTemplate.update("update ? set ? = ? where ? = ?", TABLE_PHONE, PHONE_VALUE,
                phone.getValue(), PHONE_ID, phone.getId());
    }
}
