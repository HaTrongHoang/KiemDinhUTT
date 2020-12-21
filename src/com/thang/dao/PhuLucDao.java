package com.thang.dao;

import java.util.List;

import com.thang.model.PhuLuc;
import com.thang.model.TaiKhoan;

public interface PhuLucDao {
	List<PhuLuc> getAll(int limit, int offset);

	int totalPhuLuc();

	void addPhuLuc(PhuLuc phuluc);

	List<PhuLuc> getAll();

	PhuLuc getIdPhuLuc(int id_phuluc);

	void updatePhuLuc(PhuLuc phuluc);

	PhuLuc getTenPhuLuc(String tenphuluc);

	void deletePhuLuc(int id_phuluc);

	List<PhuLuc> searchPhuLuc(String key, int limit, int offset);

	int totalSearch(String key);
}
