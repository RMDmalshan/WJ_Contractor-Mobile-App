package com.example.wj_contractor;

public class MasonryWorkers {

    private String name;
    private int age;
    private int number;
    private String nic;
    private String email;
    private String address;
    private String userid;


    public MasonryWorkers(String name, int age, int number, String nic, String email, String address, String userid) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.nic = nic;
        this.email = email;
        this.address = address;
        this.userid = userid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
