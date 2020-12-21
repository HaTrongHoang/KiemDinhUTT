package com.thang.dao;

import java.util.List;

import com.thang.model.TongQuat;

public interface TongQuatDao {
	List<TongQuat> getAll(int limit, int offset);

	int totalTongQuat();

	void addTongQuat(TongQuat tongquat);

	List<TongQuat> getAll();

	TongQuat getIdTongQuat(int id_tongquat);

	void updateTongQuat(TongQuat tongquat);

	TongQuat getTieuDeTongQuat(String tieude_tongquat);

	void deleteTongQuat(int id_tongquat);

	List<TongQuat> searchTongQuat(String key, int limit, int offset);

	int totalSearch(String key);
}
