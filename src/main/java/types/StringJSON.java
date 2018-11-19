package types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StringJSON {

    private long id;

    private String content;

    public StringJSON(){

    }
    public  StringJSON(long id, String content){
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }


}
