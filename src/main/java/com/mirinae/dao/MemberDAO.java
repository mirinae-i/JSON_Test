package com.mirinae.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.mirinae.bean.MemberBean;
import com.mirinae.util.ConnectionPool;

public class MemberDAO {

	public List<MemberBean> showInfo() throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MemberBean> memberList = new ArrayList<>();

		conn = ConnectionPool.get();
		String query = "SELECT `id`, `pw`, `name`, `age` FROM `member`;";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();

		while (rs.next()) {
			MemberBean mb = new MemberBean();
			mb.setId(rs.getString("id"));
			mb.setPw(rs.getString("pw"));
			mb.setName(rs.getString("name"));
			mb.setAge(rs.getInt("age"));
			memberList.add(mb);
		}

		rs.close();
		ps.close();
		conn.close();

		return memberList;
	}
}
