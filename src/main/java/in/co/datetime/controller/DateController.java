package in.co.datetime.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * datetime-app
 * Created by pradeep.
 * On 30/1/17 10:12 PM
 */

@RestController
@RequestMapping(value = "/date")
public class DateController {

    @RequestMapping(value = "/today")
    public LocalDate currentDate() {
        return LocalDate.now();
    }
}
