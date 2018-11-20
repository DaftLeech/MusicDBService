package types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Album {

    private long albumID;
    private String albumName;
    private long interID;

    public Album(){
    }

    public Album(long albumID, String albumName, long interID) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.interID = interID;
    }

    @JsonProperty
    public long getAlbumID(){
        return albumID;
    }

    @JsonProperty
    public long getInterID(){
        return interID;
    }

    @JsonProperty
    public String getAlbumName(){
        return albumName;
    }
}
