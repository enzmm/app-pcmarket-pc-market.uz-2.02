package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Basket;
import uz.pdp.apppcmarket.projection.CustomBasket;


@RepositoryRestResource(path = "basket", excerptProjection = CustomBasket.class)
public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
