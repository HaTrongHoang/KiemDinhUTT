package com.thang.dao;

import java.util.List;

import com.thang.model.TieuChuan;

public interface TieuChuanDao {
	// get all
	List<TieuChuan> getAll(int limit, int offset);
	List<TieuChuan> getAll();
	int totalTieuChuan();

//add
	void addTieuChuan(TieuChuan tieuchuan);

	TieuChuan getTenTieuChuan(String tieuchuan);

	// update
	TieuChuan getTieuChuanById(int id_tieuchuan);

	void updateTieuChuan(TieuChuan tieuchuan);

	// delete
	void deleteTieuChuan(int id_tieuchuan);

	// search
	List<TieuChuan> searchTieuChuan(String key, int limit, int offset);

	int totalSearch(String key);
}
