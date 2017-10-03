package hello.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUploadController {
    @GetMapping(value = "/testThis")
    public String handleTest() {
        return "test";
    }
}