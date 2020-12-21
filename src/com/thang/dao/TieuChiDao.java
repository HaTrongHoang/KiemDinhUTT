package com.thang.dao;

import java.util.List;

import com.thang.model.TieuChi;
import com.thang.model.TieuChuan;

public interface TieuChiDao {

	// get all
	List<TieuChi> getAll(int id_tieuchuan, int limit, int offset);

	List<TieuChi> getAll();

	int totalTieuChi(int id_tieuchuan);

	// add
	void addTieuChi(TieuChi tieuchi);

	TieuChi getTenTieuChi(String tieuchi);

	// update

	TieuChi getTieuChiById(int id_tieuchi);

	void updateTieuChi(TieuChi tieuchi);

	// delete
	void deleteTieuChi(int id_tieuchi);

	// search
	List<TieuChi> searchTieuChi(String key, int tieuchuan, int limit, int offset);

	int totalSearch(String key, int tieuchuan);

}
