package ru.bonbon.SpringTest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bonbon.SpringTest.entity.Person;
import ru.bonbon.SpringTest.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonRepository repository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Person getPerson(@RequestParam("id") int id){
        return repository.getPerson(id);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Person> getAllPersons(){
        return repository.getAllPersons();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public int deletePerson(@RequestParam("id") int id){
        return repository.deletePerson(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.PUT, consumes = "text/plain")
    public int createPerson(@RequestBody String param){
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(param);
            person.setName(jsonObject.getString("name"));
        } catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.createPerson(person);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "text/plain")
    public int updatePerson(@RequestBody String param){
        Person person = new Person();
        try {
            JSONObject jsonObject = new JSONObject(param);
            person.setName(jsonObject.getString("name"));
            person.setId(jsonObject.getInt("id"));
        } catch (JSONException e){
            System.out.println("Не удалось распарсить json");
            e.printStackTrace();
            return 0;
        }
        return repository.updatePerson(person);
    }
}
