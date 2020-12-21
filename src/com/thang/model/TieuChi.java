package com.thang.model;

public class TieuChi {
	private int id_tieuchi;
	private String tentieuchi;
	private String noidung_tieuchi;

	private TieuChuan tieuchuan;

	public int getId_tieuchi() {
		return id_tieuchi;
	}

	public void setId_tieuchi(int id_tieuchi) {
		this.id_tieuchi = id_tieuchi;
	}

	public String getTentieuchi() {
		return tentieuchi;
	}

	public void setTentieuchi(String tentieuchi) {
		this.tentieuchi = tentieuchi;
	}

	public String getNoidung_tieuchi() {
		return noidung_tieuchi;
	}

	public void setNoidung_tieuchi(String noidung_tieuchi) {
		this.noidung_tieuchi = noidung_tieuchi;
	}

	public TieuChuan getTieuchuan() {
		return tieuchuan;
	}

	public void setTieuchuan(TieuChuan tieuchuan) {
		this.tieuchuan = tieuchuan;
	}

}
