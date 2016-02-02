package wonkel.catalog.imprt.tvdb.mapper;

import java.util.List;

import wonkel.catalog.imprt.tvdb.model.TvDbSeries;

public interface SeriesMapper {

  List<TvDbSeries> findAll();
}
