/**
 * This code is made by Ransel Sumatra.
 * GitHub: https://github.com/ranselcrackers/
 * GitHub Username: ranselcrackers
 * Specialization: BSIT Major in Marketing Technologies at Mapúa Malayan Colleges Laguna
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create a list to store employees
        ArrayList<Employee> employees = EmployeeDataInitializer.initializeEmployees();

        // Display employee information
        for (Employee employee : employees) {
            employee.displayEmployeeInfo();
            System.out.println("\n"); // Add space between tables
        }
    }
}   