package FirstDraft;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.time.DayOfWeek.FRIDAY;

public class TimeProblems {
    /* Summary: Practice using the Java time package.
        hrs: 3
     */

    /**
     * Count the number of Friday 13th occurences between start and end dates, inclusive.
     * @param start The start of the window to search in
     * @param end THe end of the window to search in
     * @return Return the number of times Friday 13th occurred
     */
    public static int countFridayThirteens(LocalDate start, LocalDate end) {
        int counter = 0;

        // Find the first 13th
        while(start.getDayOfMonth() != 13) {
            start = start.plusDays(1L);
        }
        if(start.getDayOfWeek().equals(FRIDAY)) { counter++; }
        start = start.plusMonths(1L);

        // Find next month's 13th until end
        while(start.isBefore(end)) {
            //System.out.println(start + " is a: " + start.getDayOfWeek().toString() + ", counter: " + counter);
            if(start.getDayOfWeek().equals(FRIDAY)) { counter++; }
            start = start.plusMonths(1L);
        }

        return counter;
    }

    /**
     * Calculate the day of the week (all-caps string) after however many seconds are added to the
     * provided LocalDateTime object.
     * @param timeHere The starting date/time
     * @param seconds The number of seconds to add to the start
     * @return Return the day of week as a string, all-capitalized
     */
    public static String dayAfterSeconds(LocalDateTime timeHere, long
            seconds) {
        LocalDateTime newTime = timeHere.plusSeconds(seconds);
        return newTime.getDayOfWeek().toString();
    }

    /**
     * Assuming the LocalDateTime object is in the "here" timezone, convert it to the equivalent
     * date-time in the "there" timezone, and return the hour (24hr clock).
     * @param timeHere The LocalDateTime object to convert
     * @param here The timezone of timeHere
     * @param there The target timezone
     * @return Return the LocalDateTime zone as of the timeHere timezone
     */
    public static int whatHourIsItThere(LocalDateTime timeHere, String
            here, String there) {
        ZoneId zoneHere = ZoneId.of(here);
        ZoneId zoneThere = ZoneId.of(there);
        ZonedDateTime hereTime = timeHere.atZone(zoneHere);
        ZonedDateTime thereTime = hereTime.withZoneSameInstant(zoneThere);
        return thereTime.getHour();
    }
}
