package za.co.sfy.lucid.sams.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sfy.lucid.sams.domain.ServiceStatus;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.CycleInfoResource;
import za.co.sfy.lucid.sams.resource.GeneralInfoResource;
import za.co.sfy.lucid.sams.resource.SchoolGradesResource;
import za.co.sfy.lucid.sams.rest.mapper.CycleInfoMapper;
import za.co.sfy.sams.vo.CycleInfoRequest;
import za.co.sfy.sams.vo.CycleInfoResponse;
import za.co.sfy.sams.lucid.schema.CycleInfo;
import za.co.sfy.sams.lucid.schema.SchoolGrades;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muzim
 */
@Service
public class CycleInfoService {

    private final CycleInfoResource cycleInfoResource;
    private final CycleInfoMapper cycleInfoMapper;
    private final GeneralInfoResource generalInfoResource;
    private final SchoolGradesResource schoolGradesResource;

    @Autowired
    public CycleInfoService(final CycleInfoResource cycleInfoResource, final CycleInfoMapper cycleInfoMapper,
                            final GeneralInfoResource generalInfoResource, final SchoolGradesResource schoolGradesResource) {
        this.cycleInfoResource = cycleInfoResource;
        this.cycleInfoMapper = cycleInfoMapper;
        this.generalInfoResource = generalInfoResource;
        this.schoolGradesResource = schoolGradesResource;
    }

    public CycleInfoResponse saveCycleInfo(CycleInfoRequest cycleInfoRequest) throws LucidSamsExecutionException {

        CycleInfo cycleInfo = cycleInfoMapper.cycleInfoRequestToCycleInfo(cycleInfoRequest);

        String schoolName = cycleInfo.getSchoolname();

        ResultSet retrievedGeneralInfo = generalInfoResource.retrieveGeneralInfoBySchoolName(schoolName);
        try {
            if (!retrievedGeneralInfo.next()) {
                throw new LucidSamsExecutionException("The given 'SchoolName' - " + schoolName + " does not exist in the system");
            }
        } catch (SQLException exception) {
            throw new LucidSamsExecutionException(exception.getMessage(), exception);
        }

        cycleInfoResource.saveObjectWithoutGeneratedKey(cycleInfo, cycleInfoResource);

        ResultSet retrievedSchoolGrades = schoolGradesResource.retrieve((Object) null, schoolGradesResource);
        while (true) {
            try {
                if (!retrievedSchoolGrades.next()) break;
                SchoolGrades schoolGrades = new SchoolGrades();
                Integer id = retrievedSchoolGrades.getInt("ID");
                schoolGrades.setID(id);
                String schoolGrade = "No";
                if (id >= cycleInfo.getLowestGrade() && id <= cycleInfo.getHighestGrade()) {
                    schoolGrade = "Yes";
                }
                schoolGrades.setSchoolGrade(schoolGrade);
                schoolGradesResource.update(schoolGrades, schoolGradesResource);
            } catch (SQLException exception) {
                throw new LucidSamsExecutionException("'CycleInfo' data saved but failure occurred " +
                        "when updating school grades ", exception);
            }
        }

        CycleInfoResponse cycleInfoResponse = new CycleInfoResponse();
        cycleInfoResponse.setCycleInfo(cycleInfo);
        cycleInfoResponse.setResponseMessage("Successfully saved 'CycleInfo' data.");
        cycleInfoResponse.setResponseStatus(ServiceStatus.SUCCESS.value());

        return cycleInfoResponse;
    }
}