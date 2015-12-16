package wonkel.catalog.repo;

import org.springframework.data.repository.CrudRepository;

import wonkel.catalog.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
