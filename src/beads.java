/*ID: tonywf11
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

class beads {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("beads.in"));
        // int beadsNum = in.nextInt(); -- Not necessary?
        in.nextLine();
        String beads = in.nextLine();
        System.out.println(beads);

        int maxBeads = 0;
        int s = beads.length();
        // Loop thru breakpoints
        for(int i = 0; i < s; i++) {
            // TODO: skip if not at breakpoint
            // HashMap to not repeat indexes while looping through strings
            HashSet<Integer> includedIndexes = new HashSet<Integer>();
            // Automatically include the two strings at breakpoint
            includedIndexes.add(i);
            includedIndexes.add(loopedIndex(i-1, s));

            // TODO: search forward and backward.
            // TODO: keep track of current color, include white strings always.

            // Forward
            char initColor = beads.charAt(i);
            for(int j = loopedIndex(i+1, s); j != i; j = loopedIndex(j+1, s)) {
                char curColor = beads.charAt(j);
                if(initColor == 'w' && curColor != 'w') {
                    includedIndexes.add(j);
                    initColor = curColor;
                }else if(curColor == 'w') {
                    includedIndexes.add(j);
                }else if(curColor == initColor) {
                    includedIndexes.add(j);
                }else {
                    break;
                }
            }

            // Backward
            initColor = beads.charAt(loopedIndex(i-1, s));
            for(int j = loopedIndex(i-2, s); j != loopedIndex(i-1, s); j = loopedIndex(j-1, s)) {
                char curColor = beads.charAt(j);
                if(initColor == 'w' && curColor != 'w') {
                    includedIndexes.add(j);
                    initColor = curColor;
                }else if(curColor == 'w') {
                    includedIndexes.add(j);
                }else if(curColor == initColor) {
                    includedIndexes.add(j);
                }else {
                    break;
                }
            }

            // ADD UP # OF BEADS USING INCLUDED INDEXES
            int beadSum = includedIndexes.size();
            if(beadSum > maxBeads) {
                maxBeads = beadSum;
            }
        }

        // System.out.println(maxBeads);

        PrintWriter out = new PrintWriter(new FileWriter("beads.out"));
        out.println(maxBeads);
        out.close();
    }

    public static int loopedIndex(int ind, int size) {
        if(ind < 0) {
            return size + (ind%size);
        }
        return ind%size;
    }
}
