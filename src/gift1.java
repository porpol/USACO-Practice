/*ID: tonywf11
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("gift1.in"));
        int friends = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> balances = new HashMap<String, Integer>();
        String[] names = new String[friends];

        for(int i = 0; i < friends; i++) {
            String name = in.nextLine();
            balances.put(name, 0);
            names[i] = name;
        }

        for(int i = 0; i < friends; i++) {
            String giver = in.nextLine();
            int money = in.nextInt();
            int peopleGiven = in.nextInt();
            int moneyPerPerson = 0;
            int remaining = money;
            if(peopleGiven != 0) {
                moneyPerPerson = money / peopleGiven;
                remaining = money % peopleGiven;
            }

            try {
                in.nextLine();
            }catch(Exception e) {
                //System.out.println("couldnt do newline");
            }

            for(int p = 0; p < peopleGiven; p++) {
                String person = in.nextLine();
                int curBalance = balances.get(person);
                balances.put(person, curBalance + moneyPerPerson);
            }

            int giverBalance = balances.get(giver);
            balances.put(giver, giverBalance - money + remaining);
        }

        /*for(String n: balances.keySet()) {
            System.out.println(n + ' ' + balances.get(n));
        }*/

        PrintWriter out = new PrintWriter(new FileWriter("gift1.out"));
        for(String n: names) {
            out.println(n + ' ' + balances.get(n));
        }
        out.close();
    }
}
