package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.enums.StatusUsuarioEnum;
import com.example.messagingstompwebsocket.model.Usuario;
import com.example.messagingstompwebsocket.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        usuario.setStatus(StatusUsuarioEnum.ONLINE);
        return usuarioRepository.save(usuario);
    }

    public void disconnectOrConnect(String usuarioId, boolean isConnect) {
        usuarioRepository.findById(usuarioId).ifPresent(user -> {
            user.setStatus(isConnect ? StatusUsuarioEnum.ONLINE : StatusUsuarioEnum.OFFLINE);
            usuarioRepository.save(user);
        });
    }

    public List<Usuario> findConnectedUsers() {
        return usuarioRepository.findByStatus(StatusUsuarioEnum.ONLINE);
    }
}
