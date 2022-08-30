package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DetentionNotificationSettingsRequest implements Serializable {

    private static final long serialVersionUID = -7236989243736027580L;

    private Integer id;
    @NotBlank
    private String detentionType;
    @NotBlank
    private String startTime;
    @NotBlank
    private String endTime;
    @NotBlank
    private String detentionDay;
    @NotNull
    private Integer meritPoint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetentionType() {
        return detentionType;
    }

    public void setDetentionType(String detentionType) {
        this.detentionType = detentionType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDetentionDay() {
        return detentionDay;
    }

    public void setDetentionDay(String detentionDay) {
        this.detentionDay = detentionDay;
    }

    public Integer getMeritPoint() {
        return meritPoint;
    }

    public void setMeritPoint(Integer meritPoint) {
        this.meritPoint = meritPoint;
    }
}
