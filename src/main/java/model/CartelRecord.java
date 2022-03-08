package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cartelRecords")
@Data
public class CartelRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartelRecordId;

    private LocalDateTime dataStarted;
    private LocalDateTime endData;
    private String createData;
    private String createdBy;
    private LocalDateTime createdOn;
    private String modifiedBy;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "computersID")
    private Computers computers;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "cartelID")
    private Cartel cartel;
}
