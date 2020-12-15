package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.Article;
import board.article.ArticleDao;

@WebServlet("/dbServlet")
public class dbServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		ArticleDao articleDao = new ArticleDao();
		
		ArrayList<Article> articles = articleDao.getArticles();
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1> 게시물 목록 </h1>");
		out.println("<h2> 1. 공지게시판 </h2>");
		out.println("<table border='1'>");

		out.println("<td>제목</td>");	
		out.println("<td>작성자</td>");
		out.println("<td>작성일</td>");
		
		for(int i = 0; i < articles.size(); i++)
		{
			out.println("<tr>");
			out.println("<td>" + articles.get(i).getTitle() + "</td>");	
			out.println("<td>" + articles.get(i).getNickname() + "</td>");
			out.println("<td>" + articles.get(i).getRegDate() + "</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
