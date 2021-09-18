package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Menu;
import uz.pdp.apppcmarket.projection.CustomCategory;
import uz.pdp.apppcmarket.projection.CustomMenu;

@RepositoryRestResource(path = "menu", excerptProjection = CustomMenu.class)
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
