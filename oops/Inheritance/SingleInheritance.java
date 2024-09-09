// package oops.Inheritance;

public class SingleInheritance {
    public static void main(String[] args) {
        Child obj = new Child("sarath", 22, 52, "Krishna moorthy", "gowramma", "bengaluru");
        Child obj1 = new Child(null, 0, 0, null, null, null);
        // Parent obj2 = new Parent();
        obj.greeting();
        obj1.greeting();
    }
}
class Parent{
    String motheName;
    String fatherName; 
    private String address;

    Parent(String motherName,String fName,String address){
        this.motheName=motherName;
        this.fatherName=fName;
        this.address = address;
    }
    Parent(){
    }
    
    void greeting(){
        System.out.println("Welcome to the parent class");
        System.out.println("Adress = " + this.address);
    }
}
class Child extends Parent{
    String Name;
    int age;
    int weight;

    Child(String name,int age,int weight,String fatherName,String motherName,String address){
        super(motherName,fatherName,address);
        this.Name=name;
        this.age=age;
        this.weight=weight;
    }
    
}
