package com.iu.boot3.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
	@Autowired
	private Transfer transfer;
	
	public void go() {
		//payment.cardCheck();
		transfer.bus();
		//payment.cardCheck();
		
		//payment.cardCheck();
		transfer.subway();
		//payment.cardCheck();
		
		//payment.cardCheck();
		transfer.bus();
		//payment.cardCheck();
	}
}
