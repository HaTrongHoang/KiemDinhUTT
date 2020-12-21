package com.thang.model;

public class DanhGia {
	private int id_danhgia;
	private TieuChi tieuchi;
	private String mota;
	private String diemmanh;
	private String diemtontai;
	private String kehoach;
	private String tudanhgia;
	private TaiKhoan user;
	private String thoigian;

	public int getId_danhgia() {
		return id_danhgia;
	}

	public void setId_danhgia(int id_danhgia) {
		this.id_danhgia = id_danhgia;
	}

	public TieuChi getTieuchi() {
		return tieuchi;
	}

	public void setTieuchi(TieuChi tieuchi) {
		this.tieuchi = tieuchi;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getDiemmanh() {
		return diemmanh;
	}

	public void setDiemmanh(String diemmanh) {
		this.diemmanh = diemmanh;
	}

	public String getDiemtontai() {
		return diemtontai;
	}

	public void setDiemtontai(String diemtontai) {
		this.diemtontai = diemtontai;
	}

	public String getKehoach() {
		return kehoach;
	}

	public void setKehoach(String kehoach) {
		this.kehoach = kehoach;
	}

	public String getTudanhgia() {
		return tudanhgia;
	}

	public void setTudanhgia(String tudanhgia) {
		this.tudanhgia = tudanhgia;
	}

	public TaiKhoan getUser() {
		return user;
	}

	public void setUser(TaiKhoan user) {
		this.user = user;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

}
