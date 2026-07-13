import java.util.Arrays;
import java.util.List;

public class EmployeeList {
    public static List<Employee> getemployeeList() {

        List<Employee> empList = Arrays.asList(

                new Employee(101, "Amit Sharma", 28, "Male", "IT", 2018, 75000, "9568745126", "Kolkata"),
                new Employee(102, "Neha Verma", 26, "Female", "HR", 2020, 50000, "9856478125", "Hyderabad"),
                new Employee(103, "Ravi Kumar", 35, "Male", "Finance", 2012, 90000, "2568974512", "Chennai"),
                new Employee(104, "Sonal Gupta", 31, "Female", "Marketing", 2015, 67000, "5689745123", "Chennai"),
                new Employee(105, "Rahul Singh", 29, "Male", "IT", 2019, 82000, "5689745823", "Noida"),
                new Employee(106, "Pooja Rani", 25, "Female", "Sales", 2021, 48000, "2356897451", "Gurugram"),
                new Employee(107, "Arjun Mehta", 33, "Male", "Finance", 2013, 98000, "6598745123", "Pune"),
                new Employee(108, "Kavita Joshi", 30, "Female", "HR", 2016, 60000, "3568974512", "Trivandam"),
                new Employee(109, "Suresh Iyer", 42, "Male", "Operations", 2010, 105000, "2569845125", "Blore"),
                new Employee(110, "Divya Nair", 27, "Female", "Marketing", 2019, 59000, "4589712568", "Pune"),
                new Employee(111, "Mohit Yadav", 38, "Male", "IT", 2011, 110000, "4257894512", "Hyderabad"),
                new Employee(112, "Preeti Sharma", 24, "Female", "Sales", 2022, 45000, "8457956123", "Trivandam"),
                new Employee(113, "Manish Tiwari", 37, "Male", "Finance", 2009, 120000, "2659874512","Gurugram"),
                new Employee(114, "Anjali Chauhan", 32, "Female", "IT", 2014, 87000, "3256125874", "Bangalore"),
                new Employee(115, "Nikhil Rane", 29, "Male", "Operations", 2017, 71000, "5325687412", "Mumbai")
        );
        return empList;

    }
}
