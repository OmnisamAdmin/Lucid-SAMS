package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class DataWriterRequest implements Serializable {

    private static final long serialVersionUID = -5550554900493974563L;

    @NotBlank(message = "School name is required")
    private String schoolName;
    @NotBlank(message = "Teacher Name is required")
    private String teacherName;


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

}
