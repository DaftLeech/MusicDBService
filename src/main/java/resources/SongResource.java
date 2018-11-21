package resources;

import java.util.ArrayList;

import database.DB;
import types.Song;

import javax.swing.table.DefaultTableModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Song")
@Produces(MediaType.APPLICATION_JSON)
public class SongResource {

    private final String template;
    private final String defaultName;

    public SongResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Path("/byAlbumID")
    public ArrayList<Song> getByAlbum(@QueryParam("albumID")String albumID) {

        String sql = "SELECT songID,songName,songLength, albumID FROM song WHERE albumID = " + albumID;
        DefaultTableModel tbl = DB.getInstance().tableSelect(sql);

        ArrayList<Song> returnList = new ArrayList<>();
        for (int rowID = 0; rowID < tbl.getRowCount(); rowID++) {
            returnList.add(new Song(Long.valueOf((int)tbl.getValueAt(rowID, 0))
                    , (String) tbl.getValueAt(rowID, 1)
                    , Long.valueOf((int)tbl.getValueAt(rowID, 2))
                    , Long.valueOf((int)tbl.getValueAt(rowID, 3))
            ));
        }

        return returnList;
    }
}
