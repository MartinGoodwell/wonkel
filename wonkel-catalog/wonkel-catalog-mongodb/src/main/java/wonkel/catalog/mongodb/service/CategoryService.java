package wonkel.catalog.mongodb.service;

import org.springframework.stereotype.Service;

import wonkel.catalog.model.Category;

/**
 * Service classes like these usually directly access the database.<br/>
 * As we're only working with a very small set of data and it's all about
 * getting started quickly, I decided to do it the hardcoded way here.<br/>
 * Once the solution has made some progress on other ends, I'll go and make this
 * more real-life usable.
 * 
 * @author MartinGoodwell
 *
 */
@Service
public class CategoryService {

  //@formatter:off
  private final Category[] categories = new Category[]{
    new Category(1l, "Action"), 
    new Category(2l, "Adventure"), 
    new Category(3l, "Animation"),
    new Category(4l, "Children"),
    new Category(5l, "Comedy"),
    new Category(6l, "Crime"),
    new Category(7l, "Documentary"),
    new Category(8l, "Drama"),
    new Category(9l, "Family"),
    new Category(10l, "Fantasy"),
    new Category(11l, "Food"),
    new Category(12l, "Game Show"),
    new Category(13l, "Home and Garden"),
    new Category(14l, "Horror"),
    new Category(15l, "Mini-Series"),
    new Category(16l, "News"),
    new Category(17l, "Reality"),
    new Category(18l, "Science-Fiction"),
    new Category(19l, "Soap"),
    new Category(20l, "Special Interest"),
    new Category(21l, "Sport"),
    new Category(22l, "Suspense"),
    new Category(23l, "Talk Show"),
    new Category(24l, "Thriller"),
    new Category(25l, "Western"),
    new Category(26l, "Travel"),
    new Category(27l, "Mystery"),
    new Category(28l, "Romance")
  };
  //@formatter:on

  public Category[] getCategories() {
    return categories.clone();
  }

}
