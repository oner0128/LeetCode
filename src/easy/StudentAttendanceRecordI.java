package easy;

/**
 * Created by rrr on 2017/4/20.
 * 551. Student Attendance Record I
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * <p>
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int countA = 0, countL = 0;
        for (char c : chars) {
            if (c == 'L') countL++;
            else {
                if (c == 'A') countA++;
                countL=0;
            }
            if (countA > 1 || countL > 2) return false;
        }
        return true;
    }
    public boolean checkRecord2(String s) {
        char[] chars = s.toCharArray();
        int countA = 0, countL = 0;
        for (char c : chars) {
            if (c == 'L') countL++;
            else {
                if (c == 'A') countA++;
                countL=0;
            }
            if (countA > 1 || countL > 2) return false;
        }
        return true;
    }
}
