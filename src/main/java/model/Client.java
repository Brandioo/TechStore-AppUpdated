package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Cartel> cartels = new HashSet<>();

    public Client(String firstName, String lastName, String email, String phoneNumber, String address, LocalDateTime createdOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdOn = createdOn;
    }

    public Client(String firstName) {
        this.firstName = firstName;
    }

    public Client() {

    }
}

