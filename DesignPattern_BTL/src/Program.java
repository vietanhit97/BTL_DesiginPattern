import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DAOFactory<?> daoFactory = new DAOFactory();
		GeneralDAO<Product> GDProduct = daoFactory.getDao("Product");
		GeneralDAO<Category> GDCategory = daoFactory.getDao("Category");
		Product pdProduct = new Product();
		Category cCategory = new Category();
		while (true) {
			System.out.println("1. Quản lý danh mục\r\n" + "2. Quản lý sản phẩm\r\n" + "3.Thoát\r\n" + "");
			System.out.println("Chọn chức năng 1 -> 3 :");
			int chon = scanner.nextInt();
			scanner.nextLine();
			switch (chon) {
			case 1:
				boolean check1 = false;
				do {
					System.out.println("________________Quản lý danh mục________________\r\n"
							+ "1. Hiển thị d/s danh mục sắp xếp theo tên A-Z (status hiển thị ẩn/hiện) (4)\r\n"
							+ "2. Thêm mới danh mục (1) (3)\r\n" + "3. Cập nhật danh mục (1) (3)\r\n"
							+ "4. Xóa danh mục (3)\r\n" + "5. Quay lại\r\n" + "");
					int chonDM = scanner.nextInt();
					switch (chonDM) {
					case 1:
						System.out.println("1. Hiển thị d/s danh mục sắp xếp theo tên A-Z (status hiển thị ẩn/hiện) ");
						List<Category> categories = GDCategory.get();
						cCategory.displayData();
						for (Category category : categories) {
							category.ketQua();
						}
						break;
					case 2:
						System.out.println("2. Thêm mới danh mục");
						cCategory.inputData();
						GDCategory.add(cCategory);
						break;
					case 3:
						System.out.println("3. Cập nhật danh mục");
						System.out.println("Nhap ma san pham can cap nhat:");
	                    int cId = scanner.nextInt();
	                    scanner.nextLine();
	                    Category categorUpdate = new Category(cId);
//	                    Category cUpdate = GDCategory.findId(categorUpdate);
//	                    if (cUpdate == null) {
//	                        System.out.println("Ma san pham nay khong ton tai");
//	                    } else {
	                        System.out.println("Nhap ten danh muc can cap nhat:");
	                        categorUpdate.setName(scanner.nextLine());
	                        System.out.println("Nhap trang thai danh muc can cap nhat:");
	                        categorUpdate.setStatus(Boolean.parseBoolean(scanner.nextLine()));
	                        GDCategory.edit(categorUpdate);
//	                    }
						break;
					case 4:
						System.out.println("4. Xóa danh mục");
						System.out.println("Nhap ma Danh muc can xoa :");
						int xoa = scanner.nextInt();
						Category xoaCategory = new Category(xoa);
						GDCategory.remove(xoaCategory);
						break;
					case 5:
						check1 = true;
						break;
					default:
						System.err.println("vui long chon tu 1 ->5");
						break;
					}
					if (check1) {
						break;
					}
				} while (true);
				break;
			case 2:
				boolean check2 = false;
				do {
					System.out.println("________________Quản lý sản phẩm________________\r\n"
							+ "1. Hiển thị d/s sản phẩm (id, name, price, categoryName, status(ẩn/hiện)) \r\n"
							+ "2. Thêm mới sản phẩm\r\n" + "3. Cập nhật thông tin sản phẩm \r\n" + "4. Xóa sản phẩm \r\n"
							+ "5. Quay lại\r\n" + "");
					int chonSP = scanner.nextInt();
					scanner.nextLine();
					switch (chonSP) {
					case 1:
						System.out
								.println("1. Hiển thị d/s sản phẩm (id, name, price, categoryName, status(ẩn/hiện))\\r\\n");
						List<Product> products = GDProduct.get();
						for (Product product : products) {
							product.displayData();
						}
						break;
					case 2:
						System.out.println("2. Thêm mới sản phẩm\r\n");
						break;
					case 3:
						System.out.println("3. Cập nhật thông tin sản phẩm \r\n");
						break;
					case 4:
						System.out.println("4. Xóa sản phẩm \r\n");
						break;
					case 5:
						check2 = true;
						break;
					default:
						System.err.println("vui long chon tu 1 ->5");
						break;
					}
					if (check2) {
						break;
					}
				} while (true);
				break;
			case 3:
				System.exit(0);
			}
		}
	}
}
