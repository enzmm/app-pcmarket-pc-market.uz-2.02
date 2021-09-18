package uz.pdp.apppcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket.entity.Orders;

import java.util.Date;

@Projection(types = Orders.class)
public interface CustomOrders {

    Integer getCount();
    Date getDateCreated();
    String getPhoneNumber();
    String getAddress();
    boolean getIsArrived();
    boolean getIsPayed();
}
