package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.constant.AccountConstant;
import com.eazybytes.accounts.dto.AccountDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Account;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.exceptions.CustomerAlreadyExistsExceptions;
import com.eazybytes.accounts.exceptions.ResourceNotFoundExceptions;
import com.eazybytes.accounts.mappers.AccountMapper;
import com.eazybytes.accounts.mappers.CustomerMapper;
import com.eazybytes.accounts.repository.AccountRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    /**
     * Creates a new customer account.
     *
     * @param customerDto containing customer details
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toCustomer(customerDto);
        Optional<Customer> customerOptional = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (customerOptional.isPresent()) {
            throw new CustomerAlreadyExistsExceptions("Mobile number already exists " + customer.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() ->
                new ResourceNotFoundExceptions("Customer", "mobileNumber", mobileNumber)
        );
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(() ->
                new ResourceNotFoundExceptions("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.toCustomerDto(customer);
        customerDto.setAccount(AccountMapper.toAccountDto(account));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountDto = customerDto.getAccount();
        if(accountDto != null) {
            Account account = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(() ->
                    new ResourceNotFoundExceptions("Account", "accountNumber", accountDto.getAccountNumber().toString())
            );
            AccountMapper.toAccount(accountDto, account);
            account.setUpdatedBy("admin");
            account.setUpdatedAt(LocalDateTime.now());
            accountRepository.save(account);

            Customer customer = customerRepository.findById(account.getCustomerId()).orElseThrow(() ->
                    new ResourceNotFoundExceptions("Customer", "customerId", account.getCustomerId().toString())
            );
            CustomerMapper.toCustomer(customerDto, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() ->
                new ResourceNotFoundExceptions("Customer", "mobileNumber", mobileNumber)
        );
        customerRepository.delete(customer);
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        return true;
    }

    private Account createNewAccount(Customer customer) {
        Account account = new Account();
        account.setCustomerId(customer.getCustomerId());
        account.setAccountNumber(1000000000L + new Random().nextInt(900000000));
        account.setAccountType(AccountConstant.SAVINGS);
        account.setBranchAddress(AccountConstant.ADDRESS);
        return accountRepository.save(account);
    }
}
