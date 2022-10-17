package com.itemrestapp.itemrestapp;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dao.ItemDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Item;

@SpringBootTest
class ItemrestappApplicationTests {
	
	@Autowired
	ItemDao itemdao;

	@Test
	void contextLoads() {
		
		Item item = new Item();
		item.setItemId(7);
		item.setItemName("test");
		item.setQuantity(50);
		itemdao.save(item);
		
	}
	
	@Test
    void test1() throws URISyntaxException, JsonProcessingException {
      
       
 
      
      
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/findbyid/1";
      URI uri=new URI(url);
      
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,HttpStatus.OK);
      
  }

}
