package com.nagarro.nagp.nagpdevopsassignment.service;

import com.nagarro.nagp.nagpdevopsassignment.model.request.AccountRequestDTO;
import com.nagarro.nagp.nagpdevopsassignment.model.response.AccountResponseDTO;

import java.util.List;

public interface AccountService {

    List<AccountResponseDTO> getAll();

    AccountResponseDTO get(Long id);

    void save(AccountRequestDTO accountRequestDTO);

    void delete(Long id);

    void update(AccountRequestDTO accountRequestDTO);

    AccountResponseDTO getByUsername(String username);
}
