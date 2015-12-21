package wonkel.edge.json.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.client.WonkelProductClient;
import wonkel.catalog.model.Category;
import wonkel.catalog.model.Product;
import wonkel.edge.json.command.HystrixCategoryCommand;
import wonkel.edge.json.model.MainScreenModel;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MainScreenGetController {

  private HystrixCategoryCommand catClient;
  private WonkelProductClient productClient;
   
  @RequestMapping(value="/", produces="application/json")
  public MainScreenModel loadMainScreen() {
    List<Category> categories = catClient.execute();
    List<Product> products = Collections.emptyList();
    
    MainScreenModel result = new MainScreenModel(categories, products);
    return result;
  }
  
  @Autowired
  public void setProductClient(WonkelProductClient productClient) {
    this.productClient = productClient;
  }

  @Autowired
  public void setCatClient(HystrixCategoryCommand catClient) {
    this.catClient = catClient;
  }
  
}
