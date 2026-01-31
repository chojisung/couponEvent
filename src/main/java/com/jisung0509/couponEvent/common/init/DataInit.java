package com.jisung0509.couponEvent.common.init;

import com.jisung0509.couponEvent.domain.coupon.Coupon;
import com.jisung0509.couponEvent.reposotiory.CouponRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInit {
  private final CouponRepository couponRepository;

  // [중요] @PostConstruct: 스프링 부트가 시작될 때(@Component로 등록된 객체가 생성된 직후),
  //                        딱 한 번만 실행되는 메서드입니다.
  //                        앱 켜자마자 쿠폰 데이터를 쑤셔 넣기 위해 씁니다.
  @PostConstruct
  public void init(){
    Coupon coupon = Coupon.builder().stock(100).build();

    couponRepository.save(coupon);
    System.out.println("쿠폰 100개 생성 완료");
  }
}
