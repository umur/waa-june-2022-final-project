package com.finalproject.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
public class OffensiveUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;
    private LocalDateTime requestAt;
    private int banTime = 15 * 60;

    public String userName;

    public OffensiveUser(int count, LocalDateTime localDateTime, String user) {
        this.getId();
        this.count = count;
        this.requestAt = localDateTime;
        this. userName = user;
    }

    public long ban() {
        Duration diff = Duration.between(requestAt, LocalDateTime.now());
        if (diff.toSeconds() < banTime) {
            return banTime - diff.toSeconds();
        }
        return 0;
    }
}
