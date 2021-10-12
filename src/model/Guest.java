package model;

import model.*;

import java.io.Serializable;

public class Guest implements Serializable {
    private String name;
    private String houseNumber;
    private String code;

    public Guest() {
    }

    public Guest(String name, String houseNumber, String code) {
        this.name = name;
        this.houseNumber = houseNumber;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
