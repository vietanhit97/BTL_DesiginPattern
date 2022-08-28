import java.io.ObjectInputFilter.Status;
import java.util.Scanner;

public class Product {
	private String id;
	private String name;
	private float price;
	private int categoryId;
	private boolean status;

	public Product() {

	}

	public Product(String id) {
		super();
		this.id = id;
	}

	public Product(String id, String name, float price, int categoryId, boolean status) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public boolean setProductId(String productId) {
		try {
			for (Product item : ProductDAPImp.getdata()) {
				if (item.getId().equalsIgnoreCase(productId)) {
					System.err.println("id san pham da ton tai !!! (nhap lai): ");
					return false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (productId.length() >0) {
			this.id = productId;
			return true;
		} else {
			System.err.println("id sản phẩm không được để trống ! ");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public boolean setProductName(String productName) {

		if (productName.length() > 3 && productName.length()<=30) {
			this.name = productName;
			return true;
		} else {
			System.err.println("tên sản phẩm nhập từ 6 -> 30 kí tự !  ");
			return false;
		}
	}

	public float getPrice() {
		return price;
	}

	public boolean setPrice(float importPrice) {
		if (importPrice > 1000) {
			this.price = importPrice;
			return true;
		} else {
			System.err.println("giá sản phẩm > 1000 !  ");
			return false;
		}
	}

	public int getCategoryId() {
		return categoryId;
	}

	public boolean setCategoryId(int categoryId) {
		this.categoryId=categoryId;
		return true;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id sản phẩm  : ");
		while (true) {
			String reProductId = sc.nextLine();
			boolean check = setProductId(reProductId);
			if (check) {
				break;
			}
		}
		System.out.println("Nhập tên sản phẩm : ");
		while (true) {
			String reProductName = sc.nextLine();
			boolean check = setProductName(reProductName);
			if (check) {
				break;
			}
		}
		System.out.println("Nhập giá sản phẩm : ");
		while (true) {
			try {
				float reImportPrice = Float.parseFloat(sc.nextLine());
				boolean check = setPrice(reImportPrice);
				if (check) {
					break;
				}
			} catch (Exception e) {
				System.err.println("nhap khong dung dinh dang !!! (nhap lai): ");
			}
		}
		System.out.println("Nhập id danh mục sản phẩm :");
		while (true) {
			int categoryId = sc.nextInt();
			boolean check = setCategoryId(categoryId);
			if (check) {
				break;
			}
		}
		System.out.println("nhap trang thai san pham : ");
		String reStatus = sc.nextLine();
		this.status = Boolean.parseBoolean(reStatus);
		while (!(reStatus.equalsIgnoreCase("true") || reStatus.equalsIgnoreCase("false"))) {
			System.err.println("nhap true hoac false (nhap lai) : ");
			reStatus = sc.nextLine();
			this.status = Boolean.parseBoolean(reStatus);
		}
	}
	public void inputDataUpdate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên sản phẩm cập nhật mới: ");
		while (true) {
			String reProductName = sc.nextLine();
			boolean check = setProductName(reProductName);
			if (check) {
				break;
			}
		}
		System.out.println("Nhập giá sản phẩm cập nhật mới: ");
		while (true) {
			try {
				float reImportPrice = Float.parseFloat(sc.nextLine());
				boolean check = setPrice(reImportPrice);
				if (check) {
					break;
				}
			} catch (Exception e) {
				System.err.println("Nhập không đúng định dạng !!! (Nhập lại): ");
			}
		}
		System.out.println("Nhập id danh mục sản phẩm cập nhật mới:");
		while (true) {
			int categoryId = sc.nextInt();
			boolean check = setCategoryId(categoryId);
			if (check) {
				break;
			}
		}
		System.out.println("Nhập trạng thái sản phẩm cập nhật mới : ");
		String reStatus = sc.nextLine();
		this.status = Boolean.parseBoolean(reStatus);
		while (!(reStatus.equalsIgnoreCase("true") || reStatus.equalsIgnoreCase("false"))) {
			System.err.println("Nhập true hoặc false (Nhập lại) : ");
			reStatus = sc.nextLine();
			this.status = Boolean.parseBoolean(reStatus);
		}
	}
	String S = "";

	public String Status(boolean prdStatus) {
		if (prdStatus) {
			S = "Hiện";
		} else {
			S = "Ẩn";
		}
		return S;
	}

	public void displayData() {
		System.out.println("+-------------------+------------------+------------------+\r\n"
				+ "| ID                | Name             | Price            | CategoryID         | Status           |\r\n"
				+ "+-------------------+------------------+------------------+\r\n" + "|" + this.id
				+ "                  |" + this.name + "                |" + this.price + "             |"
				+ this.categoryId + "             |" + Status(status) + "             |\r\n"
				+ "+-------------------+------------------+------------------+\r\n" + "");
	}

}
