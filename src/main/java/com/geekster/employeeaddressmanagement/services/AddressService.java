package com.geekster.employeeaddressmanagement.services;

import com.geekster.employeeaddressmanagement.repositories.IAddressDao;
import com.geekster.employeeaddressmanagement.models.Address;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressDao addressDao;

    public String saveAddress(Address address) {
        addressDao.save(address);
        return "Address Saved !";
    }

    public Iterable<Address> fetchAllAddresses() {
        return addressDao.findAll();
    }

    public Optional<Address> fetchAddressById(Long addressId) {
        if(addressId == null) return null;
        return addressDao.findById(addressId);
    }

    @Transactional
    public void modifyStreetById(Long addressId, String street) {
        addressDao.updateStreetById(addressId, street);
    }

    @Transactional
    public String removeAddressById(Long addressId) {
        if(addressId == null) return null;
        else{
            addressDao.deleteById(addressId);
            return "Address with id "+addressId+" is removed";
        }
    }
}
