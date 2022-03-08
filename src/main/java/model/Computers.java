package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "computers")
@Data
public class Computers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computerID")
    private Integer computerID;
    private String computerName;
    private String ComputerType;
    private String isbn;
    private LocalDateTime dateOfPublication;
    private Integer quantity;
    private Integer price;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @OneToMany(mappedBy = "computers")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CartelRecord> cartelRecords = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "suppliers_supplierID")
    private Supplier suppliers;

    public Computers(String bookName, String genere, String isbn, Integer quantity, Integer price, LocalDateTime createdOn, Supplier supplierID) {
        this.computerName = bookName;
        this.ComputerType = genere;
        this.isbn = isbn;
        this.quantity = quantity;
        this.price = price;
        this.createdOn = createdOn;
        this.suppliers=supplierID;
    }



    public Computers() {

    }
}
