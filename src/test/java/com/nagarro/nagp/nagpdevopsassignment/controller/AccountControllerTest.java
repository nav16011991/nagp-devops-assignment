package com.nagarro.nagp.nagpdevopsassignment.controller;


import com.nagarro.nagp.nagpdevopsassignment.model.response.AccountResponseDTO;
import com.nagarro.nagp.nagpdevopsassignment.service.AccountService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Before
    public void setup() {
    }

    @Test
    public void shouldRetrieveAnEntity() {
        // Given
        Mockito.when(this.accountService.getAll()).thenReturn(Arrays.asList(new AccountResponseDTO()));
        // When
        ResponseEntity<List<AccountResponseDTO>> actualResponse = this.accountController.getAll();
        // Then
        Assert.assertThat(actualResponse.getStatusCode(), Matchers.equalTo(HttpStatus.OK));
        Assert.assertNotNull(actualResponse.getBody());
    }
}
