package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.model.MusicListBean;

@Repository
public interface MusicListRespository extends JpaRepository<MusicListBean, Long>{
	
}
