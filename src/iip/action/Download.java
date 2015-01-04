package iip.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Download
 */
@SuppressWarnings("serial")
@WebServlet("/Download")
public class Download extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = new String(request.getParameter("path").getBytes("iso-8859-1"), "utf-8");  
		System.out.println("path="+path);
		OutputStream o = response.getOutputStream();
	       byte b[] = new byte[1024];
	       // the file to download.
	       File fileLoad = new File(path);
	       String file_name=fileLoad.getName();
	       // the dialogbox of download file.
	       response.setHeader("Content-disposition", "attachment;filename="+ file_name);
	       // set the MIME type.
	       response.setContentType("application/x-tar");
	       // get the file length.
	       long fileLength = fileLoad.length();
	       String length = String.valueOf(fileLength);
	       response.setHeader("Content_Length", length);
	       // download the file.
	       FileInputStream in = new FileInputStream(fileLoad);
	       int n = 0;
	       while ((n = in.read(b)) != -1) {
	           o.write(b, 0, n);
	       }
	       in.close();
	       o.flush();
	       o.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}
