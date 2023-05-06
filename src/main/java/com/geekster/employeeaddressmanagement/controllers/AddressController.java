package com.geekster.employeeaddressmanagement.controllers;

import com.geekster.employeeaddressmanagement.models.Address;
import com.geekster.employeeaddressmanagement.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping(value = "/")
    public String addAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @GetMapping(value = "/getAll")
    public Iterable<Address> getAddresses(){
        return addressService.fetchAllAddresses();
    }

    @GetMapping(value = "/{addressId}")
    public Optional<Address> getAddressById (@PathVariable Long addressId){
        return addressService.fetchAddressById(addressId);
    }

    @PutMapping(value = "/{addressId}/{street}")
    public void updateStreetById(@PathVariable Long addressId,@PathVariable String street){
        addressService.modifyStreetById(addressId,street);
    }

    @DeleteMapping(value = "/{addressId}")
    public String deleteAddressById(@PathVariable Long addressId){
        return addressService.removeAddressById(addressId);
    }

}
