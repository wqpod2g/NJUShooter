package iip.action;

import iip.dao.SubDao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Query
 */
@SuppressWarnings("serial")
public class Query extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query_words = new String(request.getParameter("query_words").getBytes("iso-8859-1"), "utf-8");
		System.out.println("query_words="+query_words.length());
		if(query_words.length()==0){
			request.getRequestDispatcher("Search.jsp").forward(request,response);
		}
		else{
			SubDao sd=new SubDao();
			long start=System.currentTimeMillis();
			ArrayList<String>sub_list=sd.select(query_words);
			long end=System.currentTimeMillis();
			String query_time=end-start+"";
			request.setAttribute("query_words", query_words);
			request.setAttribute("query_time", query_time);
			request.setAttribute("sub_list", sub_list);
			request.setAttribute("result_size", sub_list.size()+"");
			request.getRequestDispatcher("result.jsp").forward(request,response);
		}
		
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}


}
