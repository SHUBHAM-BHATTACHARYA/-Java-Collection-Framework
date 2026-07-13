import java.awt.desktop.SystemEventListener;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAnalysis {

    //Find how many male and female employees are in the organization
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

    //Group employees by gender
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

    //Count the number of employees in each department
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

    //Retrieve employee phone numbers in a List
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

    //Group the Employees by city
    public void groupEmployeeByCity(){
        List<Employee> employees = EmployeeList.getemployeeList();
        Map<String, List<Employee>> empByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employees grouped by city :: \n" + empByCity);
    }
}
