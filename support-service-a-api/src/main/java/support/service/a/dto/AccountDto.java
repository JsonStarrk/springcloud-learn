package support.service.a.dto;

import common.validation.PhoneNumber;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

  @NotBlank
  private Long id;
  private String name;
  private int age;
  @Email(message = "Invalid email")
  private String email;
  @PhoneNumber
  private String phoneNumber;
}