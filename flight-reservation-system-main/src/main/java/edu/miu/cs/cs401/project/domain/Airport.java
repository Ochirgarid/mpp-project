package edu.miu.cs.cs401.project.domain;

public class Airport {
    private static int idCount = 0;
    private int id;
    private String code;
    private String name;
    private Address address;

    public Airport(String code, String name, Address address) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.id = idCount++;
    }
}
