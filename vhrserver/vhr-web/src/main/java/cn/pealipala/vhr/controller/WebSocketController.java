package cn.pealipala.vhr.controller;

import cn.pealipala.vhr.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

/**
 * @author yechaoze
 * @version 1.0
 * @date 2020/7/27 20:25
 */
@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handlerMessage(Principal principal, ChatMessage chatMessage){
        chatMessage.setFrom(principal.getName());
        chatMessage.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getTo(),"/queue/chat",chatMessage);
    }
}
