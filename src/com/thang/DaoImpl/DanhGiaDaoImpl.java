package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.DanhGiaDao;
import com.thang.dao.JDBCConnection;
import com.thang.model.DanhGia;
import com.thang.model.TaiKhoan;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

public class DanhGiaDaoImpl extends JDBCConnection implements DanhGiaDao {

	@Override
	public void addDanhGia(DanhGia danhgia) {
		final String sql = "INSERT INTO  danhgia(tieuchi,mota,diemmanh,diemtontai,kehoach,tudanhgia,user,thoigian)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, danhgia.getTieuchi().getId_tieuchi());
			preparedStatement.setString(2, danhgia.getMota());
			preparedStatement.setString(3, danhgia.getDiemmanh());
			preparedStatement.setString(4, danhgia.getDiemtontai());
			preparedStatement.setString(5, danhgia.getKehoach());
			preparedStatement.setString(6, danhgia.getTudanhgia());
			preparedStatement.setInt(7, danhgia.getUser().getId_tk());
			preparedStatement.setString(8, danhgia.getThoigian());
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
	public DanhGia getDanhGia(int tieuchi, int user) {
		String sql = "SELECT * FROM danhgia INNER JOIN tieuchi ON tieuchi.id_tieuchi=danhgia.tieuchi INNER JOIN taikhoan ON taikhoan.id_tk=danhgia.user INNER JOIN tieuchuan ON tieuchuan.id_tieuchuan=tieuchi.tieuchuan WHERE tieuchi=? AND user=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, tieuchi);
			preparedStatement.setInt(2, user);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private DanhGia rowMapper(ResultSet rs) throws SQLException {
		DanhGia danhgia = new DanhGia();
		danhgia.setId_danhgia(rs.getInt("id_danhgia"));
		TieuChi tieuchi = new TieuChi();
		tieuchi.setId_tieuchi(rs.getInt("id_tieuchi"));
		tieuchi.setTentieuchi(rs.getString("tentieuchi"));
		tieuchi.setNoidung_tieuchi(rs.getString("noidung_tieuchi"));

		TieuChuan tieuchuan = new TieuChuan();
		tieuchuan.setId_tieuchuan(rs.getInt("id_tieuchuan"));
		tieuchuan.setTentieuchuan(rs.getString("tentieuchuan"));
		tieuchuan.setNoidung_tieuchuan(rs.getString("noidung_tieuchuan"));
		tieuchi.setTieuchuan(tieuchuan);
		danhgia.setTieuchi(tieuchi);

		danhgia.setMota(rs.getString("mota"));
		danhgia.setDiemmanh(rs.getString("diemmanh"));
		danhgia.setDiemtontai(rs.getString("diemtontai"));
		danhgia.setKehoach(rs.getString("kehoach"));
		danhgia.setTudanhgia(rs.getString("tudanhgia"));
		danhgia.setThoigian(rs.getString("thoigian"));

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
		danhgia.setUser(tk);
		return danhgia;
	}

	@Override
	public void updateDanhGia(DanhGia danhgia) {
		final String sql = "UPDATE danhgia SET tieuchi=?,mota=?,diemmanh=?,diemtontai=?,kehoach=?,tudanhgia=?,user=?,thoigian=? WHERE id_danhgia=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, danhgia.getTieuchi().getId_tieuchi());
			preparedStatement.setString(2, danhgia.getMota());
			preparedStatement.setString(3, danhgia.getDiemmanh());
			preparedStatement.setString(4, danhgia.getDiemtontai());
			preparedStatement.setString(5, danhgia.getKehoach());
			preparedStatement.setString(6, danhgia.getTudanhgia());
			preparedStatement.setInt(7, danhgia.getUser().getId_tk());
			preparedStatement.setString(8, danhgia.getThoigian());
			preparedStatement.setInt(9, danhgia.getId_danhgia());
			preparedStatement.executeUpdate();
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
	public List<DanhGia> getAll(int id_tieuchi, int limit, int offset) {
		List<DanhGia> danhgiaList = new ArrayList<DanhGia>();
		final String sql = "SELECT * FROM danhgia INNER JOIN tieuchi ON tieuchi.id_tieuchi=danhgia.tieuchi INNER JOIN taikhoan ON taikhoan.id_tk=danhgia.user INNER JOIN tieuchuan ON tieuchuan.id_tieuchuan=tieuchi.tieuchuan WHERE tieuchi=? LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchi);
			preparedStatement.setInt(2, limit);
			preparedStatement.setInt(3, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				danhgiaList.add(rowMapper(rs));
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

		return danhgiaList;
	}

	@Override
	public int totalGetAll(int id_tieuchi) {
		final String sql = "SELECT COUNT(*) AS total_danhgia FROM danhgia INNER JOIN tieuchi ON tieuchi.id_tieuchi=danhgia.tieuchi INNER JOIN taikhoan ON taikhoan.id_tk=danhgia.user INNER JOIN tieuchuan ON tieuchuan.id_tieuchuan=tieuchi.tieuchuan WHERE tieuchi=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tieuchi);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_danhgia");
				return total;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public DanhGia getDanhGia(int id_danhgia) {
		String sql = "SELECT * FROM danhgia INNER JOIN tieuchi ON tieuchi.id_tieuchi=danhgia.tieuchi INNER JOIN taikhoan ON taikhoan.id_tk=danhgia.user INNER JOIN tieuchuan ON tieuchuan.id_tieuchuan=tieuchi.tieuchuan WHERE id_danhgia=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_danhgia);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteDanhGia(int id_danhgia) {
		final String sql = "DELETE FROM danhgia WHERE id_danhgia = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_danhgia);
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

}
