package wonkel.catalog.model;

import javax.persistence.Id;

public class Product {

  @Id
  private Long id;
  private String title;
  private String imagePath;
  private String description;
  private String[] actors;
  private String[] genres;

  public Product() {
  }
  
  public Product(Long id, String title, String description, String imagePath,
      String[] actors, String[] genres) {
    
    this.id = id;
    this.title = title;
    this.imagePath = imagePath;
    this.description = description;
    this.actors = actors;
    this.genres = genres;
  }

  public String getDescription() {
    return description;
  }

  public String[] getActors() {
    return actors;
  }

  public String[] getGenres() {
    return genres;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getImagePath() {
    return imagePath;
  }
}
