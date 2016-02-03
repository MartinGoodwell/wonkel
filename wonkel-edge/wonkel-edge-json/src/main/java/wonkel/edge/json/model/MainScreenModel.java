package wonkel.edge.json.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import wonkel.catalog.model.Category;
import wonkel.catalog.model.Product;

public class MainScreenModel {
  private List<Category> categories;
  private Collection<Product> products;

  public MainScreenModel(List<Category> categories, Collection<Product> products) {
    this.categories = categories;
    this.products = products;
  }
  
  public List<Category> getCategories() {
    return Collections.unmodifiableList(categories);
  }
  
  public Collection<Product> getProducts() {
    return Collections.unmodifiableCollection(products);
  }
}
