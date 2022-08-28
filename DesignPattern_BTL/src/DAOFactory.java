
public class DAOFactory<T> {
	public GeneralDAO getDao(ClassName type) {
		switch (type) {
		case Category:
			return CategoryDAOImp.getInstance();

		case Product:
			return ProductDAPImp.getInstance();
		default:
			return null;
		}
	}

}
