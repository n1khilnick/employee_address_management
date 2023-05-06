package com.geekster.employeeaddressmanagement.repositories;

import com.geekster.employeeaddressmanagement.models.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAddressDao extends CrudRepository<Address,Long> {

    @Modifying
    @Query(value = "Update Address set street = :street where address_id = :addressId",nativeQuery = true)
    void updateStreetById(Long addressId, String street);
}
