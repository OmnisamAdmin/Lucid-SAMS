package za.co.sfy.lucid.sams.rest.vo.data.writer;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class DewormingRequest implements Serializable {

    private static final long serialVersionUID = -4393034394013956372L;
    protected Integer id;
    @NotNull
    private Integer grade;
    @NotBlank
    private String datayear;
    @NotBlank
    private String gender;
    @NotNull
    private Integer totalDewormed;
    @NotNull
    private Integer totalWithSideEffects;
    @NotNull
    private Integer totalEducatorsOrientated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getDatayear() {
        return datayear;
    }

    public void setDatayear(String datayear) {
        this.datayear = datayear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getTotalDewormed() {
        return totalDewormed;
    }

    public void setTotalDewormed(Integer totalDewormed) {
        this.totalDewormed = totalDewormed;
    }

    public Integer getTotalWithSideEffects() {
        return totalWithSideEffects;
    }

    public void setTotalWithSideEffects(Integer totalWithSideEffects) {
        this.totalWithSideEffects = totalWithSideEffects;
    }

    public Integer getTotalEducatorsOrientated() {
        return totalEducatorsOrientated;
    }

    public void setTotalEducatorsOrientated(Integer totalEducatorsOrientated) {
        this.totalEducatorsOrientated = totalEducatorsOrientated;
    }
}
