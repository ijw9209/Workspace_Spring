package com.kh.mvc04.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}
	//Error :  유효성 검증 결과를 저장할 떄 사용
	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile) target;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file","errorCode","Pleas select a file");
							//file uploadform.jsp form:errors path="file" ,errorCode  , msg 
		}
	}
	
	/*boolean supports(Class clazz) : 어떤 타입의 객체를 검증할 때 이 객체의 클래스가 
	  									이 Validator가 검증할 수 있는 클래스인 지를 판단하는 매서드
	  void validate(Object target, Errors error) : 실제 검증 로직이 이루어지는 메서드, 구현할 때 ValidationUtils를 사용하여 편리하게 작성 가능
	  
	 */

}
