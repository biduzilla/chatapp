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

    public void disconnect(Usuario usuario) {
        var storedUser = usuarioRepository.findById(usuario.getId()).orElseGet(() -> null);
        if (storedUser != null) {
            storedUser.setStatus(StatusUsuarioEnum.OFFLINE);
            usuarioRepository.save(storedUser);
        }
    }

    public List<Usuario> findConnectUsers() {
        return usuarioRepository.findByStatus(StatusUsuarioEnum.ONLINE);
    }
}
