package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     * Creates a new customer account.
     *
     * @param customerDto containing customer details
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Retrieves the customer account associated with the given mobile number.
     *
     * @param mobileNumber unique identifier for the customer
     * @return customer account details
     */
    CustomerDto fetchAccount(String mobileNumber);


    /**
     * Updates the customer account associated with the given mobile number.
     *
     * @param customerDto containing updated customer details
     * @return true if the account is updated; false otherwise
     */
    boolean updateAccount(CustomerDto customerDto);


    /**
     * Deletes the customer account associated with the given mobile number.
     *
     * @param mobileNumber unique identifier for the customer
     * @return true if the account is deleted; false otherwise
     */
    boolean deleteAccount(String mobileNumber);
}
