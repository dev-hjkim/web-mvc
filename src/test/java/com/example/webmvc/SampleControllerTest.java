package com.example.webmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(options("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().exists(HttpHeaders.ALLOW))
                .andExpect(header().stringValues(HttpHeaders.ALLOW,
                        hasItems(containsString("GET"),
                                containsString("POST"),
                                containsString("OPTIONS"),
                                containsString("HEAD"))))
        ;
    }
}