package za.co.sfy.lucid.sams.rest.vo.data.writer;

import za.co.sfy.lucid.sams.rest.vo.ApiResponse;
import za.co.sfy.sams.lucid.schema.DisciplinaryRecords;

public class DisciplinaryRecordsResponse extends ApiResponse {
    private static final long serialVersionUID = 8512952829934097102L;

    private DisciplinaryRecords disciplinaryRecords;

    public DisciplinaryRecords getDisciplinaryRecords() {
        return disciplinaryRecords;
    }

    public void setDisciplinaryRecords(DisciplinaryRecords disciplinaryRecords) {
        this.disciplinaryRecords = disciplinaryRecords;
    }
}
