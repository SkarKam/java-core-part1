package org.griddynamics.tasks;


public class Task3 {
    public static void main(String[] args) {
        Person p1 = new Person("Janek", 21);
        Person p2 = new Person("Dominik", 38);

        System.out.println("Before:\nPerson 1: "+p1+"\nPerson 2:"+p2);

        MakingChanges.changeIdentities(p1,p2);

        System.out.println("After\nPerson 1: "+p1+"\nPerson 2: "+p2);

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        Person temp = new Person(p1.name, p1.age);
        p1.name = p2.name;
        p1.age = p2.age;
        p2.name = temp.name;
        p2.age = temp.age;

    }
}
