package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.JDBCConnection;
import com.thang.dao.TieuChiDao;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

public class TieuChiDaoImpl extends JDBCConnection implements TieuChiDao {

	@Override
	public List<TieuChi> getAll(int id_tieuchuan, int limit, int offset) {
		List<TieuChi> tieuChiList = new ArrayList<TieuChi>();
		final String sql = "SELECT * FROM tieuchi INNER JOIN tieuchuan ON tieuchi.tieuchuan=tieuchuan.id_tieuchuan WHERE tieuchuan=? LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchuan);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tieuChiList.add(rowMapper(rs));
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

		return tieuChiList;
	}

	private TieuChi rowMapper(ResultSet rs) throws SQLException {
		TieuChi tieuChi = new TieuChi();
		tieuChi.setId_tieuchi(rs.getInt("id_tieuchi"));
		tieuChi.setTentieuchi(rs.getString("tentieuchi"));
		tieuChi.setNoidung_tieuchi(rs.getString("noidung_tieuchi"));
		TieuChuan tieuChuan = new TieuChuan();
		tieuChuan.setId_tieuchuan(rs.getInt("id_tieuchuan"));
		tieuChuan.setTentieuchuan(rs.getString("tentieuchuan"));

		tieuChi.setTieuchuan(tieuChuan);
		return tieuChi;
	}

	@Override
	public int totalTieuChi(int id_tieuchuan) {
		final String sql = "SELECT COUNT(*) AS total_tieuchi FROM tieuchi INNER JOIN tieuchuan ON tieuchi.tieuchuan=tieuchuan.id_tieuchuan WHERE tieuchuan=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchuan);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tieuchi");
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
	public void addTieuChi(TieuChi tieuchi) {
		final String sql = "INSERT INTO  tieuchi(tentieuchi,noidung_tieuchi,tieuchuan)" + "VALUES(?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tieuchi.getTentieuchi());
			preparedStatement.setString(2, tieuchi.getNoidung_tieuchi());
			preparedStatement.setInt(3, tieuchi.getTieuchuan().getId_tieuchuan());
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
	public TieuChi getTenTieuChi(String tieuchi) {
		final String sql = "SELECT * FROM tieuchi INNER JOIN tieuchuan ON tieuchi.tieuchuan=tieuchuan.id_tieuchuan WHERE tentieuchi=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tieuchi);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TieuChi getTieuChiById(int id_tieuchi) {
		final String sql = "SELECT * FROM tieuchi INNER JOIN tieuchuan ON tieuchi.tieuchuan=tieuchuan.id_tieuchuan WHERE id_tieuchi=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchi);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateTieuChi(TieuChi tieuchi) {
		final String sql = "UPDATE tieuchi SET tentieuchi=?,noidung_tieuchi=? WHERE id_tieuchi=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tieuchi.getTentieuchi());
			preparedStatement.setString(2, tieuchi.getNoidung_tieuchi());
			preparedStatement.setInt(3, tieuchi.getId_tieuchi());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteTieuChi(int id_tieuchi) {
		final String sql = "DELETE FROM tieuchi WHERE id_tieuchi=? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchi);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TieuChi> searchTieuChi(String key,int tieuchuan, int limit, int offset) {
		List<TieuChi> listSearch = new ArrayList<TieuChi>();
		final String sql = "SELECT * FROM tieuchi INNER JOIN tieuchuan ON tieuchi.tieuchuan=tieuchuan.id_tieuchuan  WHERE tentieuchi LIKE ? AND tieuchuan=? ORDER BY id_tieuchi ASC LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setInt(2, tieuchuan);
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listSearch.add(rowMapper(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listSearch;
	}

	@Override
	public int totalSearch(String key,int tieuchuan) {
		final String sql = "SELECT COUNT(*) AS total_tieuchi FROM tieuchi INNER JOIN tieuchuan ON tieuchi.tieuchuan=tieuchuan.id_tieuchuan WHERE tentieuchi LIKE ? AND tieuchuan=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setInt(2, tieuchuan);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tieuchi");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<TieuChi> getAll() {
		List<TieuChi> tieuChiList = new ArrayList<TieuChi>();
		final String sql = "SELECT * FROM tieuchi INNER JOIN tieuchuan ON tieuchi.tieuchuan=tieuchuan.id_tieuchuan";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tieuChiList.add(rowMapper(rs));
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

		return tieuChiList;
	}

}
