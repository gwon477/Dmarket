package com.dmarket.domain.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QnaReply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qnaReplyId;

    private Long qnaId;

    @Column(columnDefinition="TEXT")
    private String qnaReplyContents;

    private LocalDateTime qnaReplyDate;


    @Builder
    public QnaReply(Long qnaId, String qnaReplyContents) {
        this.qnaId = qnaId;
        this.qnaReplyContents = qnaReplyContents;
        this.qnaReplyDate = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);
    }
}
