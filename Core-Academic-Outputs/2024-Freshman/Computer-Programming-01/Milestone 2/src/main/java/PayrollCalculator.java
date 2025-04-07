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
        System.out.println("|                      PAYROLL STATEMENT                      |");
        System.out.println("+-------------------------------------------------------------+");

        // Payroll Statement (no right outline)
        System.out.println("Employee: " + employee.getFullName());
        System.out.println("Employee #: " + employee.getEmployeeNumber());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Hourly Rate: PHP " + employee.getHourlyRate());
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("\n");

        // Government Agency Details (with right outline
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                   Government Agency Details                 |");
        System.out.println("+-------------------------------------------------------------+");
        
        //Government Agency Details (no right outline)
        System.out.println("SSS #: " + employee.getSssNumber());
        System.out.println("PhilHealth #: " + employee.getPhilhealthNumber());
        System.out.println("TIN #: " + employee.getTinNumber());
        System.out.println("Pag-IBIG #: " + employee.getPagibigNumber());
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("\n");
        
        //Payroll Calculations (no right outline) 
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("Period: " + month + " Week " + week);
        System.out.printf("Basic Pay: PHP %.2f\n", basicPay);
        System.out.printf("Overtime Pay: PHP %.2f\n", overtimePay);
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("\n");

        // Government Deductions (no right outline) 
        System.out.println("+-------------------------------------------------------------+");
        System.out.printf("SSS Deduction: PHP %.2f\n", sss);
        System.out.printf("PhilHealth Deduction: PHP %.2f\n", philhealth);
        System.out.printf("Pag-IBIG Deduction: PHP %.2f\n", pagibig);
        System.out.printf("Withholding Tax: PHP %.2f\n", withholdingTax);
        System.out.println("+------------------------------------------------------------+");
        System.out.println("\n");

        // Net Pay (no right outline) 
        System.out.println("+------------------------------------------------------------+");
        System.out.printf("Net Pay: PHP %.2f\n", netPay);
        System.out.println("+------------------------------------------------------------+");

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
