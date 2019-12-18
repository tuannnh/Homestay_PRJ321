/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionSupport;
import homestay.blos.CouponBLO;
import homestay.blos.RoomBLO;

/**
 *
 * @author tuannnh
 */
public class CreateCouponAction extends ActionSupport {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private String couponId, couponName, beginDate, endDate, createError, couponIdError;
    private double discountRate;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateError() {
        return createError;
    }

    public void setCreateError(String createError) {
        this.createError = createError;
    }

    public String getCouponIdError() {
        return couponIdError;
    }

    public void setCouponIdError(String couponIdError) {
        this.couponIdError = couponIdError;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public CreateCouponAction() {
    }

    public String execute() throws Exception {
        CouponBLO blo = new CouponBLO();
        System.out.println("BeginDate" + beginDate);
        System.out.println("EndDate" + endDate);
        System.out.println("BeginDate" + convertToSqlDate(beginDate));
        System.out.println("EndDate" + convertToSqlDate(endDate));
        if (blo.insert(couponId, couponName, discountRate / 100, convertToSqlDate(beginDate), convertToSqlDate(endDate))) {
            return SUCCESS;
        }
        couponIdError = couponId;
        createError = "Coupon ID is existed!";
        return ERROR;
    }

    private String convertToSqlDate(String date) {
        String[] temp = date.split("/");
        String convertedDate = temp[2] + "-" + temp[1] + "-" + temp[0];
        return convertedDate;
    }

}
