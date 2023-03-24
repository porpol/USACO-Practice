/*ID: tonywf11
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("friday.in"));

        int n = in.nextInt();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 0-Jan, 1-Feb ...
        int year = 1900;
        int day = 0;
        int[] dayThirteens = {0, 0, 0, 0, 0, 0, 0}; // 0-Sat, 1-Sun ...

        for(int i = year; i < year + n; i++) {
            boolean leapYear = false;
            if(i % 4 == 0) {
                if(i % 100 != 0 || i % 400 == 0) {
                    leapYear = true;
                }
            }

            for(int m = 0; m < 12; m++) {
                int dayThirteen = (day + 12)%7;
                dayThirteens[(dayThirteen + 2) % 7] += 1;
                day += days[m];
                if(leapYear && m == 1) {
                    day++;
                }
                day %= 7;
            }
        }

        PrintWriter out = new PrintWriter(new File("friday.out"));
        for(int i = 0; i < 6; i++) {
            out.print(dayThirteens[i] + " ");
        }
        out.println(dayThirteens[6]);
        out.close();
    }
}
