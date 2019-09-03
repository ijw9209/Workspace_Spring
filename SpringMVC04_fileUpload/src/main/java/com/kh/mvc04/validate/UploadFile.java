package com.kh.mvc04.validate;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	private String filename;
	private String desc;
	private MultipartFile file;
	//한번에 다수개의 파일을 받을 때는 List<MultipartFile> files 와 같이 선언하면 된다
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
