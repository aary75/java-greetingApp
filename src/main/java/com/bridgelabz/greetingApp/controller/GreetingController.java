package com.bridgelabz.greetingApp.controller;

import com.bridgelabz.greetingApp.Response.GreetingResponse;
import com.bridgelabz.greetingApp.model.Greeting;
import com.bridgelabz.greetingApp.model.User;
import com.bridgelabz.greetingApp.service.IGreetingService;
import com.bridgelabz.greetingApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired(required = true)
    private IGreetingService service;

    @Autowired(required = true)
    private UserService userService;

    // GET /greetings/byName?name=Aaryan
    @GetMapping("/byName")
    public Greeting greetingByName(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = userService.createUser(name);
        return service.addGreeting(user);
    }

    // GET /greetings/byFullName?firstName=Aaryan&lastName=Garg
    @GetMapping("/byFullName")
    public Greeting greetingByFullName(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                                       @RequestParam(value = "lastName", required = false) String lastName) {
        User user = new User();
        user.setFirstName(firstName);

        if (lastName != null && !lastName.trim().isEmpty()) {
            user.setLastName(lastName);
        }

        return service.addGreeting(user);
    }

    // POST /greetings - Body: { "firstName": "Aaryan", "lastName": "Garg" }
    @PostMapping("")
    public Greeting greeting(@RequestBody User user) {
        return service.addGreeting(user);
    }

    // GET /greetings/byId?id=1
    @GetMapping("/byId")
    public GreetingResponse greetingById(@RequestParam(value = "id", defaultValue = "1") long id) {
        return new GreetingResponse("Greeting message by id:", service.getGreetingById(id));
    }

    // GET /greetings/all
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return service.getAllGreetings();
    }

    // PATCH /greetings?id=1 - Body: { "message": "Hello" }
    @PatchMapping("")
    public GreetingResponse updateGreeting(@RequestParam(value = "id", defaultValue = "1") long id,
                                           @RequestBody String message) {
        Greeting updated = service.updateGreeting(id, message);
        return new GreetingResponse("Greeting message updated successfully\n", updated);
    }

    // DELETE /greetings?id=1
    @DeleteMapping("")
    public GreetingResponse deleteGreeting(@RequestParam(value = "id", defaultValue = "1") long id) {
        Greeting deleted = service.deleteGreeting(id);
        return new GreetingResponse("Greeting message deleted successfully\n", deleted);
    }
}
