package common;

import java.util.*;

public class Inventory {
	

	public static Hashtable<String, Integer> inventory = new Hashtable<String, Integer>();

	public Inventory()
	{
		this.inventory.put("item1", 10);
		this.inventory.put("item2", 20);
	}
	//method to add item in the inventory
	//Requires("item!=null"&&"quantity>0"&&"inventory!=null")
	//@Ensures("inventory!=null")
	public void addInventoryRecords(String item, int quantity)
	{
		if(quantity<0)
		{
			return;
		}
		else
			this.inventory.put(item, quantity);
	}
	
	//method to delete item from the inventory
	//@Requires("item!=null"&&"inventory!=null")
	public void deleteInventoryRecords(String item, int quantity)
	{
		if(quantity>this.inventory.get(item))
		{
			return;
		}
		else
		{
			int x=this.inventory.get(item);
			this.inventory.remove(item);
			this.inventory.put(item, (x-quantity));
		}
	}
	
	public String viewInventoryRecords()
	{
		return this.inventory.toString();
	}
	
	public String toString()
	{
		StringBuilder items = new StringBuilder();
		Set<String> keys = this.inventory.keySet();
		for(String key:keys)
		{
			items.append(key);
			items.append(" ");
			items.append("quantity:");
			items.append(this.inventory.get(key));
			items.append("\n");
			String item=items.toString();
			//items = items+key + " quantity: " + this.inventory.get(key)+"\n\r\n";
		}
		
		if(items.length()> 0)
		{
			return items.toString();
		}
		else
		{
			return "No items in inventory";
		}
	}
	
	
}
