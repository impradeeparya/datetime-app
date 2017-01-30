package in.co.datetime.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * datetime-app
 * Created by pradeep.
 * On 31/1/17 1:11 AM
 */

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "hello world !!";
    }
}
