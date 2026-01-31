package com.jisung0509.couponEvent.controller;

import com.jisung0509.couponEvent.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
@RequiredArgsConstructor
public class CouponController {
  private final CouponService couponService;

  @PostMapping("/issue")
  public String issueCoupon(){
    couponService.issue();
    return "쿠폰 발급 성공";
  }

}
