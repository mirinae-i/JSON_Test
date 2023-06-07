package com.mirinae.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirinae.bean.MemberBean;
import com.mirinae.dao.MemberDAO;

@WebServlet("/showlist")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set Encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter writer = response.getWriter();
		MemberDAO dao = new MemberDAO();
		String json = "{\"members\": [";
		try {
			List<MemberBean> memberList = dao.showInfo();
			for (int i = 0; i < memberList.size(); i++) {
				json += "{" + "\"id\":" + "\"" + memberList.get(i).getId() + "\", " + "\"pw\":" + "\""
						+ memberList.get(i).getPw() + "\", " + "\"name\":" + "\"" + memberList.get(i).getName() + "\", "
						+ "\"age\":" + memberList.get(i).getAge() + "}";
				if (i < memberList.size() - 1) {
					json += ", ";
				}
			}
			json += "]}";
			System.out.println(json);
			writer.print(json);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
