package support.service.a.client;

import common.auth.AuthConstant;
import javax.validation.constraints.NotBlank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import support.service.a.DataCenterConstants;
import support.service.a.dto.GenericAccountResponse;
import support.service.a.dto.ListAccountResponse;

@FeignClient(name = DataCenterConstants.SERVICE_NAME, path = "/support/a/account")
public interface AccountClient {

  @GetMapping(path = "/list")
  ListAccountResponse listAccounts();


  @GetMapping(path = "/get")
  GenericAccountResponse getAccount(
      @RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz,
      @RequestParam @NotBlank String userId);

}
