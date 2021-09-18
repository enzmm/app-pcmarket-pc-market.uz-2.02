package uz.pdp.apppcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.apppcmarket.entity.Product;
import uz.pdp.apppcmarket.projection.CustomProduct;

import java.util.List;

@RepositoryRestResource(path = "product", excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p.* from product p,character c,property t\n" +
            "    where p.id = c.product_id\n" +
            "    and c.id =t.character_id\n"+
            "    and p.category_id =:categoryId " +
            "    and c.character_key=:character_key" +
            "    and t.value =:value",nativeQuery = true)
            List<Product> getProductsByFilterNative(Integer categoryId, String character_key, String value);
}
