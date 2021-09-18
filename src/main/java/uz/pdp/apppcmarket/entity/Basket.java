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
public class Basket {
    @Id
    private String pcName;
    private Integer count;
    private Date dateCreated;
    private Double price;

    @OneToOne
    private Product product;
}
