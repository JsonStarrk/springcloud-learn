package support.service.a;

import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan({"support.service.a.mapper"})
public class SupportServiceAApplication {


  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }


  public static void main(String[] args) {

    ConfigurableApplicationContext run = SpringApplication.run(SupportServiceAApplication.class, args);

  }

}