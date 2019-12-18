/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionSupport;
import homestay.blos.CouponBLO;

/**
 *
 * @author tuannnh
 */
public class DeleteCouponAction extends ActionSupport {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    private String couponId, createError;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCreateError() {
        return createError;
    }

    public void setCreateError(String createError) {
        this.createError = createError;
    }

    public DeleteCouponAction() {
    }

    public String execute() throws Exception {
        CouponBLO blo = new CouponBLO();
        if( blo.delete(couponId)){
            return SUCCESS;
        }
        createError = "The Coupon can not delete because It's in use";
        return ERROR;
    }

}
