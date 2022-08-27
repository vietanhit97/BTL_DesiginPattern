import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAOImp implements GeneralDAO<Category> {
	private static List<Category> data = new ArrayList<Category>();
	private static final CategoryDAOImp instance = new CategoryDAOImp();

	private CategoryDAOImp() {
	}

	public static CategoryDAOImp getInstance() {
		return instance;
	}
	
	@Override
	public List<Category> get() {
		ResultSet ketQua = null;
		PreparedStatement pstmt=null;
		Connection connection = JDBCUtil.getConnection();
		try {
			String sqlString = "select * from Category order by name ASC ";
			pstmt = connection.prepareStatement(sqlString);
			ketQua = pstmt.executeQuery();
			while (ketQua.next()) {
				Category category = new Category();
				category.setId(ketQua.getInt("id"));
				category.setName(ketQua.getString("name"));
				category.setStatus(ketQua.getBoolean("status"));
				data.add(category);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Category> getByName(String name) {
		ResultSet ketQua = null;
		PreparedStatement pstmt=null;
		Connection connection = JDBCUtil.getConnection();
		try {
			String sqlString = "select * from Category where name=? ";
			pstmt = connection.prepareStatement(sqlString);
			pstmt.setString(1, name);
			ketQua = pstmt.executeQuery();
			while (ketQua.next()) {
				Category category = new Category();
				category.setId(ketQua.getInt("id"));
				category.setName(ketQua.getString("name"));
				category.setStatus(ketQua.getBoolean("status"));
				data.add(category);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Category findId(Category c) {
		Category ketQua = null;
		Connection con = JDBCUtil.getConnection();
		try {
			// Bước 1: tạo kết nối đến CSDL
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Category where id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, c.id);
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				boolean status = rs.getBoolean("status");		
				ketQua = new Category(id, name, status);
			}
			
			// Bước 5:
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public boolean add(Category entity) {
		boolean bl = false;
		Connection connection = JDBCUtil.getConnection();
		ResultSet rSet = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("insert into Category values (?,?,?)");
			pstmt.setInt(1, entity.getId());
			pstmt.setString(2,entity.getName());
			pstmt.setBoolean(3,entity.isStatus());
			int i = pstmt.executeUpdate();
			if (i>0) {
				System.out.println("Them moi thanh cong");
				bl =true;
			}else {
				System.out.println("them moi khong thanh cong");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bl;
		
	}

	@Override
	public boolean edit(Category entity) {
		boolean bl = false;
		Connection connection = JDBCUtil.getConnection();
		ResultSet rSet = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("update Category set name=?,status=? where id =?");
			pstmt.setString(1,entity.getName());
			pstmt.setBoolean(2,entity.isStatus());
			pstmt.setInt(3, entity.getId());
			int i = pstmt.executeUpdate();
			if (i>0) {
				System.out.println("Sua thanh cong");
				bl =true;
			}else {
				System.out.println("Sua khong thanh cong");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public boolean remove(Category entity) {
		boolean bl = false;
		Connection connection = JDBCUtil.getConnection();
		ResultSet rSet = null;
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("delete from Category where id =?");
			pstmt.setInt(1, entity.getId());
			int i = pstmt.executeUpdate();
			if (i>0) {
				System.out.println("Xoa thanh cong");
				bl =true;
			}else {
				System.out.println("Xoa khong thanh cong");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bl;
	}

}
