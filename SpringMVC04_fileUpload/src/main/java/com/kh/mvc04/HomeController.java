package com.kh.mvc04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.kh.mvc04.validate.FileValidator;
import com.kh.mvc04.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	@RequestMapping("/form")
	public String getUploadForm() {
		return "uploadform";
	}
	//BindingResult : Errors의 하위 인터페이스로서 폼 값을 커맨드 객체에 바인딩한 결과를 저장하고 에러코드로 메세지를 가져온다.
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		// 업로드된 파일을 임의의 경로로 이동한다
		fileValidator.validate(uploadFile, result);
		
		
		//boolean hasErrors() : 에러가 존재하는 경우 true 리턴
		if(result.hasErrors()) {
			return "uploadform";
		}
		
		//파일저장
		MultipartFile file = uploadFile.getFile();
		String filename = file.getOriginalFilename();
		//getOriginalFilename(): 업로드 한 파일의 실제 !! 이름을 구한다.
		
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);		//이름,설명 set해줌
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
				//실제 경로를 가져옴
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		
			System.out.println("업로드 될 실제 경로 : " + path);
			
			//파일 객체생성 (경로)
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdirs(); 		//mkdirs()  존재하지 않는 부모 폴더까지 포함하여 해당 경로에 폴더를 만든다
			}
			//파일 이름 붙여주기
			File newfile = new File(path + "/" + filename);
			//파일이 존재하지않으면 createNewFile() : 주어진 이름의 파일이 없으면 새로 생성한다.
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newfile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
									//read(byte[] b) :바이트의 배열만큼 입력정보를 읽고 몇 바이트를 읽었는지를 반환 (byte[] ->buffer(데이터 임시 보관))
									//읽은 데이터가 없으면 -1반환
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
						//바이트의 배열의 시작위치(0)에서 길이(read)만큼 기록
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj", fileobj);
		
		return "uploadfile";
	}
	
	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDown(HttpServletRequest request, HttpServletResponse response, String filename) throws IOException {
		
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		File file = new File(path + "/" + filename);
	
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		// 한글은 http 헤더에 사용할 수 없기때문에 파일명은 영문으로 인코딩하여 헤더에 적용한다
		String fn = new String(file.getName().getBytes(), "8859_1");
		System.out.println("fn : "+fn);
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		// setContentLength 파일 사이즈 지정
		response.setContentLength(bytes.length);
		response.setContentType("image/jpeg");
		
		return bytes;
		 /*
         * Content-disposition 속성
         * 1) "Content-disposition: attachment" 브라우저 인식 파일확장자를 포함하여 모든 확장자의 파일들에 대해
         *                          , 다운로드시 무조건 "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다
         * 2) "Content-disposition: inline" 브라우저 인식 파일확장자를 가진 파일들에 대해서는 
         *                                  웹브라우저 상에서 바로 파일을 열고, 그외의 파일들에 대해서는 
         *                                  "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다.
         */
	}
}






