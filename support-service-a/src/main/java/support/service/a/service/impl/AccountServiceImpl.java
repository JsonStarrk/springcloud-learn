package support.service.a.service.impl;

import support.service.a.domain.Account;
import support.service.a.mapper.AccountMapper;
import support.service.a.service.IAccountService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import support.service.a.dto.AccountDto;

@Service
public class AccountServiceImpl implements IAccountService {

  @Autowired
  private AccountMapper accountMapper;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public AccountDto getAccountById(String id) {
    Account account = accountMapper.selectById(id);
    return convertToDto(account);
  }

  @Override
  public List<AccountDto> list() {
    List<Account> accounts = accountMapper.selectList(null);

    List<AccountDto> dtos = new ArrayList<>();
    for (Account account : accounts) {
      dtos.add(convertToDto(account));
    }
    return dtos;
  }

  private AccountDto convertToDto(Account account) {
    return modelMapper.map(account, AccountDto.class);
  }

  private Account convertToModel(AccountDto accountDto) {
    return modelMapper.map(accountDto, Account.class);
  }
}
