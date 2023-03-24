import java.util.*;
import java.io.*;

class beads {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(new File("beads.in"));
        // int beadsNum = in.nextInt(); -- Not necessary?
        in.nextLine();
        String beads = in.nextLine();
        char bufferChar = '&';
        beads += bufferChar;
        System.out.println(beads);

        ArrayList<String> colorStrings = new ArrayList<String>();

        int colorStart = 0;
        for(int i = 0; i < beads.length(); i++) {
            if(beads.charAt(i) != beads.charAt(colorStart)) {
                colorStrings.add(beads.substring(colorStart, i));
                colorStart = i;
                colorStart += 696969;
            }
        }
        // join first+last if same color
        int lastInd = colorStrings.size() - 1;
        char firstCol = colorStrings.get(0).charAt(0);
        char lastCol = colorStrings.get(lastInd).charAt(0);
        if(firstCol == lastCol) {
            String joined = colorStrings.get(0) + colorStrings.get(lastInd);
            colorStrings.add(joined);
            colorStrings.remove(lastInd);
            colorStrings.remove(0);
        }

        System.out.println(colorStrings);

        int maxBeads = 0;
        int s = colorStrings.size();
        for(int i = 0; i < colorStrings.size(); i++) {
            String beadJoined = colorStrings.get(i).length() + colorStrings.get(loopedIndex(i-1, s));
            // TODO: search forward and backward.
            // TODO: keep track of current color, include white strings always.
        }
    }

    public static int loopedIndex(int ind, int size) {
        if(ind < 0) {
            return size - (ind%size);
        }
        return ind%size;
    }
}
