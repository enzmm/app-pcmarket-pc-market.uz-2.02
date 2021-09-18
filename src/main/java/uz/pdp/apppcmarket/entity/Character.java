package uz.pdp.apppcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "characters")
public class Character  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String characterKey; // hdd, ram, sdd......
    //   private String character; // joskiy disk, operativka, .....

    // @EmbeddedId
    // ProductPK productPk;
    @ManyToOne
    private Product product;
}