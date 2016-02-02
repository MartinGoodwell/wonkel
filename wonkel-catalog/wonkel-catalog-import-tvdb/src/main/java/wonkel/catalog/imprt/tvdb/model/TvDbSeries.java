package wonkel.catalog.imprt.tvdb.model;

/**
 * This is just a disposable POJO, used to temporarily store results from MySQL.
 * <br/>
 * The POJO that's used for storing data is defined in the wonkel-catalog-api
 * project.
 * 
 * @author MartinGoodwell
 *
 */
public class TvDbSeries {

  private Long id;
  private String seriesName;
  private String overview;
  private String genre;
  private String actors;
  private String imdb_id;

  public long getId() {
    return id;
  }

  public String getSeriesName() {
    return seriesName;
  }

  public String getOverview() {
    return overview;
  }

  public String getGenre() {
    return genre;
  }

  public String getActors() {
    return actors;
  }

  public String getImdbId() {
    return imdb_id;
  }

}
