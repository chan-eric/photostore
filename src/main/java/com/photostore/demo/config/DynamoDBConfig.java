package com.photostore.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
//@EnableDynamoDBRepositories(basePackages = "com.photostore.demo.repositories")
public class DynamoDBConfig {
 
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;
 
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;
 
    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
 
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB 
          = new AmazonDynamoDBClient(amazonAWSCredentials());
         
        if (amazonDynamoDBEndpoint != null && !amazonDynamoDBEndpoint.isEmpty()) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }
 
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
          amazonAWSAccessKey, amazonAWSSecretKey);
    }
}