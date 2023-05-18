package marcato.product.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import marcato.product.entity.ProductEntity;


@ApplicationScoped
public class ProductRepository implements PanacheRepository<ProductEntity> {


}
