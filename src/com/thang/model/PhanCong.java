package com.thang.model;

public class PhanCong {
	private int id_phancong;
	private TaiKhoan taikhoan;
	private TieuChuan tieuchuan;

	public int getId_phancong() {
		return id_phancong;
	}

	public void setId_phancong(int id_phancong) {
		this.id_phancong = id_phancong;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	public TieuChuan getTieuchuan() {
		return tieuchuan;
	}

	public void setTieuchuan(TieuChuan tieuchuan) {
		this.tieuchuan = tieuchuan;
	}

}
