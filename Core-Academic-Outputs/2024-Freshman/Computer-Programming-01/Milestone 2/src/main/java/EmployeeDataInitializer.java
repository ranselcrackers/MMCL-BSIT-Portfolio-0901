/**
 * This code is made by Ransel Sumatra.
 * GitHub: https://github.com/ranselcrackers/
 * GitHub Username: ranselcrackers
 * Specialization: BSIT Major in Marketing Technologies at Mapúa Malayan Colleges Laguna
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class initializes employee data, including hours worked.
 */
public class EmployeeDataInitializer {
    public static List<Employee> initializeEmployees() {
        List<Employee> employees = new ArrayList<>();

        // Add employee data
        employees.add(createEmployee(10001, "Garcia", "Manuel III", "password123", 535.71, 
            new double[][]{{42.5, 2.5}, {43.5, 3.5}, {43.5, 3.5}, {43.5, 3.5}}));
        
        employees.add(createEmployee(10002, "Lim", "Antonio", "password123", 500.00, 
            new double[][]{{46.5, 6.5}, {45.5, 5.5}, {45.5, 5.5}, {45.5, 5.5}}));

        // Add the remaining 32 employees similarly...

        return employees;
    }

    // Helper method to create an employee with hours data
    private static Employee createEmployee(int empId, String lastName, String firstName, 
                                           String password, double hourlyRate, double[][] juneHours) {
        HoursData hoursData = new HoursData(empId, 40); // Assumed regular hours: 40

        // Add June hours
        for (int week = 0; week < juneHours.length; week++) {
            hoursData.addHours("June", week + 1, juneHours[week][0], juneHours[week][1]);
        }

        // Add placeholder data for other months
        String[] otherMonths = {"July", "August", "September", "October", "November", "December"};
        for (String month : otherMonths) {
            for (int week = 1; week <= 4; week++) {
                hoursData.addHours(month, week, 0.0, 0.0); // Placeholder data
            }
        }

        return new Employee(empId, lastName, firstName, password, hourlyRate, hoursData);
    }

    // Method to find an employee by ID
    public static Employee getEmployee(int empId, List<Employee> employees) {
        for (Employee emp : employees) {
            if (emp.getEmployeeNumber() == empId) {
                return emp;
            }
        }
        return null; // Employee not found
    }
}