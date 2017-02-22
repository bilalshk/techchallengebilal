package bilal_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bilal_bean.Bean;
import ravi.util.DBConnectionManager;

public class OathDaoDelete {
	public void delete(Bean bean) throws SQLException {
		Connection con = DBConnectionManager.getConnection();
		PreparedStatement ps = null;
		String query = "delete from company where m_uuid = ?";
		ps = con.prepareStatement(query);
		ps.setString(1, bean.getCreator().getUuid());
		ps.executeUpdate();
	}
}
