package ru.bonbon.SpringTest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bonbon.SpringTest.entity.Phone;
import ru.bonbon.SpringTest.repository.PhoneRepository;

import java.util.List;

@RestController
@RequestMapping("phone")
public class PhoneController {

    @Autowired
    private PhoneRepository repository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Phone getPhone(@RequestParam("id") int id){
        return repository.getPhone(id);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Phone> getPhones(){
        return repository.getAllPhones();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public int deletePhone(@PathVariable int id){
        return repository.deletePhone(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.PUT,
            consumes = "text/plain")
    public int createPhone(@RequestBody String param){
        Phone phone = new Phone();
        try {
            JSONObject jsonObject = new JSONObject(param);
            phone.setValue(jsonObject.getString("value"));
            phone.setIdPerson(jsonObject.getInt("id_person"));
        } catch (JSONException e){
            e.getStackTrace();
            System.out.println("Не удалось распарсить тело запроса");
            return 0;
        }
        return repository.createPhone(phone);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,
            consumes = "text/plain")
    public int updatePhone(@RequestBody String param){
        Phone phone = new Phone();
        try {
            JSONObject jsonObject = new JSONObject(param);
            phone.setValue(jsonObject.getString("value"));
            phone.setId(jsonObject.getInt("id"));
            phone.setIdPerson(jsonObject.getInt("id_person"));
        } catch (JSONException e){
            e.getStackTrace();
            System.out.println("Не удалось распарсить тело запроса");
            return 0;
        }
        return repository.updatePhone(phone);
    }
}
