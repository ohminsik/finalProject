package com.fm.www.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fm.www.dto.ChatMessage;
import com.fm.www.dto.User;
import com.fm.www.service.face.MemberService;



public class chatEchoHandler extends TextWebSocketHandler{
	private Logger logger = LoggerFactory.getLogger(chatEchoHandler.class);
	int cnt=0;

	 ObjectMapper objectMapper = new ObjectMapper();
	    List<WebSocketSession> list = Collections.synchronizedList(new ArrayList<>());
	    // 웹 소켓에 연결될 때 호출되는 메소드
	    @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	        System.out.println("접속===========================");
	        System.out.println(session.getId());
	        System.out.println("접속===========================");
	        list.add(session);
	        cnt++;
	        //현재 HttpSession의 id얻기
			String senderId = getId(session);
	        ChatMessage chatMessage = new ChatMessage();
	        chatMessage.setName( senderId);
	        chatMessage.setMessage("입장하셧습니다");
	        chatMessage.setCnt(cnt);
	        String json = objectMapper.writeValueAsString(chatMessage);
	        for(WebSocketSession wss : list){
	            wss.sendMessage(new TextMessage(json));
	           
	        }
	    }

	    // 메시지를 전송받았을때 호출되는 메소드
	    @Override
	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	        System.out.println("메시지가 왔어요...");
	        System.out.println(session.getId() + ", " + message.getPayload());
	        System.out.println("메시지가 왔어요...");
	       
	    	//현재 HttpSession의 id얻기
			String senderId = getId(session);
	        ChatMessage clientMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
	       
	       
	        ChatMessage chatMessage = new ChatMessage();
	        chatMessage.setName( senderId);
	        chatMessage.setMessage(clientMessage.getMessage());
	        System.out.println("아이디"+chatMessage.getName());
	        String json = objectMapper.writeValueAsString(chatMessage);
	        for(WebSocketSession wss : list){
	            wss.sendMessage(new TextMessage(json));
	           
	        }
	    }

	    // 웹 소켓이 연결이 클로즈될때 호출되는 메소드
	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	        System.out.println("접속 close===========================");
	        System.out.println(session.getId());
	        System.out.println("접속 close===========================");
	       
	        list.remove(session);
	        cnt--;
	        ChatMessage chatMessage = new ChatMessage();
	        User user = new User();
	      
	    	String senderId = getId(session);
	        chatMessage.setName( senderId);
	        chatMessage.setMessage("퇴장하셨습니다");
	        chatMessage.setCnt(cnt);
	        
	       
	        String json = objectMapper.writeValueAsString(chatMessage);
	        for (WebSocketSession wss : list) {
	         
	       
	             wss.sendMessage(new TextMessage(json)); 
	       
	        }
	 
	        logger.info(session.getId() + "님이 퇴장했습니다.");


	
	    }
		private String getId(WebSocketSession session) {
			Map<String, Object> httpSession = session.getAttributes();
			
			String loginUser = (String) httpSession.get("user_nick");
			System.out.println("ㅇㅇㅇ"+loginUser);
			
			if(null == loginUser) {
			
				return session.getId();
			}else {
			
				return loginUser;
			}
				
			
		}


}
