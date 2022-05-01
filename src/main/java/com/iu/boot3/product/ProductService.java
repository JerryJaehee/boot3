package com.iu.boot3.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.boot3.util.FileManager;
import com.iu.boot3.util.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FileManager fileManager;
	
	public int setFileDelete(ProductFilesVO productFilesVO) throws Exception {
		//hdd에서 파일 삭제를 위해 파일 조회(fileName을 넘겨줘야 하니까)
		productFilesVO = productMapper.getFileDetail(productFilesVO);
		
		//DB 삭제
		int check = productMapper.setFileDelete(productFilesVO);
		if(check > 0) {
			//HDD에서 파일 삭제
			boolean result = fileManager.remove(productFilesVO.getFileName(), "resources/upload/product/");
			
		}
		return check;
	}
	
	public int setUpdate(ProductVO productVO, MultipartFile [] files) throws Exception {
		int result = productMapper.setUpdate(productVO);
		
//		// file update
//			// 1. HDD에 저장
//			for (int i = 0; i < files.length; i++) {
//				if (files[i].isEmpty()) {
//					// files[i].getSize()==0
//					continue;
//				}
//			String fileName = fileManager.fileSave(files[i], "resources/upload/product/");
//			System.out.println("file save");
//			// 2. DB에 저장
//			ProductFilesVO productFilesVO = new ProductFilesVO();
//			productFilesVO.setProductNum(productVO.getProductNum());
//			productFilesVO.setFileName(fileName);
//			productFilesVO.setOriName(files[i].getOriginalFilename());
//			result = productMapper.setFileAdd(productFilesVO);
//				}
		if(files != null) {
			for(MultipartFile multipartFile:files) {
				if(multipartFile.isEmpty()) {
					continue;
				}
				String fileName = fileManager.fileSave(multipartFile, "resources/upload/product/");
				//2. DB에 저장
				ProductFilesVO productFilesVO = new ProductFilesVO();
				productFilesVO.setProductNum(productVO.getProductNum());
				productFilesVO.setFileName(fileName);
				productFilesVO.setOriName(multipartFile.getOriginalFilename());
				result = productMapper.setFileAdd(productFilesVO);
				
			}
		}
				
		return result;
	}
	
	public ProductVO getDetail(ProductVO productVO) throws Exception {
		return productMapper.getDetail(productVO);
	}
	
	public int setAdd(ProductVO productVO, MultipartFile [] files)throws Exception{
		int result = productMapper.setAdd(productVO);
		
		if(files != null) {
			
			for(MultipartFile f : files) {
				if(f.isEmpty()) {
					continue;
				}
			
			String fileName= fileManager.fileSave(f, "resources/upload/product/");
			ProductFilesVO productFilesVO = new ProductFilesVO();
			productFilesVO.setProductNum(productVO.getProductNum());
			productFilesVO.setFileName(fileName);
			productFilesVO.setOriName(f.getOriginalFilename());
			result = productMapper.setFileAdd(productFilesVO);
		}
		}
		return result;
	}
	public List<ProductVO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(productMapper.getTotalCount(pager));
		
		return productMapper.getList(pager);
	}
}
