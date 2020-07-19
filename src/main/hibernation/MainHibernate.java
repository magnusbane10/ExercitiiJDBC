import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

public class MainHibernate {


    public static void main(String[] args) throws ParseException {
       /* EmployeeRepository employeeRepository = new EmployeeRepository();
        System.out.println(employeeRepository.findById(1).toString());
        System.out.println(employeeRepository.findById(2).toString());


        ProjectRepository projectRepository = new ProjectRepository();
        System.out.println(projectRepository.findById(4));

        DepartmentRepository departmentRepository = new DepartmentRepository();
        Department department = departmentRepository.findById(17);
        department.setName("ITT");
        departmentRepository.update(department);
        System.out.println(department.toString());*/

        /*Department department1 = new Department();
        department1.setName("Compliance");
        departmentRepository.save(department1);*/
        /*Department department1 = new Department();
        department1.setDepartmentId(6);
        department1.setName("cccc");
        departmentRepository.update(department1);
        System.out.println(department1);

        Date date = new SimpleDateFormat("yyyy-mm-dd").parse("1980-01-23");
        Employee employee = new Employee();
        employee.setFirstName("ion");
        employee.setLastName("ioane");
        employee.setDateOfBirth(date);
        employee.setPhoneNumber("282736638");
        employee.setEmail("gdsgf@mnkn.com");
        employee.setSalary(2000);

        employeeRepository.save(employee);
        System.out.println(employee);*/


        System.out.println("______________________________");
        //Duminica

        //stocam intro lista
        ProjectRepository projectRepository = new ProjectRepository();
        List<Project> projects = projectRepository.findAllProjects();
        for(Project project : projects){
            System.out.println(project.toString());
        }

        System.out.println("______________________________");

        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees = employeeRepository.findAllEmployees();
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }

        System.out.println("______________________________");

        employees = employeeRepository.findAllEmployeesWithLetterJ();
        for(Employee employee:employees){
            System.out.println(employee.getFirstName() + " " +
                    employee.getLastName() + " " +
                    employee.getDateOfBirth());
        }



        System.out.println("______________________________");
        employees = employeeRepository.findAllEmployeesWorkingFinance("Finance");
        for(Employee employee:employees){
            System.out.println(employee.getFirstName() + " " +
                    employee.getLastName() + " " +
                    employee.getDateOfBirth());
        }

        System.out.println("______________________________");

        employees = employeeRepository.findEmployeeOrderedByFirstName();
        for(Employee employee:employees){
            System.out.println(employee.getFirstName() + " " +
                    employee.getLastName() + " " +
                    employee.getDateOfBirth());
        }




        
        HibernateUtil.shutDown();
    }
}
