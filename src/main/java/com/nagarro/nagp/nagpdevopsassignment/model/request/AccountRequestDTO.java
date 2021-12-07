package com.nagarro.nagp.nagpdevopsassignment.model.request;

import com.nagarro.nagp.nagpdevopsassignment.model.common.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDTO {

    private Long id;

    private String accountId;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private UserRole userRole;
}
