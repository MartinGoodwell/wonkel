package wonkel.edge.json.command;

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
public class HystrixProductDetailCommand extends HystrixCommand<Product> {

  private WonkelProductGetClient productClient;
  private Long productId;
  
  public HystrixProductDetailCommand(HystrixCommandGroupKey group) {
    super(group);
  }
  
  public HystrixProductDetailCommand() {
    super(HystrixCommandGroupKey.Factory.asKey("Product"));
  }
  
  @Override
  public Product execute() {
    if (this.productId == null) {
      throw new IllegalStateException("you must use execute(productId)");
    }
    return super.execute();
  }
  
  public Product execute(Long productId) {
    this.productId = productId;
    return this.execute();
  }
  
  @Override
  protected Product run() throws Exception {
    return productClient.product(productId);
  }
  
  
  @Autowired
  public void setProductClient(WonkelProductGetClient productClient) {
    this.productClient = productClient;
  }


}
