package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.rest.vo.data.writer.CycleInfoRequest;
import za.co.sfy.sams.lucid.schema.CycleInfo;

/**
 * @author muzim
 */
@Component
public class CycleInfoMapper {

    public CycleInfo cycleInfoRequestToCycleInfo(CycleInfoRequest cycleInfoRequest) {

        CycleInfo cycleInfo = new CycleInfo();

        Integer fetDays = cycleInfoRequest.getFetDays();
        if (null != fetDays) {
            cycleInfo.setFETDays(fetDays);
        } else {
            cycleInfo.setFETDays(0);
        }

        Integer feTlength = cycleInfoRequest.getFeTlength();
        if (null != fetDays) {
            cycleInfo.setFETlength(feTlength);
        } else {
            cycleInfo.setFETlength(0);
        }

        Integer fetPeriods = cycleInfoRequest.getFetPeriods();
        if (null != fetPeriods) {
            cycleInfo.setFETPeriods(fetPeriods);
        } else {
            cycleInfo.setFETPeriods(0);
        }

        Integer fetTotal = cycleInfoRequest.getFetTotal();
        if (null != fetTotal) {
            cycleInfo.setFETTotal(fetTotal);
        } else {
            cycleInfo.setFETTotal(0);
        }

        Integer getDays = cycleInfoRequest.getGetDays();
        if (null != getDays) {
            cycleInfo.setGETDays(getDays);
        }

        Integer getLength = cycleInfoRequest.getGetLength();
        if (null != getLength) {
            cycleInfo.setGETLength(getLength);
        } else {
            cycleInfo.setGETLength(0);
        }

        Integer getPeriods = cycleInfoRequest.getGetPeriods();
        if (null != getPeriods) {
            cycleInfo.setGETPeriods(getPeriods);
        } else {
            cycleInfo.setGETPeriods(0);
        }

        Integer getTotal = cycleInfoRequest.getGetTotal();
        if (null != getTotal) {
            cycleInfo.setGETTotal(getTotal);
        }

        Integer highestGrade = cycleInfoRequest.getHighestGrade();
        if (null != highestGrade) {
            cycleInfo.setHighestGrade(highestGrade);
        } else {
            cycleInfo.setHighestGrade(0);
        }

        Integer lowestGrade = cycleInfoRequest.getLowestGrade();
        if (null != lowestGrade) {
            cycleInfo.setLowestGrade(lowestGrade);
        } else {
            cycleInfo.setLowestGrade(0);
        }

        String lsen = cycleInfoRequest.getLsen();
        if (null != lsen) {
            cycleInfo.setLSEN(lsen);
        }

        Integer sneSpec = cycleInfoRequest.getSneSpec();
        if (null != sneSpec) {
            cycleInfo.setSNESpec(sneSpec);
        } else {
            cycleInfo.setSNESpec(0);
        }

        Integer sidLowestYear = cycleInfoRequest.getSidLowestYear();
        if (null != sidLowestYear) {
            cycleInfo.setSIDLowestYear(sidLowestYear);
        } else {
            cycleInfo.setSIDLowestYear(0);
        }

        Integer sidHighestYear = cycleInfoRequest.getSidHighestYear();
        if (null != sidHighestYear) {
            cycleInfo.setSIDHighestYear(sidHighestYear);
        } else {
            cycleInfo.setSIDHighestYear(0);
        }

        Integer rooms = cycleInfoRequest.getRooms();
        if (null != rooms) {
            cycleInfo.setRooms(rooms);
        } else {
            cycleInfo.setRooms(0);
        }

        Short schoolType = cycleInfoRequest.getSchoolType();
        if (null != schoolType) {
            cycleInfo.setSchoolType(schoolType);
        } else {
            cycleInfo.setSchoolType(Short.valueOf("0"));
        }

        String sid = cycleInfoRequest.getSid();
        if (null != sid) {
            cycleInfo.setSID(sid);
        }

        String schoolname = cycleInfoRequest.getSchoolname();
        if (null != schoolname) {
            cycleInfo.setSchoolname(schoolname);
        }

        String remedial = cycleInfoRequest.getRemedial();
        if (null != remedial) {
            cycleInfo.setRemedial(remedial);
        }

        String multiGrade = cycleInfoRequest.getMultiGrade();
        if (null != multiGrade) {
            cycleInfo.setMultiGrade(multiGrade);
        }

        String sneSpecOther = cycleInfoRequest.getSneSpecOther();
        if (null != sneSpecOther) {
            cycleInfo.setSNESpecOther(sneSpecOther);
        }

        cycleInfo.setLSENSchool(cycleInfoRequest.isLsenSchool());

        return cycleInfo;
    }

}