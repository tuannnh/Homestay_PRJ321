/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homestay.actions;

import homestay.blos.RoomBLO;
import homestay.entities.Rooms;
import java.util.List;

/**
 *
 * @author tuannnh
 */
public class SearchRoomAction {

  
   private List<Rooms> listRooms;

  

    public List<Rooms> getListRooms() {
        return listRooms;
    }

    public void setListRooms(List<Rooms> listRooms) {
        this.listRooms = listRooms;
    }

    
    public SearchRoomAction() {
    }

    public String execute() throws Exception {
      
        RoomBLO blo = new RoomBLO();
        listRooms = blo.showAllRooms();
        return "success";
    }

}
