package wonkel.catalog.imprt.tvdb.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wonkel.catalog.imprt.tvdb.model.TvDbSeries;

@Service
public class SeriesService  {

  private SeriesMapper seriesMapper;
  
  public Map<Long, TvDbSeries> findAll() {
    List<TvDbSeries> list = seriesMapper.findAll();
    
    Map<Long, TvDbSeries> result = new HashMap<>();
    for (TvDbSeries series : list) {
      result.put(series.getId(), series);
    }
    
    return result;
  }
  
  @Autowired
  public void setSeriesMapper(SeriesMapper seriesMapper) {
    this.seriesMapper = seriesMapper;
  }
}
