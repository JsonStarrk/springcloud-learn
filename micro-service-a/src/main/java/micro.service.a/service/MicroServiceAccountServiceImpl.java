package micro.service.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import support.service.a.client.AccountClient;
import support.service.a.dto.ListAccountResponse;

@Service
public class MicroServiceAccountServiceImpl implements IMicroServiceAccountService {

  @Autowired
  private AccountClient accountClient;

  @Override
  public ListAccountResponse listAccounts() {
    return accountClient.listAccounts();
  }
}
