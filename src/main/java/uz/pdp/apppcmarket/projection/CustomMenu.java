package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Category;
import uz.pdp.apppcmarket.entity.Menu;

@Projection(types = Menu.class)
public interface CustomMenu {
    Integer getId();
    String getCategoryName();
    String getServiceUrl();

}
