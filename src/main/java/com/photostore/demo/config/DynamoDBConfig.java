package com.photostore.demo.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.photostore.demo.repositories")
public class DynamoDBConfig {
 
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;
 
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;
 
    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
 
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
    	/* Approach 1
    	AmazonDynamoDBClient ddbClient = new AmazonDynamoDBClient(amazonAWSCredentials());
    	
    	ddbClient.setEndpoint(amazonDynamoDBEndpoint);
    	ddbClient.setRegion(Region.getRegion(Regions.US_EAST_2));  
    	
    	return ddbClient;
    	*/
    	
    	/* Apporach 2
    	AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
    	        amazonDynamoDBEndpoint, Regions.US_EAST_2.getName());

    	    AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(amazonAWSCredentials());

    	    AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
    	        endpointConfiguration).withCredentials(credentialsProvider).build();

    	    return amazonDynamoDB;*/
    	
    	    
        AmazonDynamoDB amazonDynamoDB 
          = new AmazonDynamoDBClient(amazonAWSCredentials());
         
        if (amazonDynamoDBEndpoint != null && !amazonDynamoDBEndpoint.isEmpty()) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
            amazonDynamoDB.setRegion(Region.getRegion(Regions.US_EAST_2));
        }
        return amazonDynamoDB;
    }
 
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
          amazonAWSAccessKey, amazonAWSSecretKey);
    }
}