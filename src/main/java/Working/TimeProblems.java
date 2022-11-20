package Working;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeProblems {
    /* Summary:
        hrs: 0
     */

    /**
     * Count the number of Friday 13th occurences between start and end dates, inclusive.
     * @param start The start of the window to search in
     * @param end THe end of the window to search in
     * @return Return the number of times Friday 13th occurred
     */
    public static int countFridayThirteens(LocalDate start, LocalDate end) {
        throw new UnsupportedOperationException();
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
        // Make use of java.time.Duration.
        throw new UnsupportedOperationException();
    }

    /**
     * Assuming the LocalDateTime object is in the "here" timezone, convert it to the equivalent
     * date-time in the "there" timezone.
     * @param timeHere The LocalDateTime object to convert
     * @param here The timezone of timeHere
     * @param there The target timezone
     * @return Return the LocalDateTime zone as of the timeHere timezone
     */
    public static int whatHourIsItThere(LocalDateTime timeHere, String
            here, String there) {
        // Make use of ZoneDateTime and/or ZoneId.
        throw new UnsupportedOperationException();
    }
}
