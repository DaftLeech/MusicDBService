package test;


import database.DB;
import types.Album;
import types.Song;

import javax.swing.table.DefaultTableModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/Album")
@Produces(MediaType.APPLICATION_JSON)
public class AlbumRessource {

    private final String template;
    private final String defaultName;

    public AlbumRessource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Path("/byText")
    public ArrayList<Album> getByText(@QueryParam("albumName")String albumName) {

        String sql = "SELECT albumID,albumName,interID FROM album WHERE albumName LIKE '%" + albumName+"%'";
        DefaultTableModel tbl = DB.getInstance().tableSelect(sql);

        ArrayList<Album> returnList = new ArrayList<>();
        for (int rowID = 0; rowID < tbl.getRowCount(); rowID++) {
            returnList.add(new Album(Long.valueOf((int)tbl.getValueAt(rowID, 0))
                    , (String) tbl.getValueAt(rowID, 1)
                    , Long.valueOf((int)tbl.getValueAt(rowID, 2))
            ));
        }

        return returnList;
    }

    @GET
    @Path("/byInterID")
    public ArrayList<Album> getByInterID(@QueryParam("interID")String interID) {

        String sql = "SELECT albumID,albumName,interID FROM album WHERE interID =" + interID+"";
        DefaultTableModel tbl = DB.getInstance().tableSelect(sql);

        ArrayList<Album> returnList = new ArrayList<>();
        for (int rowID = 0; rowID < tbl.getRowCount(); rowID++) {
            returnList.add(new Album(Long.valueOf((int)tbl.getValueAt(rowID, 0))
                    , (String) tbl.getValueAt(rowID, 1)
                    , Long.valueOf((int)tbl.getValueAt(rowID, 2))
            ));
        }

        return returnList;
    }
}
