package wonkel.edge.json.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.model.Category;
import wonkel.catalog.model.Product;
import wonkel.edge.json.command.HystrixCategoryCommand;
import wonkel.edge.json.command.HystrixProductOfCategoryCommand;
import wonkel.edge.json.model.MainScreenModel;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MainScreenGetController {

  private HystrixCategoryCommand catClient;
  private HystrixProductOfCategoryCommand prodClient;
   
  @RequestMapping(value="/{category}", produces="application/json")
  public MainScreenModel loadMainScreen(@PathVariable("category") String category) {
    List<Category> categories = catClient.execute();
    List<Product> products = prodClient.execute(category);
    
    MainScreenModel result = new MainScreenModel(categories, products);
    return result;
  }
  
  @Autowired
  public void setProdClient(HystrixProductOfCategoryCommand prodClient) {
    this.prodClient = prodClient;
  }

  @Autowired
  public void setCatClient(HystrixCategoryCommand catClient) {
    this.catClient = catClient;
  }
  
}
