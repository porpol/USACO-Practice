class loopedIndTest {
    public static void main(String[] args) {
        for(int i = 20; i != 45; i = loopedIndex(i-7, 50)) {
            System.out.println(i);
        }
    }

    public static int loopedIndex(int ind, int size) {
        if(ind < 0) {
            return size + (ind%size);
        }
        return ind%size;
    }
}
