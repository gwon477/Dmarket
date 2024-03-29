package com.dmarket.repository.product;

import com.dmarket.domain.product.ProductReview;
import com.dmarket.dto.common.ProductCommonDto;
import com.dmarket.dto.response.AdminResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    // 상품ID로 리뷰 개수 조회
    Long countByProductId(Long productId);

    // 상품 번호로 리뷰 목록 조회
    @Query("select new com.dmarket.dto.common.ProductCommonDto$ProductReviewDto" +
            "(r.reviewId, u.userName, o.optionValue, r.reviewRating, r.reviewContents, r.reviewCreatedDate, r.reviewImg) " +
            "from ProductReview r " +
            "join User u on r.userId = u.userId " +
            "join ProductOption o on r.optionId = o.optionId " +
            "where r.productId = :productId")
    Page<ProductCommonDto.ProductReviewDto> findReviewByProductId(Pageable pageable, Long productId);

    void deleteByReviewId(@Param("reviewId") Long reviewId);

    @Query("select new com.dmarket.dto.response.AdminResDto$AdminReviewsResDto" +
            "(r, o, u, p) " +
            "from ProductReview r " +
            "join User u on r.userId = u.userId " +
            "join Product p on r.productId = p.productId " +
            "join ProductOption o on r.optionId = o.optionId ORDER BY r.reviewId DESC")
    Page<AdminResDto.AdminReviewsResDto> getProductReviews(Pageable pageable);
}
