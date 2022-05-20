package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerInfoRequest;
import za.co.sfy.sams.lucid.schema.LearnerInfo;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author muzim
 */
@Component
public class LearnerInfoMapper {

    private final SharedMapper sharedMapper;

    public LearnerInfoMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public LearnerInfo learnerInfoRequestToLearnerInfo(LearnerInfoRequest learnerInfoRequest) throws LucidSamsExecutionException {

        LearnerInfo learnerInfo = new LearnerInfo();

        learnerInfo.setID(learnerInfoRequest.getId());
        learnerInfo.setLearnerID(learnerInfoRequest.getLearnerID());
        learnerInfo.setAccessionNo(learnerInfoRequest.getAccessionNo());
        learnerInfo.setTheDate(learnerInfoRequest.getTheDate());
        learnerInfo.setSName(learnerInfoRequest.getsName());
        learnerInfo.setFName(learnerInfoRequest.getfName());
        learnerInfo.setNickName(learnerInfoRequest.getNickName());
        learnerInfo.setBirthDate(learnerInfoRequest.getBirthDate());
        learnerInfo.setIDNo(learnerInfoRequest.getIdNo());
        learnerInfo.setGender(learnerInfoRequest.getGender());
        learnerInfo.setHomeLanguage(learnerInfoRequest.getHomeLanguage());
        learnerInfo.setInstructionLanguage(learnerInfoRequest.getInstructionLanguage());
        learnerInfo.setPreferredLanguage(learnerInfoRequest.getPreferredLanguage());
        learnerInfo.setAddress1(learnerInfoRequest.getAddress1());
        learnerInfo.setAddress2(learnerInfoRequest.getAddress2());
        learnerInfo.setAddress3(learnerInfoRequest.getAddress3());
        learnerInfo.setAddressCode(learnerInfoRequest.getAddressCode());
        learnerInfo.setGuardian(learnerInfoRequest.getGuardian());
        learnerInfo.setTel1Code(learnerInfoRequest.getTel1Code());
        learnerInfo.setTel1(learnerInfoRequest.getTel1());
        learnerInfo.setTel2Code(learnerInfoRequest.getTel2Code());
        learnerInfo.setTel2(learnerInfoRequest.getTel2());
        learnerInfo.setTel3Code(learnerInfoRequest.getTel3Code());
        learnerInfo.setTel3(learnerInfoRequest.getTel3());
        learnerInfo.setGrade(learnerInfoRequest.getGrade());
        learnerInfo.setClazz(learnerInfoRequest.getClazz());
        learnerInfo.setGradeYears(learnerInfoRequest.getGradeYears());
        learnerInfo.setPreviousSchool(learnerInfoRequest.getPreviousSchool());
        learnerInfo.setPreviousSchoolProvince(learnerInfoRequest.getPreviousSchoolProvince());
        learnerInfo.setSchoolAddress1(learnerInfoRequest.getSchoolAddress1());
        learnerInfo.setSchoolAddress2(learnerInfoRequest.getSchoolAddress2());
        learnerInfo.setSchoolAddress3(learnerInfoRequest.getSchoolAddress3());
        learnerInfo.setSchoolCode(learnerInfoRequest.getSchoolCode());
        learnerInfo.setReligion(learnerInfoRequest.getReligion());
        learnerInfo.setDisciplinary(learnerInfoRequest.getDisciplinary());
        learnerInfo.setMedicalConditions(learnerInfoRequest.getMedicalConditions());
        learnerInfo.setDrInfo(learnerInfoRequest.getDrInfo());
        learnerInfo.setMedicalAidName(learnerInfoRequest.getMedicalAidName());
        learnerInfo.setMedicalAidNo(learnerInfoRequest.getMedicalAidNo());
        learnerInfo.setMedicalAidMember(learnerInfoRequest.getMedicalAidMember());
        learnerInfo.setGuidance(learnerInfoRequest.getGuidance());
        learnerInfo.setInitials(learnerInfoRequest.getInitials());
        learnerInfo.setCitizenship(learnerInfoRequest.getCitizenship());
        learnerInfo.setProvincial(learnerInfoRequest.getProvincial());
        learnerInfo.setSchoolProvince(learnerInfoRequest.getSchoolProvince());
        learnerInfo.setAssignClass(learnerInfoRequest.isAssignClass());
        learnerInfo.setPhysProvince(learnerInfoRequest.getPhysProvince());
        learnerInfo.setRace(learnerInfoRequest.getRace());
        learnerInfo.setTitle(learnerInfoRequest.getTitle());
        learnerInfo.setPreviousPlacementofSchool(learnerInfoRequest.getPreviousPlacementofSchool());
        learnerInfo.setTransport(learnerInfoRequest.getTransport());
        learnerInfo.setLSENDisabilities(learnerInfoRequest.getLsenDisabilities());
        learnerInfo.setDateLeft(learnerInfoRequest.getDateLeft());
        learnerInfo.setReason(learnerInfoRequest.getReason());
        learnerInfo.setLSENStatus(learnerInfoRequest.getLsenStatus());
        learnerInfo.setStatus(learnerInfoRequest.getStatus());
        learnerInfo.setBoarder(learnerInfoRequest.getBoarder());
        learnerInfo.setCountryResidence(learnerInfoRequest.getCountryResidence());
        learnerInfo.setProvinceResidence(learnerInfoRequest.getProvinceResidence());
        learnerInfo.setFirstProvince(learnerInfoRequest.getFirstProvince());
        learnerInfo.setDeceasedParent(learnerInfoRequest.getDeceasedParent());
        learnerInfo.setSGRegister(learnerInfoRequest.getSgRegister());
        learnerInfo.setSGReceive(learnerInfoRequest.getSgReceive());
        learnerInfo.setDrName(learnerInfoRequest.getDrName());
        learnerInfo.setDrTel(learnerInfoRequest.getDrTel());
        learnerInfo.setDexterity(learnerInfoRequest.getDexterity());
        learnerInfo.setPSNP(learnerInfoRequest.getPsnp());
        learnerInfo.setNoFamily(learnerInfoRequest.getNoFamily());
        learnerInfo.setPositionFamily(learnerInfoRequest.getPositionFamily());
        learnerInfo.setReportLanguage(learnerInfoRequest.getReportLanguage());
        learnerInfo.setForeignID(learnerInfoRequest.getForeignID());
        learnerInfo.setLearnerComment(learnerInfoRequest.getLearnerComment());
        learnerInfo.setPhotoName(learnerInfoRequest.getPhotoName());
        learnerInfo.setGradeEntered(learnerInfoRequest.getGradeEntered());
        learnerInfo.setGradeLeft(learnerInfoRequest.getGradeLeft());
        learnerInfo.setBoarderNumber(learnerInfoRequest.getBoarderNumber());
        learnerInfo.setBoarderHostel(learnerInfoRequest.getBoarderHostel());
        learnerInfo.setThirdName(learnerInfoRequest.getThirdName());
        learnerInfo.setEmail(learnerInfoRequest.getEmail());
        learnerInfo.setSocialGrantNo(learnerInfoRequest.getSocialGrantNo());
        learnerInfo.setTSTransactionCategory(learnerInfoRequest.getTsTransactionCategory());
        learnerInfo.setTSStatusFlag(learnerInfoRequest.getTsStatusFlag());
        learnerInfo.setTSReportStatusFlag(learnerInfoRequest.getTsReportStatusFlag());
        learnerInfo.setTSReasonCode(learnerInfoRequest.getTsReasonCode());
        learnerInfo.setLuritsIndicator(learnerInfoRequest.getLuritsIndicator());
        learnerInfo.setLuritsFlag(learnerInfoRequest.getLuritsFlag());
        learnerInfo.setLuritsNumber(learnerInfoRequest.getLuritsNumber());
        learnerInfo.setTSSentfileName(learnerInfoRequest.getTsSentfileName());
        XMLGregorianCalendar tsDateLastUpdate = sharedMapper.dateToXMLGregorianCalendar(learnerInfoRequest.getTsDateLastUpdate());
        learnerInfo.setTSDateLastUpdate(tsDateLastUpdate);
        learnerInfo.setTSLastUpdatedBy(learnerInfoRequest.getTsLastUpdatedBy());
        learnerInfo.setLearnerName2(learnerInfoRequest.getLearnerName2());
        learnerInfo.setLearnerName3(learnerInfoRequest.getLearnerName3());
        learnerInfo.setNameDiacritics(learnerInfoRequest.getNameDiacritics());
        learnerInfo.setOtherHomeLanguage(learnerInfoRequest.getOtherHomeLanguage());
        learnerInfo.setOtherLanguage(learnerInfoRequest.getOtherLanguage());
        learnerInfo.setOtherPreferredLanguage(learnerInfoRequest.getOtherPreferredLanguage());
        learnerInfo.setOtherTeachingLanguage(learnerInfoRequest.getOtherTeachingLanguage());
        learnerInfo.setLuritsStatus(learnerInfoRequest.getLuritsStatus());
        learnerInfo.setSecondName(learnerInfoRequest.getSecondName());
        learnerInfo.setPastelCode(learnerInfoRequest.getPastelCode());
        learnerInfo.setBusRouteId(learnerInfoRequest.getBusRouteId());
        learnerInfo.setSubjHL(learnerInfoRequest.getSubjHL());
        learnerInfo.setSubjFAL(learnerInfoRequest.getSubjFAL());
        learnerInfo.setPrevSName(learnerInfoRequest.getPrevSName());
        learnerInfo.setPositionFamilyF(learnerInfoRequest.getPositionFamilyF());
        learnerInfo.setReasonForNoIDNo(learnerInfoRequest.getReasonForNoIDNo());
        learnerInfo.setGrantCReg(learnerInfoRequest.getGrantCReg());
        learnerInfo.setGrantCReceive(learnerInfoRequest.getGrantCReceive());
        learnerInfo.setGrantCNo(learnerInfoRequest.getGrantCNo());
        learnerInfo.setGrant4Reg(learnerInfoRequest.getGrant4Reg());
        learnerInfo.setGrant4Receive(learnerInfoRequest.getGrant4Receive());
        learnerInfo.setGrant4No(learnerInfoRequest.getGrant4No());
        learnerInfo.setGrant5Reg(learnerInfoRequest.getGrant5Reg());
        learnerInfo.setGrant5Receive(learnerInfoRequest.getGrant5Receive());
        learnerInfo.setGrant5No(learnerInfoRequest.getGrant5No());
        learnerInfo.setGrant9Reg(learnerInfoRequest.getGrant9Reg());
        learnerInfo.setGrant9Receive(learnerInfoRequest.getGrant9Receive());
        learnerInfo.setGrant9No(learnerInfoRequest.getGrant9No());
        learnerInfo.setClinicName(learnerInfoRequest.getClinicName());
        learnerInfo.setClinicAccRef(learnerInfoRequest.getClinicAccRef());
        learnerInfo.setClinicTelCode(learnerInfoRequest.getClinicTelCode());
        learnerInfo.setClinicTel(learnerInfoRequest.getClinicTel());
        learnerInfo.setSubjLOI(learnerInfoRequest.getSubjLOI());
        learnerInfo.setHseID(learnerInfoRequest.getHseID());
        learnerInfo.setPhaseYears(learnerInfoRequest.getPhaseYears());
        learnerInfo.setProgressedToGrade(learnerInfoRequest.isProgressedToGrade());
        learnerInfo.setStudyPermit(learnerInfoRequest.getStudyPermit());
        learnerInfo.setStudyPermitNo(learnerInfoRequest.getStudyPermitNo());
        learnerInfo.setStudyPermitDate(learnerInfoRequest.getStudyPermitDate());
        learnerInfo.setIDNoNotValidating(learnerInfoRequest.getIdNoNotValidating());
        learnerInfo.setOldMentor(learnerInfoRequest.getOldMentor());
        learnerInfo.setLSENAnaInc(learnerInfoRequest.isLsenAnaInc());
        learnerInfo.setLSENAnaHL(learnerInfoRequest.getLsenAnaHL());
        learnerInfo.setLSENAnaFAL(learnerInfoRequest.getLsenAnaFAL());
        learnerInfo.setPreviousPlacementofSchoolYear(learnerInfoRequest.getPreviousPlacementofSchoolYear());
        learnerInfo.setForeignIDType(learnerInfoRequest.getForeignIDType());
        learnerInfo.setAgeRuleOverwritten(learnerInfoRequest.isAgeRuleOverwritten());
        learnerInfo.setReasonForNoForeignID(learnerInfoRequest.getReasonForNoForeignID());
        learnerInfo.setFarmProj(learnerInfoRequest.getFarmProj());
        learnerInfo.setRoad2Health(learnerInfoRequest.isRoad2Health());
        learnerInfo.setImmunizationCard(learnerInfoRequest.isImmunizationCard());
        learnerInfo.setICEName(learnerInfoRequest.getIceName());
        learnerInfo.setICESurname(learnerInfoRequest.getIceSurname());
        learnerInfo.setICERelation(learnerInfoRequest.getIceRelation());

        return learnerInfo;
    }

}
