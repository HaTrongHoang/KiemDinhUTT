package com.thang.model;

public class MinhChung {
	private int id_file;
	private String tenfile;
	private TieuChi tieuchi;
	private TaiKhoan user;

	public int getId_file() {
		return id_file;
	}

	public void setId_file(int id_file) {
		this.id_file = id_file;
	}

	public String getTenfile() {
		return tenfile;
	}

	public void setTenfile(String tenfile) {
		this.tenfile = tenfile;
	}

	public TieuChi getTieuchi() {
		return tieuchi;
	}

	public void setTieuchi(TieuChi tieuchi) {
		this.tieuchi = tieuchi;
	}

	public TaiKhoan getUser() {
		return user;
	}

	public void setUser(TaiKhoan user) {
		this.user = user;
	}

}
