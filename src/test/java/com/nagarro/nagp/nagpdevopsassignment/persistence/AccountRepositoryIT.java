package com.nagarro.nagp.nagpdevopsassignment.persistence;

import com.nagarro.nagp.nagpdevopsassignment.NagpDevopsAssignmentApplication;
import com.nagarro.nagp.nagpdevopsassignment.model.common.UserRole;
import com.nagarro.nagp.nagpdevopsassignment.persistence.entity.AccountEntity;
import com.nagarro.nagp.nagpdevopsassignment.persistence.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { NagpDevopsAssignmentApplication.class })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountRepositoryIT {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testAccounts() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(UUID.randomUUID().toString());
        accountEntity.setFirstName("FirstName");
        accountEntity.setLastName("LastName");
        accountEntity.setUsername("TestUserName_DB");
        accountEntity.setPassword("TestPassword");
        accountEntity.setUserRole(UserRole.CUSTOMER);

        accountEntity = accountRepository.save(accountEntity);

        Assert.assertNotNull(accountEntity.getId());

        Optional<AccountEntity> fetchedAccountEntity = accountRepository.findByUsername("TestUserName_DB");
        Assert.assertEquals("FirstName", fetchedAccountEntity.get().getFirstName());

        accountRepository.deleteById(accountEntity.getId());
    }

}
