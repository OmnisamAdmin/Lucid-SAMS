package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author muzim
 */
public class ClassesRequest implements Serializable {

    private static final long serialVersionUID = -6024460442510895949L;

    @NotNull
    private int classId;
    @NotNull
    private Integer grade;
    @NotNull
    private String className;
    @NotNull
    private String edCode;
    @NotNull
    private String room;
    @NotNull
    private Integer type;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
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