import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        Employee[] employees = {
            new Employee(1, "Alice", "Analytics", 40000),
            new Employee(2, "Bob", "Bobsledding", 30000),
            new Employee(3, "Charlie", "Computers", 20000),
            new Employee(4, "David", "Data Processing", 10000)
        };

        System.out.print("Writing employees to employees.dat... ");
        try (FileOutputStream fos = new FileOutputStream("employees.dat"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Employee employee : employees) {
                oos.writeObject(employee);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file employees.dat");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Done.");

        System.out.println();

        System.out.println("Reading employees from employees.dat...");
        try (FileInputStream fis = new FileInputStream("employees.dat"); ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                Employee employee = (Employee) ois.readObject();
                System.out.println(employee);
            }
        } catch (EOFException e) {
            System.out.println("Done.");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file employees.dat");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
