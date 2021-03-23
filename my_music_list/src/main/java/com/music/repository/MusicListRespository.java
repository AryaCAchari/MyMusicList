package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.model.MusicListBean;

public interface MusicListRespository extends JpaRepository<MusicListBean, Long>{
	
}
