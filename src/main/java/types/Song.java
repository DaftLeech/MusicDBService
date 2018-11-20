package types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Song {

    private long songID;
    private String songName;
    private long songLength;
    private long albumID;

    public Song(){

    }

    public Song(long songID, String songName, long songLength, long albumID){
        this.songID = songID;
        this.songName = songName;
        this.songLength = songLength;
        this.albumID = albumID;
    }

    @JsonProperty
    public long getSongID(){
        return songID;
    }

    @JsonProperty
    public String getSongName(){
        return songName;
    }

    @JsonProperty
    public long getsongLength() {
        return songLength;
    }

    @JsonProperty
    public long getAlbumID(){
        return albumID;
    }
}
