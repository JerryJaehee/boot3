package com.iu.boot3.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	@Autowired
	private ServletContext servletContext;
	
	public boolean remove(String path, String fileName)throws Exception{
		//파일을 HDD에서 삭제
		//저장된 폴더명, 저장된 파일명
		path = servletContext.getRealPath(path);
		
		File file = new File(path, fileName);
		
		return file.delete();
	}

	public String fileSave(MultipartFile mf, String path) throws Exception {
		// path = "프로젝트상의 파일을 저장할 폴더의 경로"
		path = servletContext.getRealPath(path);
		System.out.println(path);
		
		File file = new File(path);
		// 폴더가 없을경우 만들기
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//파일명 중복을 피하기 위해 UUID로 만든 후 확장자 붙이기
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+mf.getOriginalFilename();
		
		// 1. 파일을 HDD에 저장하고
		file = new File(file, fileName);
		mf.transferTo(file);

		// 2. 저장된 파일명을 리턴(파일명은 중복X)
		return fileName;
	}
}
