package com.example.wj_contractor;

public class Admin {

    private String name;
    private int age;
    private int number;
    private String nic;
    private String username;
    private String password;
    private String email;


    public Admin(String name, int age, int number, String nic, String username, String password, String email) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.nic = nic;
        this.username = username;
        this.password = password;
        this.email = email;


    }

    public Admin(String username, String password) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




