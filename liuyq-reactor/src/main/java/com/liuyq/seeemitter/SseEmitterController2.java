package com.liuyq.seeemitter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

/**
 * @author liuyuqing
 * @className SseEmitterController2
 * @description
 * @date 2021/8/23 2:01 下午
 */
@RestController
@RequestMapping("/sse")
public class SseEmitterController2 {

    /**
     * 用于创建连接
     */
    @GetMapping("/connect/{userId}")
    public SseEmitter connect(@PathVariable String userId) {
        return SseEmitterServer.connect(userId);
    }

    @GetMapping("/close/{userId}")
    public void close(@PathVariable String userId) {
        SseEmitterServer.removeUser(userId);
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> list() {
        return ResponseEntity.ok(SseEmitterServer.getIds());
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getUserCount() {
        return ResponseEntity.ok(SseEmitterServer.getUserCount());
    }

    @GetMapping("/push/{message}")
    public ResponseEntity<String> push(@PathVariable(name = "message") String message) {
        SseEmitterServer.batchSendMessage(message);
        return ResponseEntity.ok("WebSocket 推送消息给所有人");
    }

    @GetMapping("/pushTag/{userId}/{message}")
    public ResponseEntity<String> pushTag(@PathVariable(name = "userId") String userId,
                                          @PathVariable(name = "message") String message) {
        SseEmitterServer.sendMessage(userId, message);
        return ResponseEntity.ok("WebSocket 推送消息给：" + userId);
    }
}
