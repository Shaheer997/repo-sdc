
javac ThreadTableExample.java
java ThreadTableExampleclass TablePrinter extends Thread {
    private int number;
    private String name;
    public TablePrinter(String name, int number) {
        this.name = name;
        this.number = number;
    }
    public void run() {
        System.out.println("---- Table of " + number + " (" + name + ") ----");
        for (int i = 1; i <= 10; i++) {
            System.out.println(name + ": " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---- End of " + name + " Table ----\n");
    }
}
public class ThreadTableExample {
    public static void main(String[] args) {
        int rollNumberPart = 13;  
        int dobPart = 5;          
        TablePrinter rollTable = new TablePrinter("Roll Number Table", rollNumberPart);
        TablePrinter dobTable = new TablePrinter("Date of Birth Table", dobPart);
        rollTable.start();
        dobTable.start();
    }
}