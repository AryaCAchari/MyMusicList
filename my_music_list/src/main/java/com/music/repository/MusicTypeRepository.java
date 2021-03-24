package com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.model.MusicTypeBean;

@Repository
public interface MusicTypeRepository extends JpaRepository<MusicTypeBean, Long>{
	
}
