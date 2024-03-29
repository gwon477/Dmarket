package com.dmarket.domain.board;

import com.dmarket.constant.FaqType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Faq {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faqId;

    @Enumerated(EnumType.STRING)
    private FaqType faqType;

    @Column(columnDefinition="TEXT")
    private String faqQuestion;

    @Column(columnDefinition="TEXT")
    private String faqAnswer;


    @Builder
    public Faq(FaqType faqType, String faqQuestion, String faqAnswer) {
        this.faqType = faqType;
        this.faqQuestion = faqQuestion;
        this.faqAnswer = faqAnswer;
    }
}
