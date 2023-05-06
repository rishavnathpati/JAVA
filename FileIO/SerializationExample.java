package FileIO;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        // create an object to serialize
        Person person = new Person("John Doe", 30, "john.doe@example.com");

        // serialize the object to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.se"))) {
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // deserialize the object from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.se"))) {
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Age: " + deserializedPerson.getAge());
            System.out.println("Email: " + deserializedPerson.getEmail());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
