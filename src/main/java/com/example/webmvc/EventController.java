package com.example.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("event")
public class EventController {

    @Autowired
    EventValidator eventValidator;

    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");    // 도메인 모델을 쓰고자 할 때
//        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", List.of("study", "ceminar", "hobby", "social"));
    }

//    @ModelAttribute("categories")
//    public List<String> categories(Model model) {
//        return List.of("study", "ceminar", "hobby", "social");
//    }

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        model.addAttribute("event", new Event());
        return "events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Valid @ModelAttribute Event event,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/form-name";
        }
        eventValidator.validate(event, bindingResult);
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        return "events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Valid @ModelAttribute Event event,
                                        BindingResult bindingResult,
                                        SessionStatus sessionStatus,
                                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "events/form-limit";
        }
        sessionStatus.setComplete();
        redirectAttributes.addFlashAttribute("newEvent", event);
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model,
                            @SessionAttribute LocalDateTime visitTime) {
        System.out.println(visitTime);

        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);

        Event newEvent = (Event) model.asMap().get("newEvent");

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        eventList.add(newEvent);
        model.addAttribute(eventList);

        return "events/list";
    }

}
