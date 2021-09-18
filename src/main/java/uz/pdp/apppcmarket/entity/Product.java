package uz.pdp.apppcmarket.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean active;
    private String model;
    private String reference;
    private String information;
    private Double price;


    @JsonProperty("category")
    @ManyToOne()
    @RestResource(path = "category")
    private Category category;

    @OneToOne()
    @JsonProperty("photo")
    @RestResource(path = "attachment")
    private Attachment photo;

}
