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

        // Employee 1 - CEO
        employees.add(createEmployee(
            10001, "Garcia", "Manuel III", "password123", 
            "Chief Executive Officer", 535.71,
            // June hours
            new double[][]{{42.5, 2.5}, {43.5, 3.5}, {43.5, 3.5}, {43.5, 3.5}},
            // July-December hours
            new double[][][]{
                {{40.0, 1.5}, {38.0, 0.0}, {42.0, 2.0}, {41.5, 1.0}}, // July
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},    // August
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},    // September
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},    // October
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},    // November
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}}     // December
            },
            "44-4506057-3", "820126853951", "442-605-657-000", "691295330870"
        ));

        // Employee 2 - Developer
        employees.add(createEmployee(
            10002, "Lim", "Antonio", "password123", 
            "Software Developer", 500.00,
            // June hours
            new double[][]{{46.5, 6.5}, {45.5, 5.5}, {45.5, 5.5}, {45.5, 5.5}},
            // July-December hours
            new double[][][]{
                {{40.0, 0.0}, {40.0, 0.0}, {40.0, 0.0}, {40.0, 0.0}}, // July
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},     // August
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},     // September
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},     // October
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}},     // November
                {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}}      // December
            },
            "123456789", "123456789012", "123-456-789-000", "123456789012"
        ));

        return employees;
    }

    public static Employee getEmployee(int empId, List<Employee> employees) {
        for (Employee emp : employees) {
            if (emp.getEmployeeNumber() == empId) {
                return emp;
            }
        }
        return null;
    }

    private static Employee createEmployee(int empId, String lastName, String firstName, 
                                         String password, String position, double hourlyRate,
                                         double[][] juneHours, double[][][] remainingMonthsHours,
                                         String sssNumber, String philhealthNumber,
                                         String tinNumber, String pagibigNumber) {
        HoursData hoursData = new HoursData(empId, 40);

        // Add June hours
        addMonthlyHours(hoursData, "June", juneHours);

        // Add July-December hours
        String[] months = {"July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            addMonthlyHours(hoursData, months[i], remainingMonthsHours[i]);
        }

        return new Employee(empId, lastName, firstName, password, position, hourlyRate,
                           hoursData, sssNumber, philhealthNumber, tinNumber, pagibigNumber);
    }

    private static void addMonthlyHours(HoursData hoursData, String month, double[][] weeklyHours) {
        for (int week = 0; week < weeklyHours.length; week++) {
            hoursData.addHours(
                month, 
                week + 1, 
                weeklyHours[week][0], // Regular hours
                weeklyHours[week][1]  // Overtime hours
            );
        }
    }
}