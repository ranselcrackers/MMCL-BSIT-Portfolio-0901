/**
 * This code is made by Ransel Sumatra.
 * GitHub: https://github.com/ranselcrackers/
 * GitHub Username: ranselcrackers
 * Specialization: BSIT Major in Marketing Technologies at Mapúa Malayan Colleges Laguna
 */

/**
 * This class represents an employee and their details.
 */
public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String password;
    private double hourlyRate;
    private HoursData hoursData; // Add HoursData object

    public Employee(int employeeNumber, String lastName, String firstName, 
                    String password, double hourlyRate, HoursData hoursData) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.hourlyRate = hourlyRate;
        this.hoursData = hoursData;
    }

    // Validate password
    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Getters
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public HoursData getHoursData() {
        return hoursData;
    }
}