package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Orders;
import uz.pdp.apppcmarket.projection.CustomMenu;
import uz.pdp.apppcmarket.projection.CustomOrders;

@RepositoryRestResource(path = "orders", excerptProjection = CustomOrders.class)
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
