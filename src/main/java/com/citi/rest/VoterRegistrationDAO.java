/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.citi.rest;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Data
public class VoterRegistrationDAO {
    private String registrationNumber;

    private String firstName;
    private String lastName;

    private String dateOfBirth;

    private String phoneNumber;

    private String emailAddress;

    private String county;

    private String addressLine1;

    private String addressLine2;
    private Integer zipCode;
    @DynamoDbPartitionKey
    public String getRegistrationNumber() {
        return this.registrationNumber;
    };
}