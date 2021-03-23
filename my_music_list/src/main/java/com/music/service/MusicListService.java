package com.music.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.MusicListBean;
import com.music.repository.MusicListRespository;
import com.music.utils.CustomResponse;

@Service
public class MusicListService {
	
	@Autowired
	private MusicListRespository musicRepository;
	
	public CustomResponse save(MusicListBean bean) {
		try {
			String message = null;
			if(bean.getId() != null)
				bean.setUdpatedOn(new Date());
			else
				bean.setCreatedOn(new Date());
			bean = this.musicRepository.save(bean);
			message = bean.getId() == null ? "New music added to the playlist!" : "Updated the music details";
			return new CustomResponse(200, bean, message);
		}catch (Exception e) {
			e.printStackTrace();
			return new CustomResponse(500, null, "Music can't added, please try again");
		}
	}
	
	public CustomResponse findAll() {
		try {
			return new CustomResponse(200, this.musicRepository.findAll(), "Playlist loaded!");
		}catch (Exception e) {
			e.printStackTrace();
			return new CustomResponse(500, null, "No playlist to show!");
		}
	}
	
	public CustomResponse deletebyId(Long id) {
		try {
			this.musicRepository.deleteById(id);
			return new CustomResponse(200, null, "Music removed from playlist");
		}catch (Exception e) {
			e.printStackTrace();
			return new CustomResponse(500, null, "Something went wrong");
		}
	}
}
