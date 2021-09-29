package support.service.a.controller;

import support.service.a.service.IAccountService;
import javax.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import support.service.a.dto.AccountDto;
import support.service.a.dto.AccountList;
import support.service.a.dto.GenericAccountResponse;
import support.service.a.dto.ListAccountResponse;

@RestController
@RequestMapping("/support/a/account")
@Slf4j
public class AccountController {

  @Autowired
  private IAccountService accountService;


  @GetMapping(path = "/get")
  public GenericAccountResponse getAccount(@RequestParam @NotBlank String userId) {

//    AccountDto accountDto = AccountDto.builder().id(111L).age(18).name("json").email("389@qq.com")
//        .phoneNumber("13256551324").build();
    AccountDto accountById = accountService.getAccountById(userId);
    GenericAccountResponse genericAccountResponse = new GenericAccountResponse(accountById);
    return genericAccountResponse;
  }

  @GetMapping(path = "/list")
  public ListAccountResponse listAccounts() {

    System.out.println("收到消息");
    log.info("收到消息");
    AccountList list = new AccountList();
    list.setAccounts(accountService.list());
    ListAccountResponse response = new ListAccountResponse(list);
    return response;
  }


}
