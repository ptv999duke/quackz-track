package com.quackztrack.apiserver.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.quackztrack.apiserver.services.base.IItemsService;

public class MongoItemsService implements IItemsService 
{
	public MongoItemsService() {		
	}

	@Override
	public void putItem() {
		// TODO Auto-generated method stub
		System.out.println("Mongo");
	}

	
}
