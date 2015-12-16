package wonkel.edge.json.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wonkel.catalog.client.WonkelCategoryClient;
import wonkel.catalog.client.WonkelProductClient;
import wonkel.catalog.model.Category;
import wonkel.catalog.model.Product;
import wonkel.edge.json.model.MainScreenModel;

@RestController
public class MainScreenGetController {

  private WonkelCategoryClient categoryClient;
  private WonkelProductClient productClient;
   
  @RequestMapping(value="/", produces="application/json")
  public MainScreenModel loadMainScreen() {
    List<Category> categories = categoryClient.categoryTree();
    List<Product> products = Collections.emptyList();
    
    MainScreenModel result = new MainScreenModel(categories, products);
    return result;
  }
  
  @Autowired
  public void setCategoryClient(WonkelCategoryClient categoryClient) {
    this.categoryClient = categoryClient;
  }
  
  @Autowired
  public void setProductClient(WonkelProductClient productClient) {
    this.productClient = productClient;
  }
  
  
}
