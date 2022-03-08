package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cartels")
@Data
public class Cartel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartelId;
    private Integer dataCreated;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToMany(mappedBy = "cartel")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CartelRecord> cartelRecords = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "employeesId")
    private Employee employee;

    public Cartel(LocalDateTime createdOn, Client client, Employee employee) {
        this.createdOn = createdOn;
        this.client = client;
        this.employee = employee;
    }

    public Cartel() {

    }
}