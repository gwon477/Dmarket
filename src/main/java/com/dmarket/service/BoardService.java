package com.dmarket.service;

import com.dmarket.domain.board.Faq;
import com.dmarket.domain.board.Notice;
import com.dmarket.dto.response.FaqListResDto;
import com.dmarket.dto.response.NoticeResDto;
import com.dmarket.repository.board.FaqRepository;
import com.dmarket.repository.board.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final NoticeRepository noticeRepository;
    private final FaqRepository faqRepository;

    // 공지사항 목록 조회
    public Page<Notice> getAllNotices(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
    public Page<NoticeResDto> mapToNoticeResDto(Page<Notice> noticesPage) {
        return noticesPage.map(no -> new NoticeResDto(no));
    }


    // FAQ 목록 조회
    public Page<Faq> getAllFaqs(Pageable pageable) {
        return faqRepository.findAll(pageable);
    }
    public Page<FaqListResDto> mapToFaqListResDto(Page<Faq> faqsPage) {
        return faqsPage.map(faq -> new FaqListResDto(
                faq.getFaqId(),
                faq.getFaqType(),
                faq.getFaqQuestion(),
                faq.getFaqAnswer()
        ));
    }

}
