package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Jednorozec;;

public interface JednorozecManagerIn {

	void addJednorozec(Jednorozec jednorozec);
	List<Jednorozec> getAllJednorozce();
	void deleteJednorozec(Jednorozec jednorozec);
	Jednorozec getJednorozecById(long id);
}
