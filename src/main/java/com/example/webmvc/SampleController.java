package com.example.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @RequestMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable("id") Integer idValue, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(idValue);
        event.setName(name);
        return event;
    }

}
