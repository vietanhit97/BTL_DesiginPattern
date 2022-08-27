import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAPImp implements GeneralDAO<Product> {
	private static List<Product> data = new ArrayList<Product>();
	private static final ProductDAPImp instance = new ProductDAPImp();

	private ProductDAPImp() {
	}

	public static ProductDAPImp getInstance() {
		return instance;
	}

	public static List<Product> getdata() {
		return data;
	}

	@Override
	public List<Product> get() {
		ResultSet ketQua = null;
		PreparedStatement pstmt = null;
		Connection connection = JDBCUtil.getConnection();
		try {
			String sqlString = "select * from Product ";
			pstmt = connection.prepareStatement(sqlString);
			ketQua = pstmt.executeQuery();
			while (ketQua.next()) {
				Product product = new Product();
				product.setProductId(ketQua.getString("id"));
				product.setProductName(ketQua.getString("name"));
				product.setPrice(ketQua.getFloat("price"));
				product.setCategoryId(ketQua.getInt("categoryId"));
				product.setStatus(ketQua.getBoolean("status"));
				data.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		return data;
	}

	@Override
	public List<Product> getByName(String name) {
		ResultSet ketQua = null;
		PreparedStatement pstmt = null;
		Connection connection = JDBCUtil.getConnection();
		try {
			String sqlString = "select * from Product where name=? ";
			pstmt = connection.prepareStatement(sqlString);
			pstmt.setString(1, name);
			ketQua = pstmt.executeQuery();
			while (ketQua.next()) {
				Product product = new Product();
				product.setProductId(ketQua.getString("id"));
				product.setProductName(ketQua.getString("name"));
				product.setPrice(ketQua.getFloat("price"));
				product.setCategoryId(ketQua.getInt("categoryId"));
				product.setStatus(ketQua.getBoolean("status"));
				data.add(product);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		return data;
	}

	@Override
	public Product findId(Product p) {
		Product ketQua = null;
		Connection con = JDBCUtil.getConnection();
		try {

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Product where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, p.getId());
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				int categoryId = rs.getInt("categoryId");
				boolean status = rs.getBoolean("status");
				ketQua = new Product(id, name, price, categoryId, status);
			}

			// Bước 5:
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(con);
		}
		return ketQua;
	}

	@Override
	public boolean add(Product entity) {
		boolean bl = false;
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement("insert into Product values (?,?,?,?,?)");
			pstmt.setString(1, entity.getId());
			pstmt.setString(2, entity.getName());
			pstmt.setFloat(3, entity.getPrice());
			pstmt.setInt(4, entity.getCategoryId());
			pstmt.setBoolean(5, entity.isStatus());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("Them moi thanh cong");
				bl = true;
			} else {
				System.out.println("them moi khong thanh cong");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		return bl;

	}

	@Override
	public boolean edit(Product entity) {
		boolean bl = false;
		Connection connection = JDBCUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement("update Product set name=?,price=?,category=?,status=? where id =?");
			pstmt.setString(1, entity.getName());
			pstmt.setFloat(2, entity.getPrice());
			pstmt.setInt(3, entity.getCategoryId());
			pstmt.setBoolean(4, entity.isStatus());
			pstmt.setString(5, entity.getId());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("Sua moi thanh cong");
				bl = true;
			} else {
				System.out.println("Sua moi khong thanh cong");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		return bl;
	}

	@Override
	public boolean remove(Product entity) {
		boolean bl = false;
		Connection connection = JDBCUtil.getConnection();
		ResultSet rSet = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement("delete from Product where id =?");
			pstmt.setString(1, entity.getId());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("Xoa thanh cong");
				bl = true;
			} else {
				System.out.println("Xoa khong thanh cong");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection(connection);
		}
		return bl;
	}

}
