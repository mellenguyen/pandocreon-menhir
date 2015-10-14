package model;

import java.util.Scanner;

public class TextUI {
    private Scanner scan = null;

    protected void openScan() {
        this.scan = new Scanner(System.in);
    }

    public Integer readInt(String msg) {
        System.out.print(msg);
        this.openScan();
        while (!scan.hasNextInt()) {
            scan.next();
        }
        return this.scan.nextInt();
    }

    public String readString(String msg) {
        System.out.print(msg);
        this.openScan();
        return this.scan.nextLine();
    }

    public Float readFloat(String msg) {
        System.out.print(msg);
        this.openScan();
        while (!scan.hasNextFloat()) {
            scan.next();
        }
        return this.scan.nextFloat();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
    
    public void showMessage(Object o) {
        System.out.println(o);
    }
}
