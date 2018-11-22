package resources;

import database.DB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/Wishlist")
public class WishlistResource {

    public WishlistResource(){

    }

    @GET
    @Path("/IDs")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSongIDs(@QueryParam("userID") long userID){

        String sql = "SELECT GROUP_CONCAT(songID) FROM wunschliste WHERE kundeID = "+String.valueOf(userID);

        Object oSongIDs = DB.getInstance().scalarSelect(sql);

        if(oSongIDs == null)
            return null;

        return (String) oSongIDs;

    }

    @PUT
    @Path("/HandleID")
    public void handleSongID(@QueryParam("userID")long userID, @QueryParam("songID") long songID){

        String sql = "SELECT kundeID FROM wunschliste WHERE kundeID = "+String.valueOf(userID)+" AND songID = "+String.valueOf(songID);
        Object oSongID = DB.getInstance().scalarSelect(sql);

        if(oSongID == null){
            sql = "INSERT INTO wunschliste SELECT "+String.valueOf(userID)+" ,"+String.valueOf(songID);
            DB.getInstance().tableInsert(sql);
        } else {
            sql = "DELETE FROM wunschliste WHERE kundeID = "+String.valueOf(userID)+" AND songID = "+String.valueOf(songID);
            DB.getInstance().tableInsert(sql);
        }


    }


}
