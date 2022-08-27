

public class DAOFactory<T> {
	public GeneralDAO getDao(String type) {
		if(type.equalsIgnoreCase("Category")) {
			return CategoryDAOImp.getInstance();
		}else if (type.equalsIgnoreCase("Product")) {
			return ProductDAPImp.getInstance();
		}else {
			return null;
		}
	}

	
}
