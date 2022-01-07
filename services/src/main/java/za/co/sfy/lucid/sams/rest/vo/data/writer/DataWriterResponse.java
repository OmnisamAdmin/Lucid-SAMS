package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;

import java.io.Serializable;

public class DataWriterResponse extends ApiResponse implements Serializable {

    private static final long serialVersionUID = -6453363986103920661L;

    private String schoolName;
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
