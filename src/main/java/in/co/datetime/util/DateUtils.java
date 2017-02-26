package in.co.datetime.util;

import in.co.datetime.constant.DateTime;
import in.co.datetime.constant.Day;
import in.co.datetime.constant.Operation;

import java.time.LocalDate;

/**
 * Created by with IntelliJ IDEA.
 * User: pradeep
 * Date: 27/2/17
 * Time: 12:11 AM
 */
public class DateUtils {

    private DateUtils() {

    }

    public static LocalDate calculateDate(String day, String operation, int value, String dateTime) {

        LocalDate date = getDate(day);

        try {
            Operation opt = Operation.valueOf(operation.toUpperCase());
            DateTime dt = DateTime.valueOf(dateTime.toUpperCase());

            switch (opt) {
                case ADD:
                case PLUS:
                    switch (dt) {
                        case YEAR:
                            date = date.plusYears(value);
                            break;
                        case MONTH:
                            date = date.plusMonths(value);
                            break;
                        case DAY:
                            date = date.plusDays(value);
                            break;
                    }
                    break;

                case MINUS:
                case SUBTRACT:
                    switch (dt) {
                        case YEAR:
                            date = date.minusYears(value);
                            break;
                        case MONTH:
                            date = date.minusMonths(value);
                            break;
                        case DAY:
                            date = date.minusDays(value);
                            break;
                    }
                    break;
            }
        } catch (IllegalArgumentException exception) {
            date = LocalDate.now();
        }

        return date;

    }

    public static LocalDate getDate(String requestedDay) {

        LocalDate date = null;

        if (requestedDay != null) {
            try {
                Day day = Day.valueOf(requestedDay.toUpperCase());
                switch (day) {
                    case YESTERDAY:
                        date = LocalDate.now().minusDays(1);
                        break;
                    case TODAY:
                        date = LocalDate.now();
                        break;
                    case TOMORROW:
                        date = LocalDate.now().plusDays(1);
                        break;
                }
            } catch (IllegalArgumentException exception) {
                date = LocalDate.now();
            }
        } else {
            date = LocalDate.now();
        }

        return date;
    }
}
