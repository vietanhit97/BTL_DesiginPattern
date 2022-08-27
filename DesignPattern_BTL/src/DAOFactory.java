import java.util.Locale.Category;

public class DAOFactory<T> {
	
	public GeneralDAO getDao(Class<T> _clClass) {
		switch () {
		case _clClass:
			return CategoryDAOImp.getInstance();
		
		
		
		default :
		throw new IllegalArgumentException("Unexpected value: " + _clClass);
		}
	}

	
}
