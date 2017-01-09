package com.quackztrack.apiserver.services;

import org.springframework.context.annotation.Configuration;

import com.quackztrack.apiserver.services.base.IItemsService;

public class PostgresItemsService implements IItemsService 
{
	
	@Override
	public void putItem() {
		System.out.println("Postgres");
		// TODO Auto-generated method stub
		
	}
	
}
