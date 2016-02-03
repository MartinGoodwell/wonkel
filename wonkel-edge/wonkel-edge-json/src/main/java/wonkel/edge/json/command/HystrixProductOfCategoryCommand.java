package wonkel.edge.json.command;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import wonkel.catalog.client.WonkelProductGetClient;
import wonkel.catalog.model.Product;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HystrixProductOfCategoryCommand extends HystrixCommand<Collection<Product>> {

  private WonkelProductGetClient productClient;
  private String category;

  public HystrixProductOfCategoryCommand(HystrixCommandGroupKey group) {
    super(group);
  }

  public HystrixProductOfCategoryCommand() {
    super(HystrixCommandGroupKey.Factory.asKey("Product"));
  }

  @Override
  public Collection<Product> execute() {
    if (this.category == null) {
      throw new IllegalStateException("you must use execute(category)");
    }
    return super.execute();
  }
  
  public Collection<Product> execute(String category) {
    this.category = category;
    return this.execute();
  }
  
  @Override
  protected Collection<Product> run() throws Exception {
    return productClient.products(category);
  }

  @Autowired
  public void setProductClient(WonkelProductGetClient productClient) {
    this.productClient = productClient;
  }

}
