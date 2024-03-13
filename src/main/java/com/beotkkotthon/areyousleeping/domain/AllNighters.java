package com.beotkkotthon.areyousleeping.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "all_nighters")
public class AllNighters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "all_nighters_id")
    private Long allNightersId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_team_id", nullable = false)
    private UserTeam userTeam;

    @Column(name = "start_at", nullable = false)
    private LocalDateTime startAt;

    @Column(name = "end_at", nullable = true)
    private LocalDateTime endAt;

    @Column(name = "duration", nullable = true)
    private Integer duration;

    @Builder
    private AllNighters(UserTeam userTeam) {
        this.userTeam = userTeam;
        this.startAt = LocalDateTime.now();
    }

    public void updateByEnd(Integer duration) {
        this.endAt = LocalDateTime.now();
        this.duration = (int) Duration.between(startAt, endAt).getSeconds();
    }
}
