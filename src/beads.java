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
        // Loop thru breakpoints
        for(int i = 0; i < s; i++) {
            // HashMap to not repeat indexes while looping through strings
            HashSet<Integer> includedIndexes = new HashSet<Integer>();
            // Automatically include the two strings at breakpoint
            includedIndexes.add(i);
            includedIndexes.add(loopedIndex(i-1, s));

            // TODO: search forward and backward.
            // TODO: keep track of current color, include white strings always.

            // Forward
            char initColor = colorStrings.get(i).charAt(0);
            for(int j = loopedIndex(i+1, s); j != i; j = loopedIndex(j+1, s)) {
                char curColor = colorStrings.get(j).charAt(0);
                if(initColor == 'w' && curColor != 'w') {
                    includedIndexes.add(j);
                    initColor = curColor;
                }else if(curColor == 'w') {
                    includedIndexes.add(j);
                }else if(curColor == initColor) {
                    includedIndexes.add(j);
                }
            }

            // Backward
            initColor = colorStrings.get(loopedIndex(i-1, s)).charAt(0);
            for(int j = loopedIndex(i-2, s); j != loopedIndex(i-1, s); j = loopedIndex(j-1, s)) {
                char curColor = colorStrings.get(j).charAt(0);
                if(initColor == 'w' && curColor != 'w') {
                    includedIndexes.add(j);
                    initColor = curColor;
                }else if(curColor == 'w') {
                    includedIndexes.add(j);
                }else if(curColor == initColor) {
                    includedIndexes.add(j);
                }
            }

            // ADD UP # OF BEADS USING INCLUDED INDEXES
            int beadSum = 0;
            for(int ind: includedIndexes) {
                beadSum += colorStrings.get(ind).length();
            }
            if(beadSum > maxBeads) {
                maxBeads = beadSum;
            }
        }

        System.out.println(maxBeads);
    }

    public static int loopedIndex(int ind, int size) {
        if(ind < 0) {
            return size + (ind%size);
        }
        return ind%size;
    }
}