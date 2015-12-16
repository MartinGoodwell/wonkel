package wonkel.catalog.model;

public class Category {
  
  private long id;
  private String title;
  
  /**
   * Always make your beans immutable
   * @param id the part that's relevant for computers
   * @param title the part that's relevant for humans
   */
  public Category(long id, String title) {
    this.id = id;
    this.title = title;
  }
  
  public long getId() {
    return id;
  }
  
  public String getTitle() {
    return title;
  }
}
