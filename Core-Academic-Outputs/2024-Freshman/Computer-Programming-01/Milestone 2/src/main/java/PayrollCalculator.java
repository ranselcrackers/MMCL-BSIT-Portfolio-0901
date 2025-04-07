/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mtd solutions
 */
/**
 * This class calculates payroll based on hours worked and overtime.
 */
public class PayrollCalculator {
    public static void calculatePayroll(Employee employee, String month, int week) {
        HoursData hoursData = employee.getHoursData();
        Double[] hours = hoursData.getHours(month, week);

        if (hours == null) {
            System.out.println("No data available for " + month + " Week " + week);
            return;
        }

        double regularHours = hours[0];
        double overtimeHours = hours[1];
        double hourlyRate = employee.getHourlyRate();

        // Calculate pay
        double basicPay = regularHours * hourlyRate;
        double overtimePay = overtimeHours * hourlyRate * 1.25; // 25% overtime rate

        // Calculate deductions
        double monthlyBasic = employee.getHourlyRate() * hoursData.getAssumedRegularHours() * 4; // Approximate monthly salary
        double weeklyBasic = monthlyBasic / 4;

        double sss = GovernmentContributionsCalculator.calculateSSS(monthlyBasic) / 4;
        double philhealth = GovernmentContributionsCalculator.calculatePhilhealth(monthlyBasic) / 4;
        double pagibig = GovernmentContributionsCalculator.calculatePagIBIG(monthlyBasic) / 4;
        double withholdingTax = GovernmentContributionsCalculator.calculateWithholdingTax(weeklyBasic) / 4;

        // Calculate totals
        double grossPay = basicPay + overtimePay;
        double totalDeductions = sss + philhealth + pagibig + withholdingTax;
        double netPay = grossPay - totalDeductions;
        
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
        System.out.println("|                 GOVERNMENT AGENCY DETAILS                   |");
        System.out.println("+-------------------------------------------------------------+");

        // Government IDs details (no right outline)
        System.out.println("\nPAYROLL STATEMENT");
        System.out.println("Employee: " + employee.getFullName());
        System.out.println("Employee #: " + employee.getEmployeeNumber());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Hourly Rate: PHP " + employee.getHourlyRate());

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
