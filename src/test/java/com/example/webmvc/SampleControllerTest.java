package com.example.webmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
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
        mockMvc.perform(get("/hello/123/456"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void helloWithNameTest() throws Exception {
        mockMvc.perform(get("/hello/hjkim"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello hjkim")) // 가장 구체적인 uri의 handler가 사용된다!
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("helloWithName"))
        ;
    }
}