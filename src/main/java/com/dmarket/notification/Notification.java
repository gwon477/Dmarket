package com.dmarket.notification;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notiId;

    private Long receiver; //알림을 받는 유저의 정보

    private String content; //알람의 내용

    private String url; //해당 알림 클릭시 이동할 mapping url

    private Boolean isRead; //알림 열람에 대한 여부

    private LocalDateTime notificationCreatedDate;

    public static Notification create(SendNotificationEvent sendNotificationEvent) {
        return Notification.builder()
                .receiver(sendNotificationEvent.getReceiver())
                .content(sendNotificationEvent.getContent())
                .url(sendNotificationEvent.getUrl())
                .isRead(false)
                .notificationCreatedDate(LocalDateTime.now().withNano(0))
                .build();
    }

    public void updateIsRead(Boolean isRead){
        this.isRead = isRead;
    }
}
