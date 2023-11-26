package com.telusko.config;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//jis class mein bhi component laga hua hoga,@component scan 
//usko scan kar lega aur uska
//object bana lega

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
	
	
	public void handleWebSocketDisconnectListener() {
		
	}

}
