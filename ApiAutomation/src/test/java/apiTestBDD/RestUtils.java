package apiTestBDD;


import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;

public class RestUtils {

    public static String getFirstName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Janny" + generatedString);
    }

    public static String getLastName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Kony" + generatedString);
    }

    public static String getTotalPrice() {
        String generatedString = RandomStringUtils.randomNumeric(3);
        return (generatedString);
    }

    public static boolean getDepositPaid() {
        boolean flag = false;
        if (2 > 1) {
            flag = true;
        }
        return flag;

    }

   /* public static LocalDate getCheckInDate() {
        LocalDate generatedString = RandomDateUtils.randomPastLocalDate();
        return (generatedString);
    }

    public static LocalDate getCheckOutDate() {
        LocalDate generatedString = RandomDateUtils.randomPastLocalDate();
        return (generatedString);
    }*/

    public static String getAdditionalNeeds() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("Breakfast" + generatedString);
    }

    public static String getName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Janny" + generatedString);
    }

    public static String getJob() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return (generatedString);
    }

}
