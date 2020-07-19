import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**Create class Employee and map it to the Employees table*/

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    //Duminica

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "managerId")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private Set<Employee> subalterniManager = new HashSet<Employee>();

    @ManyToMany
    @JoinTable(name = "employees_project",joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "projectId")})
    private Set<Project> projects = new HashSet<>();

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id + "\n" +
                ", firstName = '" + firstName + '\'' + "\n" +
                ", lastName = '" + lastName + '\'' + "\n" +
                ", salary = " + salary + "\n" +
                ", dateOfBirth = " + dateOfBirth + "\n" +
                ", phoneNumber = '" + phoneNumber + '\'' + "\n" +
                ", email = '" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}