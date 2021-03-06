package com.example.hotel.bl.coupon;

import com.example.hotel.po.Coupon;
import com.example.hotel.vo.CouponVO;
import com.example.hotel.vo.HotelTargetMoneyCouponVO;
import com.example.hotel.vo.OrderVO;
import com.example.hotel.vo.TimeCouponVO;

import java.util.List;

/**
 * @author Daiqj
 */
public interface CouponService {

    /**
     * 返回某一订单可用的优惠策略列表
     *
     * @param orderVO 用户VO
     * @return 某一订单可用的优惠策略列表
     */
    List<Coupon> getMatchOrderCoupon(OrderVO orderVO);

    /**
     * 查看某个酒店提供的所有优惠策略（包括失效的）
     *
     * @param hotelId 酒店ID
     * @return 某个酒店提供的所有优惠策略（包括失效的）
     */
    List<Coupon> getHotelAllCoupon(Integer hotelId);

    /**
     * 添加酒店满减优惠策略
     *
     * @param couponVO 优惠券VO
     * @return CouponVO
     */
    CouponVO addHotelTargetMoneyCoupon(HotelTargetMoneyCouponVO couponVO);

    /**
     * 添加酒店限时优惠策略
     *
     * @param couponVO 优惠券VO
     * @return CouponVO
     */
    CouponVO addHotelTimeCoupon(TimeCouponVO couponVO);
}