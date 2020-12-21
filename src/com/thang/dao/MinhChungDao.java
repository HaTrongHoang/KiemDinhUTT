package com.thang.dao;

import java.util.List;

import com.thang.model.MinhChung;

public interface MinhChungDao {
	void addMinhChung(MinhChung minhchung);

	List<MinhChung> getList(int tieuchi, int user);

	void deleteMinhChung(int id_minhchung);

	MinhChung getMinhChungId(int id_minhchung);
}
