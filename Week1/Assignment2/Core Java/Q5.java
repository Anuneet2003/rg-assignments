// 5) How do we make sure a class is encapsulated? Explain with a coding example.


// Answer:
// Encapsulation of a class can be ensured by using private fields and public getters & setters.
// Example:

public class Student {
    private String name;
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
