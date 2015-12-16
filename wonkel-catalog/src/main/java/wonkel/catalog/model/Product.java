package wonkel.catalog.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  private long id;
  private String title;
  private String description;
  private String imagePath;

  public Product(long id, String title, String description, String imagePath) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.imagePath = imagePath;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getImagePath() {
    return imagePath;
  }
}
