package cn.javis.giada.customer.model;

public class Customer {
    public enum Gender {
        female, male
    }

    private String id;
    private String name;
    private Gender gender;
    private int age;



    public void copy(Customer that) {
        this.id = that.id;
        this.name = that.name;
        this.gender = that.gender;
        this.age = that.age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
