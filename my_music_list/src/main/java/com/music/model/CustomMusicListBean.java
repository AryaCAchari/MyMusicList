package com.music.model;

import java.util.Optional;

public class CustomMusicListBean {
	
	private Optional<MusicTypeBean> bean;

	public Optional<MusicTypeBean> getBean() {
		return bean;
	}

	public void setBean(Optional<MusicTypeBean> bean) {
		this.bean = bean;
	}
}
