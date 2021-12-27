package application;

import entities.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

         List<Employee> employeeList = new ArrayList<>();
         String path = "C:\\Users\\Caio\\Documents\\inn.txt";

         try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
             String employeeCsv = bufferedReader.readLine();
             while (employeeCsv != null) {
                 String[] fields = employeeCsv.split(",");
                 employeeList.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                 employeeCsv = bufferedReader.readLine();
         }
             Collections.sort(employeeList);
             for (Employee employee:
                  employeeList) {
                 System.out.println(employee.getName() + ", " + employee.getSalary());
             }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
