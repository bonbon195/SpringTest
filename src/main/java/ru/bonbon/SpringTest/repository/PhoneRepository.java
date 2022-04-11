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
        return jdbcTemplate.update("insert into \"Phone\" (\"value\") values (?)", phone.getValue());
    }

    public int deletePhone(int id){
        return jdbcTemplate.update("delete from \"Phone\" where \"id\"=?", id);
    }

    public Phone getPhone(int id){
        return jdbcTemplate.queryForObject("select * from \"Phone\" where \"id\"=?", new PhoneMapper(), id);
    }

    public List<Phone> getAllPhones(){
        return jdbcTemplate.query("select * from \"Phone\"", new PhoneMapper());
    }

    public int updatePhone(Phone phone){
        return jdbcTemplate.update("update \"Phone\" set \"value\" = ? where \"id\" = ?",
                phone.getValue(), phone.getId());
    }
}
