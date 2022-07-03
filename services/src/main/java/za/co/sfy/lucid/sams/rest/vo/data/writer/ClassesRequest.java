package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author muzim
 */
public class ClassesRequest implements Serializable {

    private static final long serialVersionUID = -6024460442510895949L;

    private Integer classId;
    @NotNull
    private Integer grade;
    @NotBlank
    private String className;
    @NotBlank
    private String edCode;
    private String room;
    @NotNull
    private Integer type;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEdCode() {
        return edCode;
    }

    public void setEdCode(String edCode) {
        this.edCode = edCode;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
