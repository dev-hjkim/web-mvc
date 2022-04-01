package com.example.webmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @RequestMapping(
            value = "/hello",
//            headers = "!" + HttpHeaders.FROM
            headers = HttpHeaders.AUTHORIZATION + "=" + "111",
            params = "name=hjkim"
    )
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
