/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.citi.rest;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
@Data
public class PollLocationDAO {
    private String county;
    private String addressLine1;
    private String addressLine2;
    private Integer zipCode;
    @DynamoDbPartitionKey
    public String getCounty() {
        return this.county;
    };

    @DynamoDbSortKey
    public Integer getZipCode(){
        return this.zipCode;
    }
}