package types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interpreter {

    private long interID;
    private String interName;

    public Interpreter(){
    }

    public Interpreter(long interID, String interName) {
        this.interID = interID;
        this.interName = interName;
    }

    @JsonProperty
    public long getInterID(){
        return interID;
    }

    @JsonProperty
    public String getInterName(){
        return interName;
    }


}
