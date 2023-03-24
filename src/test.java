/*ID: tonywf11
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("test.in"));

        int[] nums = new int[2];
        for(int i = 0; i < 2; i++) {
            nums[i] = in.nextInt();
        }

        PrintWriter out = new PrintWriter(new FileWriter("test.out"));
        out.println(nums[0] + nums[1]);
        out.close();
    }
}
