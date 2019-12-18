/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.RoomBLO;
import homestay.entities.Rooms;

/**
 *
 * @author tuannnh
 */
public class EditRoomAction {
     private String roomNo, roomType;

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
     
    public EditRoomAction() {
    }
    
    public String execute() throws Exception {
        RoomBLO blo = new RoomBLO();
        Rooms room = blo.findByPrimaryKey(roomNo);
        roomType = room.getRoomType();
        return "success";
    }
    
}
