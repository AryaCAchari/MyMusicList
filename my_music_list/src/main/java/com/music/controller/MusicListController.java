package com.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.music.model.MusicListBean;
import com.music.model.MusicTypeBean;
import com.music.service.MusicListService;
import com.music.utils.CustomResponse;

@RestController
@RequestMapping("music/")
public class MusicListController {
	
	@Autowired
	private MusicListService musicListService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public CustomResponse save(@RequestBody MusicListBean bean) {
		return this.musicListService.save(bean);
	}
	
	@RequestMapping(value = "save/type", method = RequestMethod.POST)
	public CustomResponse saveType(@RequestBody MusicTypeBean bean) {
		return this.musicListService.saveMusicType(bean);
	}
	
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public CustomResponse getAll() {
		return this.musicListService.findAll();
	}
	
	@RequestMapping(value = "get/all/genre", method = RequestMethod.GET)
	public CustomResponse getAllGenre() {
		return this.musicListService.findAllGnre();
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public CustomResponse delete(@PathVariable Long id) {
		return this.musicListService.deletebyId(id);
	}
	
	@RequestMapping(value = "delete/genre/{id}", method = RequestMethod.DELETE)
	public CustomResponse deleteGenre(@PathVariable Long id) {
		return this.musicListService.deleteMusicGenreById(id);
	}
}
