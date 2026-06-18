class Solution {
    public double angleClock(int hour, int minutes) {
        // angle in 1 minute = 360/60 = 6 degree
        // minuteAngle = 6* minutes
        double minuteAngle = 6 * minutes;

        // angle in 1 hour = 360/12 = 30 degree
        // angle in 1 minute = 360/720 = 0.5 degree
        // hourAngle = 30* (hours%12) + 0.5 * minutes
        double hourAngle = 30 * (hour % 12) + 0.5 * minutes;

        double difference = Math.abs(hourAngle - minuteAngle);

        return Math.min(difference, 360.0 - difference);
    }
}