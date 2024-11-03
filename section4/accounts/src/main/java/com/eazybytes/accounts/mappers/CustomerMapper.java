package com.eazybytes.accounts.mappers;

import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerMapper {

    public static CustomerDto toCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .build();
    }

    public static Customer toCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .mobileNumber(customerDto.getMobileNumber())
                .build();
    }

    public static CustomerDto toCustomerDto(CustomerDto customerDto, Customer customer) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer toCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
