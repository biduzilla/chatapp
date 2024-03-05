package com.example.messagingstompwebsocket.repository;

import com.example.messagingstompwebsocket.enums.StatusUsuarioEnum;
import com.example.messagingstompwebsocket.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    List<Usuario> findByStatus(StatusUsuarioEnum status);
}
