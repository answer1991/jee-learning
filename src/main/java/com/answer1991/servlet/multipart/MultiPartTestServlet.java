package com.answer1991.servlet.multipart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class MultiPartTestServlet
 */
@WebServlet("/MultiPartTestServlet")
@MultipartConfig(location = "c:/temp", fileSizeThreshold = 1024, maxFileSize = 100 * 1024, maxRequestSize = 300 * 1024)
public class MultiPartTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiPartTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("testFile");

		response.getWriter().append(request.getCharacterEncoding());
		
		String fileName = "C:/Users/IBM_ADMIN/Desktop/" + part.getSubmittedFileName();
		File file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		} else {
			file.delete();
			file.createNewFile();
		}
		
		OutputStream os = new FileOutputStream(file);
		
		InputStream is = part.getInputStream();
		byte[] buffer = new byte[400];
		int count = 0;
		
		while((count = is.read(buffer, 0, 400)) >= 0) {
			os.write(buffer, 0, count);
		}
		
		os.close();
		
		part.delete();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
