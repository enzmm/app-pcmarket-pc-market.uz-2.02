package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Menu;
import uz.pdp.apppcmarket.entity.Property;

@Projection(types = Property.class)
public interface CustomProperty {
    Integer getId();
    String getValue();
}
