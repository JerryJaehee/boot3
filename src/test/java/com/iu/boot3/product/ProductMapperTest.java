package com.iu.boot3.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductMapperTest {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void setAddTest() throws Exception {
		ProductVO productVO = new ProductVO();
		productVO.setProductName("proName");
		productVO.setProductPrice(3000L);
		productVO.setProductCount(50L);
		productVO.setProductDetail("proDetail");
		int result = productMapper.setAdd(productVO);
		assertEquals(1, result);
	}
	
//	@Test
//	public void getListTest() throws Exception {
//		List<ProductVO> ar = productMapper.getList();
//		assertNotNull(ar);
//	}

}
