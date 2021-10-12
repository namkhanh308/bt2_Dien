package view;

import controller.invoiceMangerment;
import model.Guest;
import model.Invoice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        String path = "text.txt";

        File file = new File(path);
        List<Guest> guests = new ArrayList<>() ;
        List<Invoice> invoices = new ArrayList<>();
        invoiceMangerment manager = new invoiceMangerment(guests,invoices);
        int total = 0;
        int choose = -1;
        String name;
        String numberHouse;
        String code;
        int soCu;
        int soMoi;
        while(choose != 0){
            if(file.isFile()){
               guests = manager.readToFile(path);
               manager.setGuests(guests);
            }
            else{
                file.createNewFile();
            }
            System.out.println("Menu");
            System.out.println("1. Nhập tên khách hàng");
            System.out.println("2. Nhập thông tin điện");
            System.out.println("3. Hiển thị danh sách khách hàng");
            System.out.println("4. Hiển thị danh sách tất cả biên lai");
            System.out.println("5. Tính tiền điện cho từng hộ dân");
//            System.out.println("6. Thanh toán tiền điện cho từng hộ dân");
//            System.out.println("7. Tính tổng tiền thu được");
            System.out.println("0. Kết thúc chương trình");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.print("Nhập tên khách hàng: ");
                    Scanner scanner1 = new Scanner(System.in);
                    name = scanner1.nextLine();
                    System.out.print("Nhập số nhà: ");
                    numberHouse = scanner1.nextLine();
                    System.out.println("Nhập mã số công tơ");
                    code = scanner1.nextLine();
                    guests.add(new Guest(name,numberHouse,code));
                    manager.writeToFile(path,guests);
                    break;
                case 2:
                    System.out.println("Chức năng nhập thông tin điện: ");
                    System.out.println("Nhập số nhà mà bạn muốn nhập thông tin điện: ");
                    Scanner scanner2 = new Scanner(System.in);
                    numberHouse = scanner2.nextLine();
                    System.out.println(numberHouse);
                    Guest guest = manager.findGuest(numberHouse);
                    if(guest == null){
                        System.out.println("Số nhà bạn nhập không đúng");
                    }
                    else {
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Nhập vào số cũ");
                        soCu = scanner3.nextInt();
                        System.out.println("Nhập vào số mới");
                        soMoi = scanner3.nextInt();
                        invoices.add(new Invoice(guest,soCu,soMoi));
                    }
                    break;
                case 3:
                    System.out.println("Chức năng hiển thị danh sách khách hàng: ");
                    manager.displayGuest();
                    break;
                case 4:
                    System.out.println("Chức năng hiển thị danh sách biên lai khách hàng: ");
                    manager.displayInvoices();
                    break;
                case 5:
                    System.out.println("Nhập vào số nhà mà bạn muốn tính tiền");
                    Scanner scanner3 = new Scanner(System.in);
                    numberHouse = scanner3.nextLine();
                    System.out.println(numberHouse);
                    Guest guest1 = manager.findGuest(numberHouse);
                    if(guest1 ==null){
                        System.out.println("Số nhà bạn nhập không đúng");
                    }
                    else {
                        System.out.println("Số tiền mà hộ dân: "+ guest1.getName() + " phải trả là "+ manager.getSum(guest1));
                    }
                    break;
                case 0:
                    break;

            }
        }
    }
}
