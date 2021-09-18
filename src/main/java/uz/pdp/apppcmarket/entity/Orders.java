package uz.pdp.apppcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    private Integer count;
    private Date dateCreated;
    private String phoneNumber;
    private String address;
    private boolean isArrived;
    private boolean isPayed;

    @OneToOne
    private Product product;
}
