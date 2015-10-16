package model;

import java.util.Scanner;

public class TextUI {
    private Scanner scan = null;

    protected void openScan() {
        this.scan = new Scanner(System.in);
    }

    public Integer readInt(String msg, int start, int end) {
    	int input;
    	
        System.out.print(msg);
        this.openScan();
        
        do {
        	while (!scan.hasNextInt()) {
                scan.next();
            }
        	input = this.scan.nextInt();
        } while (input < start && input > end);
		// System.out.println("Choose a valid value between " + start + " and " + end);
        return input;
    }

    public String readString(String msg) {
        System.out.print(msg);
        this.openScan();
        while (!scan.hasNextLine()) {
            scan.next();
        }
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
    
    /**
     * Wait until the user presses any key to continue
     * @return
     */
    public String readContinue(String msg) {      
        System.out.print(msg);
        this.openScan();
        while (!scan.hasNextLine()) {
            scan.nextLine();
        }
        return this.scan.nextLine();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
    
    public void showMessage(Object o) {
        System.out.println(o);
    }
}
