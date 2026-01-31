package com.jisung0509.couponEvent.service;

import com.jisung0509.couponEvent.domain.coupon.Coupon;
import com.jisung0509.couponEvent.reposotiory.CouponRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {
  private final CouponRepository couponRepository;

  @Transactional
  public void issue(){
    Coupon coupon = couponRepository.findById(1L)
        .orElseThrow(() -> new IllegalArgumentException("쿠폰이 존재하지 않습니다."));

    coupon.decreaseStock();

    // 3. 저장
    // JPA는 트랜잭션 안에서 객체의 값이 바뀌면(Dirty Checking),
    // save를 안 해도 자동으로 DB에 업데이트 쿼리를 날려줍니다.
    // 하지만 확실한 이해를 위해 명시적으로 save를 호출합니다.
    couponRepository.save(coupon);
  }
}
