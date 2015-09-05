package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iweb.entity.Question;
import com.iweb.entity.User;

public class ScoreServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int score = 0;
		int i=0;
		List<Question> questions = (List<Question>)((HttpServletRequest)request).getSession().getAttribute("questions");
		System.out.println("score" + questions.size());
		for(Question question : questions){
			System.out.println((i++)+"."+request.getParameter(Integer.toString(question.getQid())));
			if(question.getAnswer().equals(request.getParameter(Integer.toString(question.getQid())))){
				score++;
			}
		}
		User user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("	<h1 align='center'>您的得分为：" + score + "</h1>");
		out.println("	</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

}
