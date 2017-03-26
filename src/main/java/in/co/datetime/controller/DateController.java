package in.co.datetime.controller;

import in.co.datetime.util.DateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.GET)
    public LocalDate now() {
        return DateUtils.getDate("today");
    }

    @RequestMapping(value = "/{day}", method = RequestMethod.GET)
    public LocalDate findDate(@PathVariable String day) {
        return DateUtils.getDate(day);
    }

    @RequestMapping(value = "/{requestedDay}/{operation}/{value}/{dateTime}", method = RequestMethod.GET)
    public LocalDate findDate(@PathVariable String requestedDay, @PathVariable String operation,
                              @PathVariable int value, @PathVariable String dateTime) {
        return DateUtils.calculateDate(requestedDay, operation, value, dateTime);
    }

}
