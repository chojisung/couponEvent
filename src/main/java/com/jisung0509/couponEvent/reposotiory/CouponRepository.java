package com.jisung0509.couponEvent.reposotiory;

import com.jisung0509.couponEvent.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long>{

}
