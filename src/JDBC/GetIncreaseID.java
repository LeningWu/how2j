package JDBC;

import java.sql.*;

public class GetIncreaseID {
    /*
    当插入一条数据之后，通过获取自增长id，得到这条数据的id，比如说是55.
    删除这条数据的前一条，54.
    如果54不存在，则删除53，以此类推直到删除上一条数据。
    */

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "insert into hero values(null,?,?,?)";
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
				"root", "root"); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); Statement st = c.createStatement();) {

			ps.setString(1, "盖伦");
			ps.setFloat(2, 616);
			ps.setInt(3, 100);

			ps.execute();

			ResultSet rs1 = ps.getGeneratedKeys();
			int id = -1;
			if (rs1.next()) {
				id = rs1.getInt(1);
			}

			System.out.println("刚插入的数据的id是:" + id);

			for (int i = id - 1; i > 0; i--) {
				int targetId = i;
				ResultSet rs2 = st.executeQuery("select id from Hero where id = " + targetId);
				if (rs2.next()) {
					System.out.println("id=" + targetId + " 的数据存在，删除该数据");

					String deleteSQL = "delete from hero where id = " + targetId;
					st.execute(deleteSQL);
					break;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
