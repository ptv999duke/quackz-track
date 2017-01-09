package com.quackztrack.apiserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quackztrack.apiserver.services.base.IItemsService;

@RestController
public class ItemsController {

	private IItemsService itemsService;
	
	@RequestMapping("/putitem")
	public void putItem() {
		this.itemsService.putItem();
	}
	
	@Autowired
	public ItemsController(IItemsService itemsService)
	{
		this.itemsService = itemsService;
	}
}
