
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
					scanner.nextLine();
					switch (chonDM) {
					case 1:
						System.out.println("1. Hiển thị d/s danh mục sắp xếp theo tên A-Z (status hiển thị ẩn/hiện) ");
						break;
					case 2:
						System.out.println("2. Thêm mới danh mục");
						break;
					case 3:
						System.out.println("3. Cập nhật danh mục");
						break;
					case 4:
						System.out.println("4. Xóa danh mục");
						break;
					case 5:
						check1 = true;
						break;
					default:
						System.err.println("vui long chon tu 1 ->4");
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
						System.err.println("vui long chon tu 1 ->4");
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
