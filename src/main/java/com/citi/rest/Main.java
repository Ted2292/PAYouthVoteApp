package com.citi.rest;

import java.util.List;

public class Main {

    public static void mains(String[] args) {
        DynamoDBService dynamoDBService = new DynamoDBService();
        List<VoterRegistrationDAO> items = dynamoDBService.getAllItems();

        items.forEach(voterRegistrationDAO -> System.out.println(voterRegistrationDAO));

        List<PollLocationDAO> pollLocations = dynamoDBService.getAllPollLocations();

        pollLocations.forEach(pollLocation -> System.out.println(pollLocation));

    }
}
