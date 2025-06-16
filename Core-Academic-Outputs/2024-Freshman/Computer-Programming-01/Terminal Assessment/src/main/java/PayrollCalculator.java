/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ransel
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

        // Modified display using phase 1 format
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                      PAYROLL STATEMENT                      |");
        System.out.println("+-------------------------------------------------------------+");
        
        // Employee Info Section
        employee.displayEmployeeInfo();
        
        // Payroll Details
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                      PAYROLL DETAILS                        |");
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("  %-25s: %-40s\n", "Pay Period", month + " Week " + week);
        System.out.printf("  %-25s: PHP %-40.2f\n", "Basic Pay", basicPay);
        System.out.printf("  %-25s: PHP %-40.2f\n", "Overtime Pay", overtimePay);
        System.out.printf("  %-25s: PHP %-40.2f\n", "Rice Subsidy", employee.getRiceSubsidy());
        System.out.printf("  %-25s: PHP %-40.2f\n", "Phone Allowance", employee.getPhoneAllowance());
        System.out.printf("  %-25s: PHP %-40.2f\n", "Clothing Allowance", employee.getClothingAllowance());
        
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                      DEDUCTIONS                             |");
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("  %-25s: PHP %-40.2f\n", "SSS Contribution", sss);
        System.out.printf("  %-25s: PHP %-40.2f\n", "PhilHealth", philhealth);
        System.out.printf("  %-25s: PHP %-40.2f\n", "Pag-IBIG", pagibig);
        System.out.printf("  %-25s: PHP %-40.2f\n", "Withholding Tax", withholdingTax);
        
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("  %-25s: PHP %-40.2f\n", "Net Pay", netPay);
        System.out.println("+-------------------------------------------------------------+");
    }
}

