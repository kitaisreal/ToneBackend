package hello.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/testGET")
    public ResponseEntity testGET(){
        String s ="GET_TEST_TONE";
        System.out.println("TEST BODY");
        System.out.println(s);
        System.out.println("TESTSTRING");
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(s, HttpStatus.OK);
        return responseEntity;
    };

    @RequestMapping("/testPOST")
    public ResponseEntity testPOST(@RequestBody String body){
        String s = "POST_TEST_TONE";
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(s, HttpStatus.OK);
        System.out.println("TEST BODY");
        System.out.println(responseEntity.getBody());
        System.out.println("TEST STRING");
        return responseEntity;
    };
}
