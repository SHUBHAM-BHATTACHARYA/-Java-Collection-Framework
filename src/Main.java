//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //System.out.printf("Hello and welcome!");

        EmployeeAnalysis employeeAnalysis = new EmployeeAnalysis();
        employeeAnalysis.genderCount();
        employeeAnalysis.genderMap();
        employeeAnalysis.departmentCount();
        employeeAnalysis.getPhoneList();
        employeeAnalysis.groupEmployeeByCity();
    }
}