package com.example.webmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;


//    @Test
//    public void eventForm() throws Exception {
//        MockHttpServletRequest request = mockMvc.perform(get("/events/form"))
//                .andDo(print())
//                .andExpect(view().name("events/form"))
//                .andExpect(model().attributeExists("event"))
//                .andExpect(request().sessionAttribute("event", notNullValue()))
//                .andReturn().getRequest();
//        Object event = request.getSession().getAttribute("event");
//        System.out.println(event);
//    }

}