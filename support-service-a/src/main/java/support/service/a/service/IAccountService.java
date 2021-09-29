package support.service.a.service;


import java.util.List;
import support.service.a.dto.AccountDto;

public interface IAccountService {

  AccountDto getAccountById(String id);
  List<AccountDto> list();





}
