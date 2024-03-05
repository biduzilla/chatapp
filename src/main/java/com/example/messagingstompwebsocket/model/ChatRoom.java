package com.example.messagingstompwebsocket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="chat_room_id")
    private String id;
    @OneToMany(mappedBy = "chatroom")
    private List<ChatMessage> chatMessages;
}
