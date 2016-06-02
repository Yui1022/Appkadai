package model;

import java.io.Serializable;
public class Items implements Serializable{
	 private String itemId;
	    private String itemName;
	    private int price;
	    private int num;
	    

	    public Items(String itemId,String itemName,int price,int num){
	        this.itemId=itemId;
	        this.itemName=itemName;
	        this.price=price;
	        this.num=num;
	    }
	    public String getItemId(){
	        return itemId;
	    }
	    public String getItemName(){
	        return itemName;
	    }
	    public int getPrice(){
	        return price;
	    }
	    public int getNum(){
	        return num;
	    }
	
}
