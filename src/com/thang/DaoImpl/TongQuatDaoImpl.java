package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.JDBCConnection;
import com.thang.dao.TongQuatDao;
import com.thang.model.PhuLuc;
import com.thang.model.TongQuat;

public class TongQuatDaoImpl extends JDBCConnection implements TongQuatDao {

	@Override
	public List<TongQuat> getAll(int limit, int offset) {
		List<TongQuat> tongquatList = new ArrayList<TongQuat>();
		final String sql = "SELECT * FROM tongquat LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tongquatList.add(rowMapper(rs));
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

		return tongquatList;
	}

	private TongQuat rowMapper(ResultSet rs) throws SQLException {
		TongQuat tongquat = new TongQuat();
		tongquat.setId_tongquat(rs.getInt("id_tongquat"));
		tongquat.setTieude_tongquat(rs.getString("tieude_tongquat"));
		tongquat.setNoidung_tongquat(rs.getString("noidung_tongquat"));
		return tongquat;
	}

	@Override
	public int totalTongQuat() {
		final String sql = "SELECT COUNT(*) AS total_tongquat FROM tongquat";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tongquat");
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
	public void addTongQuat(TongQuat tongquat) {
		final String sql = "INSERT INTO  tongquat(tieude_tongquat,noidung_tongquat)" + "VALUES(?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tongquat.getTieude_tongquat());
			preparedStatement.setString(2, tongquat.getNoidung_tongquat());
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
	public List<TongQuat> getAll() {
		List<TongQuat> tongquatList = new ArrayList<TongQuat>();
		final String sql = "SELECT * FROM tongquat";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tongquatList.add(rowMapper(rs));
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

		return tongquatList;
	}

	@Override
	public TongQuat getIdTongQuat(int id_tongquat) {
		final String sql = "SELECT * FROM tongquat WHERE id_tongquat=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tongquat);
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
	public void updateTongQuat(TongQuat tongquat) {
		final String sql = "UPDATE tongquat SET tieude_tongquat=?,noidung_tongquat=? WHERE id_tongquat=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tongquat.getTieude_tongquat());
			preparedStatement.setString(2, tongquat.getNoidung_tongquat());
			preparedStatement.setInt(3, tongquat.getId_tongquat());
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
	public TongQuat getTieuDeTongQuat(String tieude_tongquat) {
		final String sql = "SELECT * FROM tongquat WHERE tieude_tongquat=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tieude_tongquat);
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
	public void deleteTongQuat(int id_tongquat) {
		final String sql = "DELETE FROM tongquat WHERE id_tongquat = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tongquat);
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
	public List<TongQuat> searchTongQuat(String key, int limit, int offset) {
		List<TongQuat> listSearch = new ArrayList<TongQuat>();
		final String sql = "SELECT * FROM tongquat WHERE tieude_tongquat LIKE ? LIMIT ? OFFSET ?";
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
		final String sql = "SELECT COUNT(*) AS total_tongquat FROM tongquat WHERE tieude_tongquat LIKE ? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tongquat");
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
