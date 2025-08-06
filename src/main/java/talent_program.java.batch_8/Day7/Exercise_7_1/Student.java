package Day7.Exercise_7_1;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayInfo(){
        System.out.println("ID: "+id+"  Name: "+name);
    }
}
