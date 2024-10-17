package Lab_2.com.cg.eis.bean;

import Lab_2.com.cg.eis.exception.EmployeeException;

public class Emp {
    private int id;
    private String name;
    private double salary;
    private String designation;
    private String insuranceScheme;

    public Emp(int id, String name, double salary, String designation) throws EmployeeException {
        if (salary < 3000) {
            throw new EmployeeException("Salary must be above 3000.");
        }
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.insuranceScheme = determineInsuranceScheme(salary, designation);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws EmployeeException {
        if (salary < 3000) {
            throw new EmployeeException("Salary must be above 3000.");
        }
        this.salary = salary;
        this.insuranceScheme = determineInsuranceScheme(salary, this.designation);
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
        this.insuranceScheme = determineInsuranceScheme(this.salary, designation);
    }

    public String getInsuranceScheme() {
        return insuranceScheme;
    }

    private String determineInsuranceScheme(double salary, String designation) {
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

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary +
               ", designation=" + designation + ", insuranceScheme=" + insuranceScheme + "]";
    }
}
