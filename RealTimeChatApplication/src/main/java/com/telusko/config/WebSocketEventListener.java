package com.telusko.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.telusko.config.chat.ChatMessage;
import com.telusko.config.chat.Messagetype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//jis class mein bhi component laga hua hoga,@component scan 
//usko scan kar lega aur uska
//object bana lega

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
	
		
	private final SimpMessageSendingOperations messageTemplate;
	

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String userName = (String) headerAccessor.getSessionAttributes().get("userName");
		if (userName != null) {
			log.info("User disconnected: {}", userName);
			var chatMessage = ChatMessage.builder()
					.type(Messagetype.LEAVE)
					.sender(userName)
					.build();
			
			messageTemplate.convertAndSend("/topic/public",chatMessage);
			
		}
	}

}
