package com.thang.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thang.dao.JDBCConnection;
import com.thang.dao.TaiKhoanDao;
import com.thang.model.TaiKhoan;

public class TaiKhoanDaoImpl extends JDBCConnection implements TaiKhoanDao {

	@Override
	public void addTaiKhoan(TaiKhoan taikhoan) {
		final String sql = "INSERT INTO  taikhoan(hoten,taikhoan,matkhau,ngaysinh,diachi,gioitinh,img,sdt,role)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, taikhoan.getHoten());
			preparedStatement.setString(2, taikhoan.getTaikhoan());
			preparedStatement.setString(3, taikhoan.getMatkhau());
			preparedStatement.setString(4, taikhoan.getNgaysinh());
			preparedStatement.setString(5, taikhoan.getDiachi());
			preparedStatement.setString(6, taikhoan.getGioitinh());
			preparedStatement.setString(7, taikhoan.getImg());
			preparedStatement.setString(8, taikhoan.getSdt());
			preparedStatement.setInt(9, taikhoan.getRole());
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
	public TaiKhoan getSearchTK(String taikhoan) {
		String sql = "SELECT * FROM taikhoan WHERE taikhoan=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, taikhoan);
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

	private TaiKhoan rowMapper(ResultSet rs) throws SQLException {
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
		return tk;
	}

	@Override
	public List<TaiKhoan> getAll(int limit, int offset) {
		List<TaiKhoan> tkList = new ArrayList<TaiKhoan>();
		final String sql = "SELECT * FROM taikhoan LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tkList.add(rowMapper(rs));
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

		return tkList;
	}

	@Override
	public int totalTaiKhoan() {
		final String sql = "SELECT COUNT(*) AS total_taikhoan FROM taikhoan";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_taikhoan");
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
	public TaiKhoan getTK(String taikhoan) {
		String sql = "SELECT * FROM taikhoan WHERE taikhoan=? ";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, taikhoan);
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

	@Override
	public TaiKhoan getIdTK(int id_tk) {
		final String sql = "SELECT * FROM taikhoan WHERE id_tk=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tk);
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
	public void updateTK(TaiKhoan taikhoan) {
		final String sql = "UPDATE taikhoan SET hoten=?,ngaysinh=?,diachi=?,gioitinh=?,img=?,sdt=? WHERE id_tk=?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, taikhoan.getHoten());
			preparedStatement.setString(2, taikhoan.getNgaysinh());
			preparedStatement.setString(3, taikhoan.getDiachi());
			preparedStatement.setString(4, taikhoan.getGioitinh());
			preparedStatement.setString(5, taikhoan.getImg());
			preparedStatement.setString(6, taikhoan.getSdt());
			preparedStatement.setInt(7, taikhoan.getId_tk());
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
	public List<TaiKhoan> searchTK(String key, int limit, int offset) {
		List<TaiKhoan> listSearch = new ArrayList<TaiKhoan>();
		final String sql = "SELECT * FROM taikhoan WHERE hoten LIKE ? OR taikhoan LIKE ? LIMIT ? OFFSET ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			preparedStatement.setInt(3, limit);
			preparedStatement.setInt(4, offset);
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
		final String sql = "SELECT COUNT(*) AS total_taikhoan FROM taikhoan WHERE hoten LIKE ? OR taikhoan LIKE ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "%" + key + "%");
			preparedStatement.setString(2, "%" + key + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int total = rs.getInt("total_taikhoan");
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
	public void deleteTK(int id_tk) {
		final String sql = "DELETE FROM taikhoan WHERE id_tk = ?";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id_tk);
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
	public List<TaiKhoan> getAll() {
		List<TaiKhoan> tkList = new ArrayList<TaiKhoan>();
		final String sql = "SELECT * FROM taikhoan";
		Connection conn = super.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				tkList.add(rowMapper(rs));
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

		return tkList;
	}

}
