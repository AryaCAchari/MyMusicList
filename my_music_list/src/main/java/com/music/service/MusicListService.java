package com.music.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.model.MusicListBean;
import com.music.model.MusicTypeBean;
import com.music.repository.MusicListRespository;
import com.music.repository.MusicTypeRepository;
import com.music.utils.CustomResponse;

@Service
public class MusicListService {
	
	@Autowired
	private MusicListRespository musicRepository;
	
	@Autowired
	private MusicTypeRepository typeRepository;
	
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
	
	public CustomResponse saveMusicType(MusicTypeBean bean) {
		try {
			String message = null;
			bean = this.typeRepository.save(bean);
			message = bean.getId() == null ? "New music genre added to the playlist!" : "Updated the music genre";
			return new CustomResponse(200, bean, message);
		}catch (Exception e) {
			e.printStackTrace();
			return new CustomResponse(500, null, "Music genre can't added, please try again");
		}
	}
	
	public CustomResponse findAll() {
		try {
			List<MusicListBean> list = this.musicRepository.findAll();
			for(MusicListBean bean : list) {
				//bean.setBean(this.typeRepository.getOne(bean.getMusicTypeId()));
				bean.setBean(this.typeRepository.findById(bean.getMusicTypeId()));
			}
			return new CustomResponse(200, list, "Playlist loaded!");
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
