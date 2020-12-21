package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.JDBCConnection;
import com.thang.dao.PhanCongDao;
import com.thang.model.PhanCong;
import com.thang.model.TaiKhoan;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

public class PhanCongDaoImpl extends JDBCConnection implements PhanCongDao {

	@Override
	public List<PhanCong> getAll(int limit, int offset) {
		List<PhanCong> phancongList = new ArrayList<PhanCong>();
		final String sql = "SELECT * FROM phancong INNER JOIN tieuchuan ON phancong.tieuchuan=tieuchuan.id_tieuchuan INNER JOIN taikhoan ON phancong.taikhoan=taikhoan.id_tk ORDER BY id_phancong DESC  LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				phancongList.add(rowMapper(rs));
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

		return phancongList;
	}

	private PhanCong rowMapper(ResultSet rs) throws SQLException {
		PhanCong phancong = new PhanCong();
		phancong.setId_phancong(rs.getInt("id_phancong"));

		TieuChuan tieuchuan = new TieuChuan();
		tieuchuan.setId_tieuchuan(rs.getInt("id_tieuchuan"));
		tieuchuan.setTentieuchuan(rs.getString("tentieuchuan"));
		tieuchuan.setNoidung_tieuchuan(rs.getString("noidung_tieuchuan"));

		phancong.setTieuchuan(tieuchuan);

		TaiKhoan tk = new TaiKhoan();
		tk.setId_tk(rs.getInt("id_tk"));
		tk.setHoten(rs.getString("hoten"));
		tk.setDiachi(rs.getString("diachi"));
		tk.setNgaysinh(rs.getString("ngaysinh"));
		tk.setGioitinh(rs.getString("gioitinh"));
		tk.setSdt(rs.getString("sdt"));
		tk.setImg(rs.getString("img"));
		tk.setMatkhau(rs.getString("matkhau"));
		tk.setTaikhoan(rs.getString("taikhoan"));

		phancong.setTaikhoan(tk);
		return phancong;
	}

	@Override
	public int totalPhanCong() {
		final String sql = "SELECT COUNT(*) AS total_phancong FROM phancong INNER JOIN tieuchuan ON phancong.tieuchuan=tieuchuan.id_tieuchuan INNER JOIN taikhoan ON phancong.taikhoan=taikhoan.id_tk";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_phancong");
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
	public void updatePhanCong(PhanCong phancong) {

	}

	@Override
	public void deletePhanCong(int id_phancong) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPhanCong(PhanCong phancong) {
		final String sql = "INSERT INTO  phancong(taikhoan,tieuchuan)" + "VALUES(?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, phancong.getTaikhoan().getId_tk());
			preparedStatement.setInt(2, phancong.getTieuchuan().getId_tieuchuan());
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
	public TieuChuan getPhanCong(int taikhoan, int tieuchuan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhanCong> getAll() {
		List<PhanCong> phancongList = new ArrayList<PhanCong>();
		final String sql = "SELECT * FROM phancong INNER JOIN tieuchuan ON phancong.tieuchuan=tieuchuan.id_tieuchuan INNER JOIN taikhoan ON phancong.taikhoan=taikhoan.id_tk";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				phancongList.add(rowMapper(rs));
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

		return phancongList;
	}

	@Override
	public PhanCong getTieuChuan(int tieuchuan) {
		final String sql = "SELECT * FROM phancong INNER JOIN tieuchuan ON phancong.tieuchuan=tieuchuan.id_tieuchuan INNER JOIN taikhoan ON phancong.taikhoan=taikhoan.id_tk WHERE tieuchuan=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, tieuchuan);
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

}
