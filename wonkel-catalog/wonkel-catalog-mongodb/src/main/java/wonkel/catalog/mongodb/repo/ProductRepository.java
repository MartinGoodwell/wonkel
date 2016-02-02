package wonkel.catalog.mongodb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import wonkel.catalog.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

  @Query(fields = "{'id':1,'title':1,'imagePath':1}")
  List<Product> findByGenres(String category);
  
  @Query(fields = "{'id':1,'title':1,'imagePath':1}")
  List<Product> findByActors(String actor);
}
