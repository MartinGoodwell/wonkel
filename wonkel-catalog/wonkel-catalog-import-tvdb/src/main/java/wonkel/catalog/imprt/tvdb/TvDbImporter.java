package wonkel.catalog.imprt.tvdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TVDB is used as a data-source to create data for TV series.<br/>
 * Each season is to be added as a single product.<br/>
 * 
 * @author MartinGoodwell
 *
 */
@SpringBootApplication
public class TvDbImporter {

  public static void main(String[] args) {
    SpringApplication.run(TvDbImporter.class, args);
  }

}
