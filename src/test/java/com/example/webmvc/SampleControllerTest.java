package com.example.webmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void postEvent() throws Exception {
        mockMvc.perform(post("/events")
                        .param("name", "hjkim")
                        .param("limit", "20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("hjkim"))
        ;
    }

    @Test
    public void eventForm() throws Exception {
        mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("/events/form"))
                .andExpect(model().attributeExists("event"))
        ;
    }

}