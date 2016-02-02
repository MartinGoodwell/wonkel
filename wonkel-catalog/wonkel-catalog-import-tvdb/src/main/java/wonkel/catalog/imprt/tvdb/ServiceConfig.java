package wonkel.catalog.imprt.tvdb;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("wonkel.catalog.imprt.tvdb.mapper")
@EnableFeignClients("wonkel.catalog.client")
@EnableDiscoveryClient
public class ServiceConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource result = new DriverManagerDataSource();
    result.setDriverClassName("com.mysql.jdbc.Driver");
    result.setUrl("jdbc:mysql://localhost:3306/tvdb");
    //result.setUsername("tvdb");
    //result.setPassword("tvdb");
    
    
    return result;
  }
  
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean result = new SqlSessionFactoryBean();
    result.setDataSource(dataSource());
    
    return result.getObject();
  }

}
