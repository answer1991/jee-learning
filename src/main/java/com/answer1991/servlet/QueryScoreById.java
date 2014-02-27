package com.answer1991.servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;

import com.answer1991.utils.qualifier.HelloLogger;

/**
 * Servlet implementation class QueryScoreById
 */
@WebServlet("/QueryScoreById")
public class QueryScoreById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	@HelloLogger
	private Logger logger;
	
	@Resource(lookup = "jdbc/MySQLConn")
	private DataSource ds;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryScoreById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String studentId = request.getParameter("id");
		logger.debug("request student Id -- > " + studentId);
		
		Connection conn = null;
		
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT score From sampdb.score WHERE student_id = " + studentId);
			
			if(resultSet.first()) {
				Writer writer = response.getWriter();
				while(resultSet.next()) {
					int score = resultSet.getInt("score");
					writer.write(score + "");
					writer.write("<br />");
				}
			}
			else {
				response.getWriter().write("no data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("SQL ERROR Occered");
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
