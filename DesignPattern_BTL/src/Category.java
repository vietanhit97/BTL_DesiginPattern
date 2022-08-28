import java.util.Objects;
import java.util.Scanner;

public class Category {
	int id;
	private String name;
	private boolean status;

	public Category() {
	}

	public Category(int id) {
		this.id = id;
	}

	public Category(int id, String name, boolean status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(S, id, name, status);
	}

	public int getId() {
		return id;
	}

	public boolean setId(int id) {
		if (id > 0) {
			this.id = id;
			return true;
		} else {
			System.err.println("so nguyen > 0 (nhap lai) : ");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (name.length() >= 6 && name.length() <= 30) {
			this.name = name;
			return true;
		} else {
			System.err.println("do dai 6 -> 30 ky tu (nhap lai) : ");
			return false;
		}

	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma danh muc  : ");
		while (true) {
			try {
				int reCatalogID = Integer.parseInt(sc.nextLine());
				boolean check = setId(reCatalogID);
				if (check) {
					break;
				}
			} catch (Exception e) {
				System.err.println("nhap khong dung dinh dang!!!");
			}
		}

		System.out.println("nhap ten danh muc : ");
		while (true) {
			String reCatalogName = sc.nextLine();
			boolean check = setName(reCatalogName);
			if (check) {
				break;
			}
		}
		System.out.println("nhap trang thai danh muc : ");
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
		System.out.println("Nhập tên danh mục cập nhật mới : ");
		while (true) {
			String reCatalogName = sc.nextLine();
			boolean check = setName(reCatalogName);
			if (check) {
				break;
			}
		}
		System.out.println("Nhập trạng thái danh mục cập nhật mới : ");
		String reStatus = sc.nextLine();
		this.status = Boolean.parseBoolean(reStatus);
		while (!(reStatus.equalsIgnoreCase("true") || reStatus.equalsIgnoreCase("false"))) {
			System.err.println("nhap true hoac false (nhap lai) : ");
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
				+ "| ID                | Name             | Status           |\r\n"
				+ "+-------------------+------------------+------------------+\r");


	}

	public void ketQua() {
		System.out.print(
				  
				 "| "+this.id+"                 |"+this.name+"           | "+Status(status)+"             |\r\n"
				+ "+-------------------+------------------+------------------+\r\n");
	}
}