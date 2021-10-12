package model;

import model.*;

import java.io.Serializable;

public class Invoice implements Serializable {
    Guest guest;
    private int oldNumber;
    private int newNumber;
    private int cost;

    public Invoice(Guest guest, int oldNumber, int newNumber) {
        this.guest = guest;
        this.oldNumber = oldNumber;
        this.newNumber = newNumber;
        this.cost = 0;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(int oldNumber) {
        this.oldNumber = oldNumber;
    }

    public int getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(int newNumber) {
        this.newNumber = newNumber;
    }
    public int getCost(){
        return (this.newNumber - this.oldNumber)*750;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "guest=" + guest +
                ", oldNumber=" + oldNumber +
                ", newNumber=" + newNumber +
                ", cost=" + cost +
                '}';
    }
}
