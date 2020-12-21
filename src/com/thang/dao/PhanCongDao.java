package com.thang.dao;

import java.util.List;

import com.thang.model.PhanCong;
import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

public interface PhanCongDao {
	List<PhanCong> getAll(int limit, int offset);

	int totalPhanCong();

	void updatePhanCong(PhanCong phancong);

	void deletePhanCong(int id_phancong);

	void addPhanCong(PhanCong phancong);

	TieuChuan getPhanCong(int taikhoan, int tieuchuan);

	List<PhanCong> getAll();

	PhanCong getTieuChuan(int tieuchuan);
}
