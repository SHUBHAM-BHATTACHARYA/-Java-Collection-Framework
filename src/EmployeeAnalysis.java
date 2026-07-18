import java.awt.desktop.SystemEventListener;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeAnalysis {

    //1. Find how many male and female employees are in the organization
    public void genderCount(){
        List<Employee> employees = EmployeeList.getemployeeList();
        System.out.println(employees);

        Map<String, Long> genderCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderCount);

        genderCount.forEach((gender, count)->{
            System.out.println(gender+" Employees: "+count);
        });
    }

    //2. Group employees by gender
    public void genderMap(){
        List<Employee> employees = EmployeeList.getemployeeList();
        System.out.println(employees);

        Map<String, List<Employee>> genderMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println(genderMap);

        genderMap.forEach((gender, employeeList)->{
            System.out.println(gender + " Employee Name: ");
            employeeList.forEach(employee->{
                System.out.printf(employee.getName()+", ");
            });
            System.out.println();
        });
    }

    //3. Count the number of employees in each department
    public void departmentCount(){
        List<Employee> employees = EmployeeList.getemployeeList();
        System.out.println(employees);

        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(departmentCount);

        departmentCount.forEach((department, countEmployee)->{
            System.out.println(department + " Contains " + countEmployee + " employees ");
        });
    }

    //4. Retrieve employee phone numbers in a List
    public void getPhoneList(){
        List<Employee> employees = EmployeeList.getemployeeList();
        System.out.println(employees);

        List<String> phoneList = employees.stream()
                .map(Employee::getPhoneNumber) // Extracts the phone number from each Employee
                .collect(Collectors.toList()); // Collects the results into a new List
        System.out.println(phoneList);
    }

    /*
    stream(): Converts your employeeList collection into a sequential stream of Employee objects
    map(Employee::getPhoneNumber): Transforms each element of the stream by calling the getPhoneNumber method, mapping an Employee object into a String (the phone number)
    collect(Collectors.toList()): Formulates a terminal operation that gathers the stream's resulting data back into a standard List collection.
    */

    //5. Group the Employees by city
    public void groupEmployeeByCity(){
        List<Employee> employees = EmployeeList.getemployeeList();
        Map<String, List<Employee>> empByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employees grouped by city :: \n" + empByCity);
    }

    //6. Group the Employees by age
    public void groupEmployeesByAge(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        Map<Integer, List<Employee>> groupEmployeesByAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("Employees grouped by age :: \n" + groupEmployeesByAge);
    }

    //7. Find the count of male and female present in each department
    public void genderMapInDept(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        Map<String, Map<String, Long>> genderMapInDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println(genderMapInDept);
    }

    //8. Print the names of all distinct departments in the organization.
    public void distinctDepartments(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        List<String> distinctDepartments = employeeList.stream()
                        .map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(distinctDepartments);
    }

    //9. Print employee details whose age is greater than 28 in the organisation
    public void employeeAgeGreaterThan28(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        List<Employee> employeeAgeGreaterThan28 = employeeList.stream()
                        .filter(employee -> employee.getAge()>28)
                                .collect(Collectors.toList());
        System.out.println(employeeAgeGreaterThan28);
    }

    //10. Find maximum age/oldest of employee in the organisation
    public void maximumAgeEmployee(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        Optional<Employee> maximumAgeEmployee = employeeList.stream()
                        .max(Comparator.comparingInt(Employee::getAge));
        System.out.println(maximumAgeEmployee);
    }

    //11. Print Average age of Male and Female Employees in the organisation
    public void averageAgeOfMaleAndFemaleEmployees(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        Map<String, Double> averageAgeOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));
        System.out.println(averageAgeOfMaleAndFemaleEmployees);
    }

    //12. Print Average age of Male and Female Employees in each department
    public void averageAgeOfMaleAndFemaleEmployeesEachDepartment(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        Map<String, Map<String, Double>> averageAgeOfMaleAndFemaleEmployeesEachDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge))));
        System.out.println(averageAgeOfMaleAndFemaleEmployeesEachDepartment);
    }

    //13. Find longest serving employees in the organization
    public void longestServingEmployees(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        Optional<Employee> longestServingEmployees = employeeList.stream()
                        .min(Comparator.comparingInt(Employee::getYearOfJoining));
        System.out.println(longestServingEmployees);
    }

    //14. Find longest serving employee in each department
    public void longestServingEmployeesEachDepartment(){
        List<Employee> employeeList = EmployeeList.getemployeeList();
        Map<String, Optional<Employee>> longestServingEmployeesEachDepartment = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining))));
        System.out.println(longestServingEmployeesEachDepartment);
    }
}
