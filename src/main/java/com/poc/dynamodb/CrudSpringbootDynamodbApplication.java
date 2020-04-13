package com.poc.dynamodb;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;

import com.poc.dynamodb.dao.ProductCatalogDAO;
import com.poc.dynamodb.entity.ProductCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;

@SpringBootApplication
public class CrudSpringbootDynamodbApplication {

	private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
	@Autowired
	private ProductCatalogDAO dao;
	
	@PostConstruct
	public void init() {
		
		createProductCatalogTable();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		ProductCatalog product1 = new ProductCatalog("Book", 10, false, new BigDecimal("10.99"), "USD",sf.format(new Date()),"0");
		dao.save(product1);
		
		ProductCatalog product2 = new ProductCatalog("Bag", 10, false, new BigDecimal("5.99"), "USD",sf.format(new Date()),"0");
		dao.save(product2);		
	}

	public void createProductCatalogTable(){
        try {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(ProductCatalog.class);

            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));

            amazonDynamoDB.createTable(tableRequest);
        } catch (ResourceInUseException e) {
            
        }
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootDynamodbApplication.class, args);
	}
}
