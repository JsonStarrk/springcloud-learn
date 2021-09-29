package micro.service.a.controller;

import micro.service.a.service.IMicroServiceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import support.service.a.dto.ListAccountResponse;

@RestController
@RequestMapping("/micro/a/account")
public class MicroServiceAccountController {

  @Autowired
  private IMicroServiceAccountService microServiceAccountService;

  @GetMapping("list")
  public ListAccountResponse doSomethingUseAccount() {
    //你可以在这里基于拿到的Account做业务。该接口为演示接口，直接返回。
    return microServiceAccountService.listAccounts();
  }

}
