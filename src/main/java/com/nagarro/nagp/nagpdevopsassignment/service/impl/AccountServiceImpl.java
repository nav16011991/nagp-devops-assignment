package com.nagarro.nagp.nagpdevopsassignment.service.impl;

import com.nagarro.nagp.nagpdevopsassignment.mapper.AccountMapper;
import com.nagarro.nagp.nagpdevopsassignment.model.common.UserRole;
import com.nagarro.nagp.nagpdevopsassignment.model.request.AccountRequestDTO;
import com.nagarro.nagp.nagpdevopsassignment.model.response.AccountResponseDTO;
import com.nagarro.nagp.nagpdevopsassignment.persistence.repository.AccountRepository;
import com.nagarro.nagp.nagpdevopsassignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountResponseDTO> getAll() {
        return accountRepository.findAll().stream().map(AccountMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public AccountResponseDTO get(Long id) {
        return AccountMapper.toDTO(accountRepository.findById(id).orElse(null));
    }

    @Override
    public void save(AccountRequestDTO accountRequestDTO) {
        accountRequestDTO.setAccountId(UUID.randomUUID().toString());
        accountRepository.save(AccountMapper.toEntity(accountRequestDTO));
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void update(AccountRequestDTO accountRequestDTO) {
        accountRepository.save(AccountMapper.toEntity(accountRequestDTO));
    }

    @Override
    public AccountResponseDTO getByUsername(String username) {
        return AccountMapper.toDTO(accountRepository.findByUsername(username).orElse(null));
    }
}
