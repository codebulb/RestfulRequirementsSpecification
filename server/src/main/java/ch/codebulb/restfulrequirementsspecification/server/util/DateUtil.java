package ch.codebulb.restfulrequirementsspecification.server.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static boolean isAtLeastOneDayBefore(Date daybefore, Date dayafter) {
        Calendar calBefore = Calendar.getInstance();
        Calendar calAfter = Calendar.getInstance();
        calBefore.setTime(daybefore);
        calAfter.setTime(dayafter);
        return calBefore.get(Calendar.YEAR) == calAfter.get(Calendar.YEAR)
                && calBefore.get(Calendar.DAY_OF_YEAR) + 1 <= calAfter.get(Calendar.DAY_OF_YEAR);
    }
}
