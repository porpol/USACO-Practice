/*ID: tonywf11
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

class milk2_old {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("milk2.in"));
        int farmers = in.nextInt();
        ArrayList<Time> times = new ArrayList<>();
        for(int i = 0; i < farmers; i++) {
            in.nextLine();
            times.add(new Time(true, in.nextInt()));
            times.add(new Time(false, in.nextInt()));
        }

        for(Time t: times) {
            System.out.println(t.print());
        }


    }
}

class Time {
    boolean start;
    int time;

    Time(boolean s, int t) {
        start = s;
        time = t;
    }

    String print() {
        String s = Integer.toString(time) + start;
        return s;
    }
}
