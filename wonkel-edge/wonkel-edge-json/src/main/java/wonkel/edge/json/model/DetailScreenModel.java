package wonkel.edge.json.model;

import java.util.List;

import wonkel.catalog.model.Category;
import wonkel.catalog.model.Product;

public class DetailScreenModel {

  private List<Category> categories;
  private Product product;

  public DetailScreenModel(Product product, List<Category> categories) {
    this.product = product;
    this.categories = categories;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public Product getProduct() {
    return product;
  }
}
