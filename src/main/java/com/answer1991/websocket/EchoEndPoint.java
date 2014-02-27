package com.answer1991.websocket;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/myWebSocket")
public class EchoEndPoint {
	@OnMessage
	public void onMessage(Session session, String text) {
		try {
			session.getBasicRemote().sendText(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
