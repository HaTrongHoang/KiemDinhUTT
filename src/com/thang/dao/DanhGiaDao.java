package com.thang.dao;

import java.util.List;

import com.thang.model.DanhGia;

public interface DanhGiaDao {
	void addDanhGia(DanhGia danhgia);

	DanhGia getDanhGia(int tieuchi, int user);

	void updateDanhGia(DanhGia danhgia);

	List<DanhGia> getAll(int id_tieuchi, int limit, int offset);

	int totalGetAll(int id_tieuchi);

	DanhGia getDanhGia(int id_danhgia);

	void deleteDanhGia(int id_danhgia);
}
