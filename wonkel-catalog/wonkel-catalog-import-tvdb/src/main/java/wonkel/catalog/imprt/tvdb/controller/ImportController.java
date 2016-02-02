package wonkel.catalog.imprt.tvdb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.client.WonkelCategoryClient;
import wonkel.catalog.client.WonkelProductPostClient;
import wonkel.catalog.imprt.tvdb.mapper.BannerMapper;
import wonkel.catalog.imprt.tvdb.mapper.SeriesService;
import wonkel.catalog.imprt.tvdb.model.TvDbBanner;
import wonkel.catalog.imprt.tvdb.model.TvDbSeries;
import wonkel.catalog.model.Product;

@RestController
public class ImportController {

  private SeriesService seriesService;
  private BannerMapper bannerMapper;
  private WonkelProductPostClient productClient;
  private WonkelCategoryClient catClient;

  @RequestMapping(value = "/import", method = RequestMethod.GET)
  public void triggerLoad() {
    importData();
  }

  private void importData() {
    Map<Long, TvDbSeries> allSeries = seriesService.findAll();
    System.out.println("Nr of results: " + allSeries.size());
    // load seasons

    // load first season poster
    List<TvDbBanner> allBanners = bannerMapper.findOnePerSeason();
    int nrBanners = allBanners.size();
    System.out.println("Nr of banners: " + nrBanners);

    List<Product> result = new ArrayList<>(nrBanners);
    for (TvDbBanner banner : allBanners) {
      TvDbSeries series = allSeries.get(banner.getKeyvalue());
      if (series == null || StringUtils.isEmpty(series.getSeriesName())) {
        continue;
      }

      Long season = banner.getSubkey();
      String[] actors = StringUtils.tokenizeToStringArray(series.getActors(), "|", true, true);
      String[] genres = StringUtils.tokenizeToStringArray(series.getGenre(), "|", true, true);
      
      Product prod = new Product(banner.getId(),
          series.getSeriesName() + " - Season " + season, series.getOverview(),
          banner.getFilename(), actors, genres);
      System.out.println(prod.getId() + ": " + prod.getTitle() + " " + prod.getImagePath());
//      result.add(prod);
      productClient.saveProduct(prod);
    }
//    System.out.println("saving");
//    productClient.saveProducts(result);
    System.out.println("done");
  }

  @Autowired
  public void setProductClient(WonkelProductPostClient productClient) {
    this.productClient = productClient;
  }

  @Autowired
  public void setSeriesService(SeriesService seriesService) {
    this.seriesService = seriesService;
  }

  @Autowired
  public void setBannerMapper(BannerMapper bannerMapper) {
    this.bannerMapper = bannerMapper;
  }

  @Autowired
  public void setCatClient(WonkelCategoryClient catClient) {
    this.catClient = catClient;
  }
}
