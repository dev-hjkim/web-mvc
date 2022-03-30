package com.example.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class SampleController {

//    @GetMapping({"/hello", "/hi"})
//    @GetMapping("/hello?")    //hello 뒤에 한 글자(ex. /hello1, /hello2)
//    @GetMapping("/hello/*")   //hello 뒤에 여러 글자(ex. /hello/123. hello/abc)
//    @GetMapping("/hello/**")    //hello 뒤에 여러 path(ex. /hello/123/456)
    @RequestMapping("/**")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/{name:[a-z]+}")
    @ResponseBody
    public String helloWithName(@PathVariable String name) {
        return "hello " + name;
    }
}
