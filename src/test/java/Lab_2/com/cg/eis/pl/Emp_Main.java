package Lab_2.com.cg.eis.pl;
import Lab_2.com.cg.eis.bean.Emp;
import Lab_2.com.cg.eis.service.Emp_service;
import Lab_2.com.cg.eis.service.Service_Impl;
import java.util.Scanner;

public class Emp_Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Emp_service employeeService = new Service_Impl();

        while (true) {
            System.out.println("\nEmployee Insurance System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee Details");
            System.out.println("3. Find Insurance Scheme");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  
                    System.out.print("Enter Employee Designation: ");
                    String designation = scanner.nextLine();

                    Emp employee = new Emp();
                    employeeService.addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to display: ");
                    int displayId = scanner.nextInt();
                    employeeService.displayEmployeeDetails(displayId);
                    break;

                case 3:
                    System.out.print("Enter Employee Salary: ");
                    double sal = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Enter Employee Designation: ");
                    String desig = scanner.nextLine();
                    String scheme = employeeService.findInsuranceScheme(sal, desig);
                    System.out.println("Insurance Scheme: " + scheme);
                    break;

                case 4:
                    employeeService.displayAllEmployees();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
