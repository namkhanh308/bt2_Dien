package controller;

import model.Guest;
import model.Invoice;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class invoiceMangerment implements Serializable {
    List<Guest> guests;
    List<Invoice> invoices;

    public invoiceMangerment() {
    }

    public invoiceMangerment(List<Guest> guests, List<Invoice> invoices) {
        this.guests = guests;
        this.invoices = invoices;
    }
    public Guest findGuest(String code){
        for (Guest guest : guests) {
            if(guest.getHouseNumber().equals(code)){
                return guest;
            }
        }
        return null;
    }
    public int getSum(Guest guest){
        for (Invoice invoice : invoices ) {
            if(invoice.getGuest().getHouseNumber().equals(guest.getHouseNumber())){
                return invoice.getCost();
            }
        }
        return -1;
    }
    public void displayGuest(){
        for (Guest guest : guests) {
            System.out.println(guest);
        }
    }
    public void displayInvoices(){
        for (Invoice invoice:invoices) {
            System.out.println(invoice);
        }
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }
    public void writeToFile(String path , List<Guest> guests){
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(guests);
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public  List<Guest> readToFile(String path){
        File file = new File(path);
        if(file.length() == 0){
            return new ArrayList<>();
        }
        List<Guest> guests = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try{
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            guests = (List<Guest>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return guests;
    }
    public static void writeToFileInvoice(String path , List<Invoice> invoices){
        File file = new File(path);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(invoices);
            fileOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Invoice> readToFileInvoice(String path){
        File file = new File(path);
        if(file.length() == 0){
            return new ArrayList<>();
        }
        List<Invoice> invoices = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try{
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            invoices = (List<Invoice>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return invoices;
    }
}

