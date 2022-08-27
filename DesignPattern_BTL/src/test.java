import java.awt.Image;
import java.sql.Connection;
import java.util.List;

import org.w3c.dom.ls.LSOutput;

public class test {
	public static void main(String[] args) {	
		CategoryDAOImp cImp = CategoryDAOImp.getInstance();
		ProductDAPImp pImp = ProductDAPImp.getInstance();
		List<Product> products = pImp.get();
		for (Product product : products) {
			product.displayData();
		}
	}
	
}
