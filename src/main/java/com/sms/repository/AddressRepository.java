package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
