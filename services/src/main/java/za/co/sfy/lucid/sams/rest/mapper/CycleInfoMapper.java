package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoRequest;
import za.co.sfy.sams.lucid.schema.CycleInfo;

/**
 * @author muzim
 */
@Component
public class CycleInfoMapper {

    public CycleInfoMapper() {
    }

    public CycleInfo cycleInfoRequestToCycleInfo(CycleInfoRequest cycleInfoRequest) {
        CycleInfo cycleInfo = new CycleInfo();

        cycleInfo.setFETDays(cycleInfoRequest.getFetDays());
        cycleInfo.setFETlength(cycleInfoRequest.getFeTlength());
        cycleInfo.setFETPeriods(cycleInfoRequest.getFetPeriods());
        cycleInfo.setFETTotal(cycleInfoRequest.getFetTotal());
        cycleInfo.setGETDays(cycleInfoRequest.getGetDays());
        cycleInfo.setGETLength(cycleInfoRequest.getGetLength());
        cycleInfo.setGETPeriods(cycleInfoRequest.getGetPeriods());
        cycleInfo.setGETTotal(cycleInfoRequest.getGetTotal());
        cycleInfo.setHighestGrade(cycleInfoRequest.getHighestGrade());
        cycleInfo.setLowestGrade(cycleInfoRequest.getLowestGrade());
        cycleInfo.setLSEN(cycleInfoRequest.getLsen());
        cycleInfo.setLSENSchool(cycleInfoRequest.isLsenSchool());
        cycleInfo.setMultiGrade(cycleInfoRequest.getMultiGrade());
        cycleInfo.setRemedial(cycleInfoRequest.getRemedial());
        cycleInfo.setRooms(cycleInfoRequest.getRooms());
        cycleInfo.setSchoolname(cycleInfoRequest.getSchoolname());
        cycleInfo.setSchoolType(cycleInfoRequest.getSchoolType());
        cycleInfo.setSID(cycleInfoRequest.getSid());
        cycleInfo.setSIDHighestYear(cycleInfoRequest.getSidHighestYear());
        cycleInfo.setSIDLowestYear(cycleInfoRequest.getSidLowestYear());
        cycleInfo.setSNESpec(cycleInfoRequest.getSneSpec());
        cycleInfo.setSNESpecOther(cycleInfoRequest.getSneSpecOther());

        return cycleInfo;
    }

}
