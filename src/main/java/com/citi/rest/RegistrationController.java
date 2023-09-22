/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.citi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

//@ComponentScan(basePackages = {"com.aws.rest"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("youthVote/pennsylvania/registration")
public class RegistrationController {
    private final DynamoDBService dynamoDBService;

    @Autowired
    RegistrationController(
        DynamoDBService dbService
    ) {
        this.dynamoDBService = dbService;
    }

    @GetMapping("/all")
    public List<VoterRegistrationDAO> getAllVoters(@RequestParam(required=false) String archived) {
        return dynamoDBService.getAllItems();
    }

    @GetMapping("")
    public VoterRegistrationDAO getVoterRegistrationStatus(@RequestParam String registrationNumber) {
        return dynamoDBService.getRegistrationStatus(registrationNumber);
    }

    @PostMapping("")
    public String addItem(@RequestBody Map<String, String> payload) {
        String firstName = payload.get("firstName");
        String lastName = payload.get("lastName");
        String addressLine1 = payload.get("addressLine1");
        String addressLine2 = payload.get("addressLine2");
        String county = payload.get("county");
        String emailId = payload.get("emailId");
        String phoneNumber = payload.get("phoneNumber");
        String zipCode  =  payload.get("zipCode");
        String dateOfBirth = payload.get("dateOfBirth");


        VoterRegistrationDAO voterRegistration = new VoterRegistrationDAO();
        voterRegistration.setCounty(county);
        voterRegistration.setAddressLine2(addressLine1);
        voterRegistration.setAddressLine2(addressLine2);
        voterRegistration.setEmailAddress(emailId);
        voterRegistration.setDateOfBirth(dateOfBirth);
        voterRegistration.setPhoneNumber(phoneNumber);
        voterRegistration.setFirstName(firstName);
        voterRegistration.setLastName(lastName);
        voterRegistration.setZipCode(Integer.parseInt(zipCode));


        return dynamoDBService.addRegistration(voterRegistration);

    }
}