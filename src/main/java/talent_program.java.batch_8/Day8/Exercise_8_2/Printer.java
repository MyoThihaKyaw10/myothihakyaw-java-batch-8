package Day8.Exercise_8_2;

import java.util.ArrayList;

class Printer<T> {
    private ArrayList<T> items;

    public Printer(ArrayList<T> items) {
        this.items = items;
    }

    public void add(T item){
        items.add(item);
    }

    public void printAll(){
        for(T item : items){
            System.out.println(item.toString());
        }
    }
}
