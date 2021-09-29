package micro.service.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"support.service.a"})
public class MicroServiceAApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroServiceAApplication.class, args);
  }

}
