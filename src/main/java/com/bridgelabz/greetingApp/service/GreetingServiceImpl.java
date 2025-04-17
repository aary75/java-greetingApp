package com.bridgelabz.greetingApp.service;

import com.bridgelabz.greetingApp.model.Greeting;
import com.bridgelabz.greetingApp.model.User;
import com.bridgelabz.greetingApp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty() ? "Hello World" : user.toString()));
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting updateGreeting(Long id, String message) {
        Greeting greetingToUpdate = greetingRepository.findById(id).get();
        greetingToUpdate.setMessage(message);
        return greetingRepository.save(greetingToUpdate);
    }

    @Override
    public Greeting deleteGreeting(Long id) {
        Greeting greetingToDelete = greetingRepository.findById(id).get();
        greetingRepository.delete(greetingToDelete);
        return greetingToDelete;
    }
}
