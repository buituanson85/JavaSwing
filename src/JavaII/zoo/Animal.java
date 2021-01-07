/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.zoo;

import java.util.Scanner;

/**
 *
 * @author Diep.Tran
 */
public abstract class Animal {
    String name, description;
    int age;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal(String name, String description, int age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public void input() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name: ");
        name = input.nextLine();

        System.out.println("Enter age: ");
        age = Integer.parseInt(input.nextLine());

        System.out.println("Enter description: ");
        description = input.nextLine();
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Animal{" + "name=" + name + ", description=" + description + ", age=" + age + '}';
    }

    public abstract void showSound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

