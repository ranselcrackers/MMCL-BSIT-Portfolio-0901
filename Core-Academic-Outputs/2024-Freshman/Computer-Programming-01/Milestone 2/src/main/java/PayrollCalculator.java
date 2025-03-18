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

        // Calculate deductions (using GovernmentContributionsCalculator)
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

        // Display payroll statement
        System.out.println("\nPAYROLL STATEMENT");
        System.out.println("Employee: " + employee.getFullName());
        System.out.println("Period: " + month + " Week " + week);
        System.out.println("----------------------------------------");
        System.out.printf("Basic Pay: %.2f\n", basicPay);
        System.out.printf("Overtime Pay: %.2f\n", overtimePay);
        System.out.println("----------------------------------------");
        System.out.printf("SSS Deduction: %.2f\n", sss);
        System.out.printf("PhilHealth Deduction: %.2f\n", philhealth);
        System.out.printf("Pag-IBIG Deduction: %.2f\n", pagibig);
        System.out.printf("Withholding Tax: %.2f\n", withholdingTax);
        System.out.println("----------------------------------------");
        System.out.printf("Net Pay: %.2f\n", netPay);
    }
} 
