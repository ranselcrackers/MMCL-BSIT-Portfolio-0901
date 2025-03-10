/**
 * This code is made by Ransel Sumatra.
 * GitHub: https://github.com/ranselcrackers/
 * GitHub Username: ranselcrackers
 * Specialization: BSIT Major in Marketing Technologies at Mapúa Malayan Colleges Laguna
 */

public class Employee {
    // Employee Details
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    private String address;
    private String phoneNumber;

    // Government IDs
    private String sssNumber;
    private String philhealthNumber;
    private String tinNumber;
    private String pagibigNumber;

    // Employment Details
    private String status;
    private String position;
    private String immediateSupervisor;

    // Salary and Allowances
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;

    // Constructor
    public Employee(int employeeNumber, String lastName, String firstName, String birthday, String address,
                    String phoneNumber, String sssNumber, String philhealthNumber, String tinNumber,
                    String pagibigNumber, String status, String position, String immediateSupervisor,
                    double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance,
                    double grossSemiMonthlyRate, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philhealthNumber = philhealthNumber;
        this.tinNumber = tinNumber;
        this.pagibigNumber = pagibigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    // Method to display employee information
    public void displayEmployeeInfo() {
        // Top border (with right outline)
        System.out.println("+-------------------------------------------------------------+");

        // Header (with right outline)
        System.out.println("|                      EMPLOYEE INFORMATION                   |");
        System.out.println("+-------------------------------------------------------------+");

        // Employee Details (no right outline)
        System.out.printf("  %-25s: %-40s\n", "Employee #", employeeNumber);
        System.out.printf("  %-25s: %-40s\n", "Name", firstName + " " + lastName);
        System.out.printf("  %-25s: %-40s\n", "Birthday", birthday);

        // Split address into two lines if it's too long
        String[] addressLines = splitAddress(address, 40); // Split address into 40-character lines
        System.out.printf("  %-25s: %-40s\n", "Address", addressLines[0]); // First line of address
        System.out.printf("  %-25s  %-40s\n", "", addressLines[1]);       // Second line of address (no label)

        System.out.printf("  %-25s: %-40s\n", "Phone Number", phoneNumber);

        // Government IDs header (with right outline)
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                      GOVERNMENT IDS                         |");
        System.out.println("+-------------------------------------------------------------+");

        // Government IDs details (no right outline)
        System.out.printf("  %-25s: %-40s\n", "SSS #", sssNumber);
        System.out.printf("  %-25s: %-40s\n", "Philhealth #", philhealthNumber);
        System.out.printf("  %-25s: %-40s\n", "TIN #", tinNumber);
        System.out.printf("  %-25s: %-40s\n", "Pag-ibig #", pagibigNumber);

        // Employment Details header (with right outline)
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                      EMPLOYMENT DETAILS                     |");
        System.out.println("+-------------------------------------------------------------+");

        // Employment Details (no right outline)
        System.out.printf("  %-25s: %-40s\n", "Status", status);
        System.out.printf("  %-25s: %-40s\n", "Position", position);
        System.out.printf("  %-25s: %-40s\n", "Immediate Supervisor", immediateSupervisor);

        // Salary and Allowances header (with right outline)
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                      SALARY & ALLOWANCES                    |");
        System.out.println("+-------------------------------------------------------------+");

        // Salary and Allowances details (no right outline)
        System.out.printf("  %-25s: $%-40.2f\n", "Basic Salary", basicSalary);
        System.out.printf("  %-25s: $%-40.2f\n", "Rice Subsidy", riceSubsidy);
        System.out.printf("  %-25s: $%-40.2f\n", "Phone Allowance", phoneAllowance);
        System.out.printf("  %-25s: $%-40.2f\n", "Clothing Allowance", clothingAllowance);
        System.out.printf("  %-25s: $%-40.2f\n", "Gross Semi-monthly Rate", grossSemiMonthlyRate);
        System.out.printf("  %-25s: $%-40.2f\n", "Hourly Rate", hourlyRate);

        // Bottom border (with right outline)
        System.out.println("+-------------------------------------------------------------+");

        // Simple divider for the next table
        System.out.println("---------------------------------------------------------------");
    }

    // Helper method to split the address into two lines
    private String[] splitAddress(String address, int maxLength) {
        String[] lines = new String[2];
        if (address.length() <= maxLength) {
            lines[0] = address;
            lines[1] = ""; // Empty line if address is short
        } else {
            lines[0] = address.substring(0, maxLength); // First part of the address
            lines[1] = address.substring(maxLength);    // Second part of the address
        }
        return lines;
    }
}