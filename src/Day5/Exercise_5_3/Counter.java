package Day5.Exercise_5_3;

class Counter {
    static int count = 0;

    Counter() {
        count++;
    }

    static void displayCount(){
        System.out.println("Number of objects created to count: "+count);
    }
}
