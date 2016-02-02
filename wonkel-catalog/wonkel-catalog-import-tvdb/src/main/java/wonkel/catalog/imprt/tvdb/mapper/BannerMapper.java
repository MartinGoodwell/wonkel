package wonkel.catalog.imprt.tvdb.mapper;

import java.util.List;

import wonkel.catalog.imprt.tvdb.model.TvDbBanner;

public interface BannerMapper {

  List<TvDbBanner> findOnePerSeason();
}
