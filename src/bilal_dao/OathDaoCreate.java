package bilal_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bilal_bean.Bean;
import ravi.util.DBConnectionManager;

public class OathDaoCreate {
	public void create(Bean bean) throws SQLException {
		Connection con = DBConnectionManager.getConnection();
		PreparedStatement ps = null;
		String query1 = "insert into marketplace(partner, baseUrl, uuid, openId, email) VALUES (?,?,?,?,?)";
		String query2 = "insert into company(uuid,name,email,phone,website,country,m_uuid) VALUES (?,?,?,?,?,?,?) ";

		ps = con.prepareStatement(query1);
		ps.setString(1, bean.getMarketplace().getPartner());
		ps.setString(2, bean.getMarketplace().getBaseUrl());
		ps.setString(3, bean.getCreator().getUuid());
		ps.setString(4, bean.getCreator().getOpenId());
		ps.setString(5, bean.getCreator().getEmail());
		ps.executeUpdate();

		ps = con.prepareStatement(query2);
		ps.setString(1, bean.getPayload().getCompany().getUuid());
		ps.setString(2, bean.getPayload().getCompany().getName());
		ps.setString(3, bean.getPayload().getCompany().getEmail());
		ps.setString(4, bean.getPayload().getCompany().getPhoneNumber());
		ps.setString(5, bean.getPayload().getCompany().getWebsite());
		ps.setString(6, bean.getPayload().getCompany().getCountry());
		ps.setString(7, bean.getCreator().getUuid());
		ps.executeUpdate();
	}
}
