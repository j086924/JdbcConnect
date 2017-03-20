package example.servlet.book;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.dao.book.BookJdbcDao;
import example.dao.book.ConnectionFactory;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		try {
//			// 加载数据库驱动，注册到驱动管理器
//			Class.forName("com.mysql.jdbc.Driver");
//			// 数据库连接字符串
//			String url = "jdbc:mysql://localhost:3306/db_book";
//			// 数据库用户名
//			String username = "root";
//			// 数据库密码
//			String password = "";
//			// 创建Connection连接
//			Connection conn = DriverManager.getConnection(url, username,
//					password);
//			// 删除图书信息的SQL语句
//			String sql = "delete from tb_books where id=?";
//			// 获取PreparedStatement
//			PreparedStatement ps = conn.prepareStatement(sql);
//			// 对SQL语句中的第一个占位符赋值
//			ps.setInt(1, id);
//			// 执行更新操作
//			ps.executeUpdate();
//			// 关闭PreparedStatement
//			ps.close();
//			// 关闭Connection
//			conn.close();
			BookJdbcDao bookDao=new BookJdbcDao();
			Connection conn=ConnectionFactory.getInstance().getConnection();
			bookDao.delete(conn,id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 重定向到FindServlet
		response.sendRedirect("FindServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
