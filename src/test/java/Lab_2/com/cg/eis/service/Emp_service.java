package Lab_2.com.cg.eis.service;

import Lab_2.com.cg.eis.bean.Emp;

public interface Emp_service {
	void addEmployee(Emp employee);
    Emp getEmployeeById(int id);
    void displayEmployeeDetails(int id);
    String findInsuranceScheme(double salary, String designation);  
    void displayAllEmployees(); 
	
}
