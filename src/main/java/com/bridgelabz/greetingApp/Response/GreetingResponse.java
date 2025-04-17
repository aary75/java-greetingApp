package com.bridgelabz.greetingApp.Response;

import com.bridgelabz.greetingApp.model.Greeting;
//import org.springframework.stereotype.Service;
//
//@Service
public class GreetingResponse {
    private String message;
    private Greeting updatedGreeting;

    public GreetingResponse(String message, Greeting updatedGreeting) {
        this.message = message;
        this.updatedGreeting = updatedGreeting;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Greeting getUpdatedGreeting() {
        return updatedGreeting;
    }

    public void setUpdatedGreeting(Greeting updatedGreeting) {
        this.updatedGreeting = updatedGreeting;
    }
}