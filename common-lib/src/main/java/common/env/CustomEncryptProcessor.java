package common.env;//package org.rootnet.common.env;
//
//import java.util.HashMap;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.env.EnvironmentPostProcessor;
//import org.springframework.boot.env.OriginTrackedMapPropertySource;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.core.env.PropertySource;
//
//public class CustomEncryptProcessor implements EnvironmentPostProcessor {
//
//  @Override
//  public void postProcessEnvironment(ConfigurableEnvironment environment,
//      SpringApplication application) {
//    /**
//     * 命令行中获取密钥
//     */
//    String mpwKey = "Famous@2021";
//
//    /**
//     * 处理加密内容
//     */
//    HashMap<String, Object> map = new HashMap<>();
//    for (PropertySource<?> ps : environment.getPropertySources()) {
//      if (ps instanceof OriginTrackedMapPropertySource) {
//        OriginTrackedMapPropertySource source = (OriginTrackedMapPropertySource) ps;
//        for (String name : source.getPropertyNames()) {
//          Object value = source.getProperty(name);
//          if (value instanceof String) {
//            String str = (String) value;
//            if (str.startsWith("enc->")) {
//              map.put(name, "root");
//            }
//          }
//        }
//      }
//    }
//    // 将解密的数据放入环境变量，并处于第一优先级上
//    if (map.size() > 0) {
//      environment.getPropertySources().addFirst(new MapPropertySource("famous-encrypt", map));
//    }
//  }
//}
