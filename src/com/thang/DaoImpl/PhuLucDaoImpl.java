package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.JDBCConnection;
import com.thang.dao.PhuLucDao;
import com.thang.model.PhuLuc;
import com.thang.model.TaiKhoan;

public class PhuLucDaoImpl extends JDBCConnection implements PhuLucDao {

	@Override
	public List<PhuLuc> getAll(int limit, int offset) {
		List<PhuLuc> phulucList = new ArrayList<PhuLuc>();
		final String sql = "SELECT * FROM phuluc LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				phulucList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return phulucList;
	}

	private PhuLuc rowMapper(ResultSet rs) throws SQLException {
		PhuLuc phuLuc = new PhuLuc();
		phuLuc.setId_phuluc(rs.getInt("id_phuluc"));
		phuLuc.setTenphuluc(rs.getString("tenphuluc"));
		phuLuc.setTieude_phuluc(rs.getString("tieude_phuluc"));
		phuLuc.setNoidung_phuluc(rs.getString("noidung_phuluc"));
		return phuLuc;
	}

	@Override
	public int totalPhuLuc() {
		final String sql = "SELECT COUNT(*) AS total_phuluc FROM phuluc";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_phuluc");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public void addPhuLuc(PhuLuc phuluc) {
		final String sql = "INSERT INTO  phuluc(tenphuluc,tieude_phuluc,noidung_phuluc)" + "VALUES(?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, phuluc.getTenphuluc());
			preparedStatement.setString(2, phuluc.getTieude_phuluc());
			preparedStatement.setString(3, phuluc.getNoidung_phuluc());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<PhuLuc> getAll() {
		List<PhuLuc> phulucList = new ArrayList<PhuLuc>();
		final String sql = "SELECT * FROM phuluc";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				phulucList.add(rowMapper(rs));
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return phulucList;
	}

	@Override
	public PhuLuc getIdPhuLuc(int id_phuluc) {
		final String sql = "SELECT * FROM phuluc WHERE id_phuluc=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_phuluc);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public void updatePhuLuc(PhuLuc phuluc) {
		final String sql = "UPDATE phuluc SET tenphuluc=?,tieude_phuluc=?,noidung_phuluc=? WHERE id_phuluc=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, phuluc.getTenphuluc());
			preparedStatement.setString(2, phuluc.getTieude_phuluc());
			preparedStatement.setString(3, phuluc.getNoidung_phuluc());
			preparedStatement.setInt(4, phuluc.getId_phuluc());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public PhuLuc getTenPhuLuc(String tenphuluc) {
		final String sql = "SELECT * FROM phuluc WHERE tenphuluc=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tenphuluc);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void deletePhuLuc(int id_phuluc) {
		final String sql = "DELETE FROM phuluc WHERE id_phuluc = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_phuluc);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("loi delete" + e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<PhuLuc> searchPhuLuc(String key, int limit, int offset) {
		List<PhuLuc> listSearch = new ArrayList<PhuLuc>();
		final String sql = "SELECT * FROM phuluc WHERE tenphuluc LIKE ? LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listSearch.add(rowMapper(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listSearch;
	}

	@Override
	public int totalSearch(String key) {
		final String sql = "SELECT COUNT(*) AS total_phuluc FROM phuluc WHERE tenphuluc LIKE ? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_phuluc");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

}
