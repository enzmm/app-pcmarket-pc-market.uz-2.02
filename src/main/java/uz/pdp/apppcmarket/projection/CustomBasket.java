package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Basket;

import java.util.Date;

@Projection(types = Basket.class)
public interface CustomBasket {
    String getPcName();
    Integer getCount();
    Date getDateCreated();
    Double getPrice();
}
