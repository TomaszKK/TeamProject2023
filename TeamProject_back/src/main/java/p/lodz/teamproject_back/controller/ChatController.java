package p.lodz.teamproject_back.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import p.lodz.teamproject_back.model.Chat;
import p.lodz.teamproject_back.repository.ChatRepository;

import java.util.List;
import java.util.Optional;
/*
public class ChatController {
  private ChatRepository chatRepository;

    @Autowired
    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping
    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Chat> getChatById(@PathVariable("id") Long id) {
        return chatRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Chat> addChat(@RequestBody Chat chat) {
        chatRepository.save(chat);
        return new ResponseEntity<>(chat, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Chat> deleteAllChats() {
        chatRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Chat> deleteChatById(@PathVariable("id") long id) {
        chatRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Chat> updateChat(@PathVariable("id") Long id, @RequestBody Chat updatedChat) {
        Optional<Chat> optionalChat = chatRepository.findById(id);
        if (optionalChat.isPresent()) {
            Chat chat = optionalChat.get();
            chatRepository.save(chat);
            return new ResponseEntity<>(chat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chat> replaceChat(@PathVariable("id") Long id, @RequestBody Chat newChat) {
        Optional<Chat> optionalChat = chatRepository.findById(id);
        if (optionalChat.isPresent()) {
            Chat chat = optionalChat.get();
            // Delete the existing chat
            chatRepository.delete(chat);

            // Create a new chat with the same ID
            Chat updatedChat = new Chat();
            updatedChat.setId(id);

            // Save the updated chat
            chatRepository.save(updatedChat);

            return new ResponseEntity<>(updatedChat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
*/
