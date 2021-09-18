package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Product;

@Projection(types = Product.class)
public interface CustomProduct {

    Integer getId();
    String getName();
    boolean getActive();
    String getReference();
    String getInformation();


}
