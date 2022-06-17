package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DisciplinaryLearnerMisconductRequest implements Serializable {

    private static final long serialVersionUID = -8027956642692036518L;

    private Integer id;
    @NotNull
    private Integer level;
    @NotBlank
    private String code;
    @NotBlank
    private String description;
    @NotBlank
    private String editStatus;
    @NotBlank
    private String afrDesc;
    @NotBlank
    private String type;

    private Integer point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(String editStatus) {
        this.editStatus = editStatus;
    }

    public String getAfrDesc() {
        return afrDesc;
    }

    public void setAfrDesc(String afrDesc) {
        this.afrDesc = afrDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}