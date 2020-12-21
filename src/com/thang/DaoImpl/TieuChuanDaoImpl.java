package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.JDBCConnection;
import com.thang.dao.TieuChuanDao;
import com.thang.model.TieuChuan;

public class TieuChuanDaoImpl extends JDBCConnection implements TieuChuanDao {

	@Override
	public List<TieuChuan> getAll(int limit, int offset) {
		List<TieuChuan> tieuchuanList = new ArrayList<TieuChuan>();
		final String sql = "SELECT * FROM tieuchuan ORDER BY id_tieuchuan ASC LIMIT ? OFFSET ? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tieuchuanList.add(rowMapper(rs));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tieuchuanList;
	}

	private TieuChuan rowMapper(ResultSet rs) throws SQLException {
		TieuChuan tieuchuan = new TieuChuan();
		tieuchuan.setId_tieuchuan(rs.getInt("id_tieuchuan"));
		tieuchuan.setTentieuchuan(rs.getString("tentieuchuan"));
		tieuchuan.setNoidung_tieuchuan(rs.getString("noidung_tieuchuan"));
		return tieuchuan;
	}

	@Override
	public int totalTieuChuan() {
		final String sql = "SELECT COUNT(*) AS total_tieuchuan FROM tieuchuan";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tieuchuan");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void addTieuChuan(TieuChuan tieuchuan) {
		final String sql = "INSERT INTO tieuchuan(tentieuchuan,noidung_tieuchuan) VALUE(?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tieuchuan.getTentieuchuan());
			preparedStatement.setString(2, tieuchuan.getNoidung_tieuchuan());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TieuChuan getTenTieuChuan(String tieuchuan) {
		final String sql = "SELECT * FROM tieuchuan WHERE tentieuchuan=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tieuchuan);
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
	public TieuChuan getTieuChuanById(int id_tieuchuan) {
		final String sql = "SELECT * FROM tieuchuan WHERE id_tieuchuan=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchuan);
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
	public void updateTieuChuan(TieuChuan tieuchuan) {
		final String sql = "UPDATE tieuchuan SET tentieuchuan=?,noidung_tieuchuan WHERE id_tieuchuan=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, tieuchuan.getTentieuchuan());
			preparedStatement.setString(2, tieuchuan.getNoidung_tieuchuan());
			preparedStatement.setInt(3, tieuchuan.getId_tieuchuan());
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTieuChuan(int id_tieuchuan) {
		final String sql = "DELETE FROM tieuchuan WHERE id_tieuchuan=? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchuan);
			preparedStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<TieuChuan> searchTieuChuan(String key, int limit, int offset) {
		List<TieuChuan> listSearch = new ArrayList<TieuChuan>();
		final String sql = "SELECT * FROM tieuchuan  WHERE tentieuchuan LIKE ? ORDER BY id_tieuchuan ASC LIMIT ? OFFSET ?";
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
		}

		return listSearch;
	}

	@Override
	public int totalSearch(String key) {
		final String sql = "SELECT COUNT(*) AS total_tieuchuan FROM tieuchuan WHERE tentieuchuan LIKE ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_tieuchuan");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<TieuChuan> getAll() {
		List<TieuChuan> tieuchuanList = new ArrayList<TieuChuan>();
		final String sql = "SELECT * FROM tieuchuan ORDER BY id_tieuchuan ASC";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tieuchuanList.add(rowMapper(rs));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tieuchuanList;
	}

}
