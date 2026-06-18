class Solution {
    public double angleClock(int hour, int minutes) {
        // Minute hand angle
        double minuteAngle = minutes * 6; // 360 / 60
        
        // Hour hand angle
        double hourAngle = (hour % 12) * 30 + minutes * 0.5; // 360 / 12 + minute adjustment
        
        // Difference
        double angle = Math.abs(hourAngle - minuteAngle);
        
        // return the smaller angle
        return Math.min(angle, 360 - angle);
    }
}