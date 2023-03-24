/*ID: tonywf11
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("ride.in"));

        String comet = in.nextLine();
        String group = in.nextLine();
        int cometP = 1;
        int groupP = 1;
        int FIRSTLETTERASCII = 64;

        for(int i = 0; i < comet.length(); i++) {
            cometP *= comet.charAt(i) - FIRSTLETTERASCII;
        }
        for(int i = 0; i < group.length(); i++) {
            groupP *= group.charAt(i) - FIRSTLETTERASCII;
        }

        PrintWriter out = new PrintWriter(new FileWriter("ride.out"));
        if(cometP % 47 == groupP % 47) {
            out.println("GO");
        }else {
            out.println("STAY");
        }
        out.close();
    }
}
