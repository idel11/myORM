package models;


import annotations.Column;
import annotations.Table;

@Table("profiles")
public class Profile {

    private Integer id;
    @Column("profilename")
    private String name;
    private String bio;
    @Column("age")
    private Integer age;

    public Profile(Integer id, String name, String bio, Integer age) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", age=" + age +
                '}';
    }
}
