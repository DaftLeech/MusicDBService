package test;

import com.codahale.metrics.annotation.Timed;

import java.util.ArrayList;
import java.util.Optional;

import database.DB;
import types.Song;
import types.StringJSON;

import javax.swing.table.DefaultTableModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/Test")
@Produces(MediaType.APPLICATION_JSON)
public class TestRessource {

    private final String template;
    private final String defaultName;
    private final long counter;

    public TestRessource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = 0;
    }

    @GET
    @Path("/xD")
    public ArrayList<Song> sayHello(@QueryParam("name")String name) {
        final String value = String.format(template, name == "" ? defaultName : name);

        String sql = "SELECT * FROM song WHERE songName LIKE '%" + name + "%'";
        DefaultTableModel tbl = DB.getInstance().tableSelect(sql);

        ArrayList<Song> returnList = new ArrayList<>();
        for (int rowID = 0; rowID < tbl.getRowCount(); rowID++) {
            returnList.add(new Song(Long.valueOf((int)tbl.getValueAt(rowID, 0))
                    , (String) tbl.getValueAt(rowID, 1)
                    , Long.valueOf((int)tbl.getValueAt(rowID, 2))
            ));
        }

        return returnList;
    }
}
