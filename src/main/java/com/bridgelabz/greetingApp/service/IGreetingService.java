package com.bridgelabz.greetingApp.service;
import com.bridgelabz.greetingApp.model.Greeting;
import com.bridgelabz.greetingApp.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(Long id);
    List<Greeting> getAllGreetings();
    Greeting updateGreeting(Long id, String message);
    Greeting deleteGreeting(Long id);
}