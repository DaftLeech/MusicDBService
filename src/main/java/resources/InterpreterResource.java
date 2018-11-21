package resources;


import database.DB;
import types.Interpreter;

import javax.swing.table.DefaultTableModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/Interpreter")
@Produces(MediaType.APPLICATION_JSON)
public class InterpreterResource {

    private final String template;
    private final String defaultName;

    public InterpreterResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Path("/byText")
    public ArrayList<Interpreter> getByText(@QueryParam("interName")String interName) {

        String sql = "SELECT interID,interName FROM interpreter WHERE interName LIKE '%" + interName+"%'";

        DefaultTableModel tbl = DB.getInstance().tableSelect(sql);

        ArrayList<Interpreter> returnList = new ArrayList<>();
        for (int rowID = 0; rowID < tbl.getRowCount(); rowID++) {
            returnList.add(new Interpreter(Long.valueOf((int)tbl.getValueAt(rowID, 0))
                    , (String) tbl.getValueAt(rowID, 1)
            ));
        }

        return returnList;
    }

    @GET
    @Path("/byAlbumID")
    public ArrayList<Interpreter> getByInterID(@QueryParam("albumID")String albumID) {

        String sql = "SELECT interpreter.interID,interName FROM interpreter" +
                " INNER JOIN album ON album.interID = interpreter.interID WHERE albumID =" + albumID+"";
        DefaultTableModel tbl = DB.getInstance().tableSelect(sql);

        ArrayList<Interpreter> returnList = new ArrayList<>();
        for (int rowID = 0; rowID < tbl.getRowCount(); rowID++) {
            returnList.add(new Interpreter(Long.valueOf((int)tbl.getValueAt(rowID, 0))
                    , (String) tbl.getValueAt(rowID, 1)
            ));
        }

        return returnList;
    }
}
