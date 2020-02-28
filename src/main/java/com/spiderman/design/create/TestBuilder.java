package com.spiderman.design.create;

/**
 * 建造者模式
 * 定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 *
 * 适用：当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时
 */

public class TestBuilder {
    public static void main(String[] args) {
        PersonBuilder builder = new PersonBuilder();
        Person result = builder.name("lion")
                .address("america")
                .age(18)
                .sex(2).getResult();
        System.out.println(result.toString());
    }
}
class Person {
    private String name;
    private String address;
    private int age;
    private int sex;
    private int height;
    private int weight;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

class PersonBuilder {
    private Person person;

    public PersonBuilder() {
        this.person = new Person();
    }

    public PersonBuilder name(String name) {
        this.person.setName(name);
        return this;
    }

    public PersonBuilder address(String address) {
        this.person.setAddress(address);
        return this;
    }

    public PersonBuilder age(int age) {
        this.person.setAge(age);
        return this;
    }

    public PersonBuilder sex(int sex) {
        this.person.setSex(sex);
        return this;
    }

    public PersonBuilder height(int height) {
        this.person.setHeight(height);
        return this;
    }

    public PersonBuilder weight(int weight) {
        this.person.setWeight(weight);
        return this;
    }

    public Person getResult(){
        return person;
    }
}
