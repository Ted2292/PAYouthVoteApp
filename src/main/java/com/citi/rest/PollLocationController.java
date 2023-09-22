/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.citi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@ComponentScan(basePackages = {"com.aws.rest"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("youthVote/pennsylvania/findPollLocation")
public class PollLocationController {
    private final DynamoDBService dynamoDBService;

    @Autowired
    PollLocationController(
        DynamoDBService dbService
    ) {
        this.dynamoDBService = dbService;
    }

    @GetMapping()
    public List<PollLocationDAO> getVoterRegistrationStatus(@RequestParam(required = false) Integer zipCode) {

        zipCode =  (zipCode == null)?0:zipCode;
        return dynamoDBService.getPollLocation(zipCode);
    }

}