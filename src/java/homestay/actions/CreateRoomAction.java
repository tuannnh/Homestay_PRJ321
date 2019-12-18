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
public class CreateRoomAction {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private String roomNo, roomType, roomNoError, createError;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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

    public CreateRoomAction() {
    }

    public String execute() throws Exception {
        RoomBLO blo = new RoomBLO();
        if (blo.insert(roomNo, roomType)) {
            return SUCCESS;
        }
        roomNoError = roomNo;
        createError = "Room No is existed!";
        return ERROR;
    }

}
