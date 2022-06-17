package za.co.sfy.lucid.sams.rest.vo;

import java.io.Serializable;

public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 2407892594804320603L;
    
	private String responseMessage;
    private String responseStatus;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}
