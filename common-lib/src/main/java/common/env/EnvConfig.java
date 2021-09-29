package common.env;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class EnvConfig {

  private String name;
  private boolean debug;
  private String externalApex;
  private String internalApex;
  private String scheme;

  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static Map<String, EnvConfig> map;

  static {
    map = new HashMap<String, EnvConfig>();
    EnvConfig envConfig = EnvConfig.builder().name(EnvConstant.ENV_DEV)
        .debug(true)
        .externalApex("famous-dev.local")
        .internalApex(EnvConstant.ENV_DEV)
        .scheme("http")
        .build();
    map.put(EnvConstant.ENV_DEV, envConfig);

    envConfig = EnvConfig.builder().name(EnvConstant.ENV_TEST)
        .debug(true)
        .externalApex("famous-test.local")
        .internalApex(EnvConstant.ENV_TEST)
        .scheme("http")
        .build();
    map.put(EnvConstant.ENV_TEST, envConfig);

    // for aliyun k8s demo, enable debug and use http and famous-uat.local
    // in real world, disable debug and use http and famous.com in UAT environment
    envConfig = EnvConfig.builder().name(EnvConstant.ENV_UAT)
        .debug(true)
        .externalApex("famous-uat.local")
        .internalApex(EnvConstant.ENV_UAT)
        .scheme("http")
        .build();
    map.put(EnvConstant.ENV_UAT, envConfig);

    envConfig = EnvConfig.builder().name(EnvConstant.ENV_PROD)
        .debug(false)
        .externalApex("famous.com")
        .internalApex(EnvConstant.ENV_PROD)
        .scheme("https")
        .build();
    map.put(EnvConstant.ENV_PROD, envConfig);
  }

  public static EnvConfig getEnvConfg(String env) {
    EnvConfig envConfig = map.get(env);
    if (envConfig == null) {
      envConfig = map.get(EnvConstant.ENV_DEV);
    }
    return envConfig;
  }
}