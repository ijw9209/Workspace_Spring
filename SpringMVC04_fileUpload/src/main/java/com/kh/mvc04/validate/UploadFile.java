package com.kh.mvc04.validate;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	private String filename;
	private String desc;
	private MultipartFile file;
	//한번에 다수개의 파일을 받을 때는 List<MultipartFile> files 와 같이 선언하면 된다
	
	/*
	[ MultipartFile Interface ]
	업로드한 파일 정보 및 파일 데이터를 표현하기 위한 용도로 사용
	getName() : 파라미터 이름을 구한다
	getOriginalFilename() : 업로드 한 파일의 이름을 구한다
	isEmpty() : 업로드 한 파일이 존재하지 않는 경우 true를 리턴한다
	getSize() : 업로드 한 파일의 크기를 구한다
	getBytes() : 업로드한 파일 데이터를 구한다
	getInputStream() : 업로드 한 파일 데이터를 읽어오는 InputStream을 구한다
	                    InputStream의 사용이 끝나면 알맞게 종료해주어야 한다
	transferTo(File dest) : 업로드한 파일 데이터를 지정한 파일에 저장한다
*/
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
