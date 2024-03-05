package com.example.messagingstompwebsocket.model;

import com.example.messagingstompwebsocket.enums.StatusUsuarioEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nickName;
    private String fullName;
    private StatusUsuarioEnum status;
}
