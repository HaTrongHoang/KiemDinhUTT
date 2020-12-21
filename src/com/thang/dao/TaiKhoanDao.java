package com.thang.dao;

import java.util.List;

import com.thang.model.TaiKhoan;

public interface TaiKhoanDao {
	void addTaiKhoan(TaiKhoan taikhoan);

	TaiKhoan getSearchTK(String taikhoan);

	List<TaiKhoan> getAll(int limit, int offset);

	int totalTaiKhoan();

	TaiKhoan getTK(String taikhoan);

	TaiKhoan getIdTK(int id_tk);

	void updateTK(TaiKhoan taikhoan);

	List<TaiKhoan> searchTK(String key, int limit, int offset);

	int totalSearch(String key);

	void deleteTK(int id_tk);

	List<TaiKhoan> getAll();
}
