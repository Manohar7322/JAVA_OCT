package Lab_2.com.cg.eis.service;

import Lab_2.com.cg.eis.bean.Emp;
import java.util.HashMap;
import java.util.Map;

public class Service_Impl implements Emp_service  {
	private Map<Integer, Emp> employeeMap = new HashMap<>();

    public void addEmployee(Emp employee) {
        employeeMap.put(employee.getId(), employee);
        System.out.println("Employee added successfully.");
    }

    public Emp getEmployeeById(int id) {
        return employeeMap.get(id);
    }

    public void displayEmployeeDetails(int id) {
        Emp employee = employeeMap.get(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public String findInsuranceScheme(double salary, String designation) {
        if (salary > 50000) {
            return "Premium Scheme";
        } else if (salary > 20000 && salary <= 50000) {
            return "Gold Scheme";
        } else if (salary >= 10000 && salary <= 20000) {
            return "Silver Scheme";
        } else {
            return "No Scheme";
        }
    }

    public void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Emp employee : employeeMap.values()) {
                System.out.println(employee);
            }
        }
    }

}
