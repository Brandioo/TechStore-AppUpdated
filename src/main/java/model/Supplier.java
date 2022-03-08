package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "suppliers")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierID")
    private Integer supplierID;
    private String supplierCompanyName;
    private String product;
    private Integer quantity;
    private Integer price;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @OneToMany(mappedBy = "suppliers")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Computers> computers = new HashSet<>();

    public Supplier(String supplierCompanyName, String product, Integer quantity, Integer price, LocalDateTime createdOn) {
        this.supplierCompanyName = supplierCompanyName;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.createdOn = createdOn;
    }

    public Supplier() {

    }
}
