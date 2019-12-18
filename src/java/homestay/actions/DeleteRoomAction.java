/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.RoomBLO;

/**
 *
 * @author tuannnh
 */
public class DeleteRoomAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";
    
    private String roomNo, roomNoError, createError;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomNoError() {
        return roomNoError;
    }

    public void setRoomNoError(String roomNoError) {
        this.roomNoError = roomNoError;
    }

    public String getCreateError() {
        return createError;
    }

    public void setCreateError(String createError) {
        this.createError = createError;
    }

    public DeleteRoomAction() {
    }

    public String execute() throws Exception {
        RoomBLO blo = new RoomBLO();
        if (blo.delete(roomNo)) {
            return SUCCESS;
        }
        roomNoError = roomNo;
        createError = "This Room being booked!";
        return ERROR;
    }

}
