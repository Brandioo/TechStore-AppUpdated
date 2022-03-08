package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeesId;
    private String  firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String role;
    private String user;
    private String password;
    private Integer salary;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Cartel> cartels = new HashSet<>();

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String role, String user, String password, Integer salary, LocalDateTime createdOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.user = user;
        this.password = password;
        this.salary = salary;
        this.createdOn = createdOn;
    }


}
