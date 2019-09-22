package com.example.tuan2_3_bai1;

public class NhanVIen {
    private  String id;
    private  String name;
    private boolean gender;

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public NhanVIen() {
    }

    @Override
    public String toString() {
        final String s = "NhanVIen: " +
                "id=" + id +
                ", name= " + name;
        return s;
    }
}
