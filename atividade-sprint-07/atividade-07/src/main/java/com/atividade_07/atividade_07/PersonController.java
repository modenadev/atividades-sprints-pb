package com.atividade_07.atividade_07;


import com.atividade_07.atividade_07.entities.Person;
import com.atividade_07.atividade_07.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.atividade_07.atividade_07.services.PersonService.validateAge;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    // Por post //
    @PostMapping
    public ResponseEntity<Person> checkEntry(@RequestBody Person person){

        String message = validateAge(person.getAge());
        person.setMessage(message);
        return ResponseEntity.ok(person);
    }


    // Por request só pegando o nome e a idade//
    @RequestMapping(value = "/validate/{name}/{age}", method = RequestMethod.GET)
    public String validate(@PathVariable(value = "name") String name,
                           @PathVariable(value = "age") int age) throws Exception {
        if (age < 18) {
            return String.format("{\"name\": \"%s\", \"message\": \"Entry Denied\"}", name);
        } else {
            return String.format("{\"name\": \"%s\", \"message\": \"Entry Allowed\"}", name);
        }
    }

}
