/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import com.opensymphony.xwork2.ActionSupport;
import homestay.blos.CouponBLO;
import homestay.entities.Coupons;
import java.util.List;

/**
 *
 * @author tuannnh
 */
public class SearchCouponAction extends ActionSupport {

    private List<Coupons> listCoupons;

    public List<Coupons> getListCoupons() {
        return listCoupons;
    }

    public void setListCoupons(List<Coupons> listCoupons) {
        this.listCoupons = listCoupons;
    }

    public SearchCouponAction() {
    }

    public String execute() throws Exception {
        CouponBLO blo = new CouponBLO();
        listCoupons = blo.showAllCoupons();
        return "success";
    }

}
