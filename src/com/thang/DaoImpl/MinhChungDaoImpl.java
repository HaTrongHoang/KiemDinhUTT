package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.JDBCConnection;
import com.thang.dao.MinhChungDao;
import com.thang.model.MinhChung;
import com.thang.model.TaiKhoan;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

public class MinhChungDaoImpl extends JDBCConnection implements MinhChungDao {

	@Override
	public void addMinhChung(MinhChung minhchung) {
		final String sql = "INSERT INTO  minhchung(tenfile,tieuchi,user)" + "VALUES(?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, minhchung.getTenfile());
			preparedStatement.setInt(2, minhchung.getTieuchi().getId_tieuchi());
			preparedStatement.setInt(3, minhchung.getUser().getId_tk());
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
	public List<MinhChung> getList(int tieuchi, int user) {
		List<MinhChung> mcList = new ArrayList<MinhChung>();
		final String sql = "SELECT * FROM minhchung INNER JOIN tieuchi ON tieuchi.id_tieuchi=minhchung.tieuchi INNER JOIN taikhoan ON taikhoan.id_tk=minhchung.user INNER JOIN tieuchuan ON tieuchuan.id_tieuchuan=tieuchi.tieuchuan WHERE tieuchi=? AND user=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, tieuchi);
			preparedStatement.setInt(2, user);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				mcList.add(rowMapper(rs));
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

		return mcList;
	}

	private MinhChung rowMapper(ResultSet rs) throws SQLException {
		MinhChung minhchung = new MinhChung();
		minhchung.setId_file(rs.getInt("id_file"));
		minhchung.setTenfile(rs.getString("tenfile"));

		TieuChi tieuChi = new TieuChi();
		tieuChi.setId_tieuchi(rs.getInt("id_tieuchi"));
		tieuChi.setTentieuchi(rs.getString("tentieuchi"));
		tieuChi.setNoidung_tieuchi(rs.getString("noidung_tieuchi"));
		TieuChuan tieuChuan = new TieuChuan();
		tieuChuan.setId_tieuchuan(rs.getInt("id_tieuchuan"));
		tieuChuan.setTentieuchuan(rs.getString("tentieuchuan"));
		tieuChi.setTieuchuan(tieuChuan);
		minhchung.setTieuchi(tieuChi);

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
		minhchung.setUser(tk);
		return minhchung;
	}

	@Override
	public void deleteMinhChung(int id_minhchung) {
		final String sql = "DELETE FROM minhchung WHERE id_file = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_minhchung);
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
	public MinhChung getMinhChungId(int id_minhchung) {
		final String sql = "SELECT * FROM minhchung INNER JOIN tieuchi ON tieuchi.id_tieuchi=minhchung.tieuchi INNER JOIN taikhoan ON taikhoan.id_tk=minhchung.user INNER JOIN tieuchuan ON tieuchuan.id_tieuchuan=tieuchi.tieuchuan WHERE id_file=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_minhchung);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return rowMapper(rs);
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

		return null;
	}

}
