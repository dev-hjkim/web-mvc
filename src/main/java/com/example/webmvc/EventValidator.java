package com.example.webmvc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
//public class EventValidator implements Validator {
public class EventValidator {
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Event.class.isAssignableFrom(clazz);
//    }

//    @Override
//    public void validate(Object target, Errors errors) {
//        Event event = (Event) target;
//        if (event.getName().equalsIgnoreCase("aaa")) {
//            errors.rejectValue("name", "wrongValue", "the value is not allowed");
//        }
//    }

    public void validate(Event event, Errors errors) {
        if (event.getName().equalsIgnoreCase("aaa")) {
            errors.rejectValue("name", "wrongValue", "the value is not allowed");
        }
    }
}
