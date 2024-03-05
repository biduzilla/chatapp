package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.model.Usuario;
import com.example.messagingstompwebsocket.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public Usuario addUser(@Payload Usuario usuario){
        return usuarioService.save(usuario);
    }

    @MessageMapping("/user.disconnect")
    @SendTo("/user/public")
    public void disconnect(@Payload String userId){
        usuarioService.disconnectOrConnect(userId,false);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> findConnectedUsers() {
        return ResponseEntity.ok(usuarioService.findConnectedUsers());
    }
}
