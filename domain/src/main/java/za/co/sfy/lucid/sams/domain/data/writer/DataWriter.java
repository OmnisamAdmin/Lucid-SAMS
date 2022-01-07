package za.co.sfy.lucid.sams.domain.data.writer;

import za.co.sfy.lucid.sams.domain.DomainObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbl_data_writer")
public class DataWriter extends DomainObject  implements Serializable {

    private static final long serialVersionUID = 3822968421441120446L;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "teacher_name")
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
