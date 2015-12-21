package wonkel.edge.json.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import wonkel.catalog.client.WonkelCategoryClient;
import wonkel.catalog.model.Category;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HystrixCategoryCommand extends HystrixCommand<List<Category>> {

  private WonkelCategoryClient catClient;

  public HystrixCategoryCommand(HystrixCommandGroupKey group) {
    super(group);
  }

  public HystrixCategoryCommand() {
    super(HystrixCommandGroupKey.Factory.asKey("Category"));
  }

  @Override
  protected List<Category> run() throws Exception {
    return catClient.categoryTree();
  }

  @Autowired
  public void setCatClient(WonkelCategoryClient catClient) {
    this.catClient = catClient;
  }

}
