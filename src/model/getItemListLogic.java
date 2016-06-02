package model;

import dao.ListDao;
import java.util.List;
public class getItemListLogic {
	 public List<Items> execute(){
	        ListDao dao=new ListDao();
	        List<Items> Items=dao.findAll();
	        return Items;
	    }
}
