package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.LearnerInfoRequest;
import za.co.sfy.sams.lucid.schema.LearnerInfo;


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

        Integer id = learnerInfoRequest.getId();
        if (null != id) {
        	learnerInfo.setID(id);
        } else { 
        	learnerInfoRequest.setId(0);
        }
        
        String learnerID = learnerInfoRequest.getLearnerID();
        if (null != learnerID) {
        	learnerInfo.setLearnerID(learnerInfoRequest.getLearnerID());
        }
        
        String accessionNo = learnerInfoRequest.getAccessionNo();
        if (null != accessionNo) {
        	learnerInfo.setAccessionNo(learnerInfoRequest.getAccessionNo());
        }
        
        learnerInfo.setTheDate(learnerInfoRequest.getTheDate());
        
        String sName = learnerInfoRequest.getsName();
        if (null != sName) {
        learnerInfo.setSName(learnerInfoRequest.getsName());
        }
        
        String fName = learnerInfoRequest.getfName();
        if (null != fName) {
        learnerInfo.setFName(learnerInfoRequest.getfName());
        }
        
        String nickName = learnerInfoRequest.getNickName();
        if (null != nickName) {
        learnerInfo.setNickName(learnerInfoRequest.getNickName());
        }
    
        learnerInfo.setBirthDate(learnerInfoRequest.getBirthDate());
        
        String idNo = learnerInfoRequest.getIdNo();
        if (null != idNo) {
        learnerInfo.setIDNo(learnerInfoRequest.getIdNo());
        }
        
        String gender = learnerInfoRequest.getGender();
        if (null != gender) {
        learnerInfo.setGender(learnerInfoRequest.getGender());
        }
        
        Integer homeLanguage = learnerInfoRequest.getHomeLanguage();
        if (null != homeLanguage) {
        learnerInfo.setHomeLanguage(homeLanguage);
        } else {
        	learnerInfoRequest.setHomeLanguage(0);
        }
        
        Integer instructionLanguage = learnerInfoRequest.getInstructionLanguage();
        if (null != instructionLanguage) {
        learnerInfo.setInstructionLanguage(instructionLanguage);
        } else {
        	learnerInfoRequest.setInstructionLanguage(0);
        }
        
        Integer preferredLanguage = learnerInfoRequest.getPreferredLanguage();
        if (null != preferredLanguage) {
        learnerInfo.setPreferredLanguage(preferredLanguage);
        } else {
        	learnerInfoRequest.setPreferredLanguage(0);
        }
        
        String address1 = learnerInfoRequest.getAddress1();
        if (null != address1) {
        learnerInfo.setAddress1(learnerInfoRequest.getAddress1());
        }
        
        String address2 = learnerInfoRequest.getAddress2();
        if (null != address2) {
        learnerInfo.setAddress2(learnerInfoRequest.getAddress2());
        }
        
        String address3 = learnerInfoRequest.getAddress3();
        if (null != address3) {
        learnerInfo.setAddress3(learnerInfoRequest.getAddress3());
        }
        
        String addressCode = learnerInfoRequest.getAddressCode();
        if (null != addressCode) {
        learnerInfo.setAddressCode(learnerInfoRequest.getAddressCode());
        }
        
        String guardian = learnerInfoRequest.getGuardian();
        if (null != guardian) {
        learnerInfo.setGuardian(learnerInfoRequest.getGuardian());
        }
        
        String tel1Code = learnerInfoRequest.getTel1Code();
        if (null != tel1Code) {
        learnerInfo.setTel1Code(learnerInfoRequest.getTel1Code());
        }
        
        String tel1 = learnerInfoRequest.getTel1();
        if (null != tel1) {
        learnerInfo.setTel1(learnerInfoRequest.getTel1());
        }
        
        String tel2Code = learnerInfoRequest.getTel2Code();
        if (null != tel2Code) {
        learnerInfo.setTel2Code(learnerInfoRequest.getTel2Code());
        }
        
        String tel2 = learnerInfoRequest.getTel2();
        if (null != tel2) {
        learnerInfo.setTel2(learnerInfoRequest.getTel2());
        }
        
        String tel3Code = learnerInfoRequest.getTel3Code();
        if (null != tel3Code) {
        learnerInfo.setTel3Code(learnerInfoRequest.getTel3Code());
        }
        
        String tel3 = learnerInfoRequest.getTel3();
        if (null != tel3) {
        learnerInfo.setTel3(learnerInfoRequest.getTel3());
        }

        Integer grade = learnerInfoRequest.getGrade();
        if (null != grade) {
        learnerInfo.setGrade(grade);
        } else {
        	learnerInfoRequest.setGrade(0);
        }
        
        Integer clazz = learnerInfoRequest.getClazz();
        if (null != clazz) {
        learnerInfo.setClazz(clazz);
        } else {
        	learnerInfoRequest.setClazz(0);
        }
        
        Integer gradeYears = learnerInfoRequest.getGradeYears();
        if (null != gradeYears) {
        learnerInfo.setGradeYears(gradeYears);
        } else {
        	learnerInfoRequest.setGradeYears(0);
        }
        
        String previousSchool = learnerInfoRequest.getPreviousSchool();
        if (null != previousSchool) {
        learnerInfo.setPreviousSchool(learnerInfoRequest.getPreviousSchool());
        }
        
        String previousSchoolProvince = learnerInfoRequest.getPreviousSchoolProvince();
        if (null != previousSchoolProvince) {
        learnerInfo.setPreviousSchoolProvince(learnerInfoRequest.getPreviousSchoolProvince());
        }
        
        String schoolAddress1 = learnerInfoRequest.getSchoolAddress1();
        if (null != schoolAddress1) {
        learnerInfo.setSchoolAddress1(learnerInfoRequest.getSchoolAddress1());
        }
        
        String schoolAddress2 = learnerInfoRequest.getSchoolAddress2();
        if (null != schoolAddress2) {
        learnerInfo.setSchoolAddress2(learnerInfoRequest.getSchoolAddress2());
        }
        
        String schoolAddress3 = learnerInfoRequest.getSchoolAddress3();
        if (null != schoolAddress3) {
        learnerInfo.setSchoolAddress3(learnerInfoRequest.getSchoolAddress3());
        }
        
        String schoolCode = learnerInfoRequest.getSchoolCode();
        if (null != schoolCode) {
        learnerInfo.setSchoolCode(learnerInfoRequest.getSchoolCode());
        }
        
        String religion = learnerInfoRequest.getReligion();
        if (null != religion) {
        learnerInfo.setReligion(learnerInfoRequest.getReligion());
        }
        
        String disciplinary = learnerInfoRequest.getDisciplinary();
        if (null != disciplinary) {
        learnerInfo.setDisciplinary(learnerInfoRequest.getDisciplinary());
        }
        
        String medicalConditions =learnerInfoRequest.getMedicalConditions();
        if (null != medicalConditions) {
        learnerInfo.setMedicalConditions(learnerInfoRequest.getMedicalConditions());
        }
        
        String drInfo = learnerInfoRequest.getDrInfo();
        if (null != drInfo) {
        learnerInfo.setDrInfo(learnerInfoRequest.getDrInfo());
        }
        
        String medicalAidName = learnerInfoRequest.getMedicalAidName();
        if (null != medicalAidName) {
        learnerInfo.setMedicalAidName(learnerInfoRequest.getMedicalAidName());
        }
        
        String medicalAidNo = learnerInfoRequest.getMedicalAidNo();
        if (null != medicalAidNo) {
        learnerInfo.setMedicalAidNo(learnerInfoRequest.getMedicalAidNo());
        }
        
        String medicalAidMember = learnerInfoRequest.getMedicalAidMember();
        if (null != medicalAidMember) {
        learnerInfo.setMedicalAidMember(learnerInfoRequest.getMedicalAidMember());
        }
        
        String guidance = learnerInfoRequest.getGuidance();
        if (null != guidance) {
        learnerInfo.setGuidance(learnerInfoRequest.getGuidance());
        }
        
        String initials = learnerInfoRequest.getInitials();
        if (null != initials) {
        learnerInfo.setInitials(learnerInfoRequest.getInitials());
        }
        
        String citizenship = learnerInfoRequest.getCitizenship();
        if (null != citizenship) {
        learnerInfo.setCitizenship(learnerInfoRequest.getCitizenship());
        }
        
        String provincial = learnerInfoRequest.getProvincial();
        if (null != provincial) {
        learnerInfo.setProvincial(learnerInfoRequest.getProvincial());
        }
        
        String schoolProvince = learnerInfoRequest.getSchoolProvince();
        if (null != schoolProvince) {
        learnerInfo.setSchoolProvince(learnerInfoRequest.getSchoolProvince());
        }
        
        learnerInfo.setAssignClass(learnerInfoRequest.isAssignClass());
        
        String physProvince = learnerInfoRequest.getPhysProvince();
        if (null != physProvince) {
        learnerInfo.setPhysProvince(learnerInfoRequest.getPhysProvince());
        }
        
        String race = learnerInfoRequest.getRace();
        if (null != race) {
        learnerInfo.setRace(learnerInfoRequest.getRace());
        }
        
        String title = learnerInfoRequest.getTitle();
        if (null != title) {
        learnerInfo.setTitle(learnerInfoRequest.getTitle());
        }
        
        Integer previousPlacementofSchool = learnerInfoRequest.getPreviousPlacementofSchool();
        if (null != previousPlacementofSchool) {
        learnerInfo.setPreviousPlacementofSchool(previousPlacementofSchool);
        } else {
        	learnerInfoRequest.setPreviousPlacementofSchool(0);
        }
        
        Integer transport = learnerInfoRequest.getTransport();
        if (null != transport) {
        learnerInfo.setTransport(transport);
        } else {
        	learnerInfoRequest.setTransport(0);
        }
        
        Integer lsenDisabilities = learnerInfoRequest.getLsenDisabilities();
        if (null != lsenDisabilities) {
        learnerInfo.setLSENDisabilities(lsenDisabilities);
        } else {
        	learnerInfoRequest.setLsenDisabilities(0);
        }
        
        String dateLeft = learnerInfoRequest.getDateLeft();
        if (null != dateLeft) {
        learnerInfo.setDateLeft(learnerInfoRequest.getDateLeft());
        }
        
        String reason = learnerInfoRequest.getReason();
        if (null != reason) {
        learnerInfo.setReason(learnerInfoRequest.getReason());
        }
        
        Integer lsenStatus = learnerInfoRequest.getLsenStatus();
        if (null != lsenStatus) {
        learnerInfo.setLSENStatus(lsenStatus);
        } else {
        	learnerInfoRequest.setLsenStatus(0);
        }
        
        String status = learnerInfoRequest.getStatus();
        if (null != status) {
        learnerInfo.setStatus(learnerInfoRequest.getStatus());
        }
        
        Integer boarder = learnerInfoRequest.getBoarder();
        if (null != boarder) {
        learnerInfo.setBoarder(boarder);
        } else {
        	learnerInfoRequest.setBoarder(0);
        }
        
        String countryResidence = learnerInfoRequest.getCountryResidence();
        if (null != countryResidence) {
        learnerInfo.setCountryResidence(learnerInfoRequest.getCountryResidence());
        }
        
        String provinceResidence = learnerInfoRequest.getProvinceResidence();
        if (null != provinceResidence) {
        learnerInfo.setProvinceResidence(learnerInfoRequest.getProvinceResidence());
        }
        
        Integer firstProvince = learnerInfoRequest.getFirstProvince();
        if (null != firstProvince) {
        learnerInfo.setFirstProvince(firstProvince);
        } else {
        	learnerInfoRequest.setFirstProvince(0);
        }
        
        Integer deceasedParent = learnerInfoRequest.getDeceasedParent();
        if (null != deceasedParent) {
        learnerInfo.setDeceasedParent(deceasedParent);
        } else {
        	learnerInfoRequest.setDeceasedParent(0);
        }
        
        Integer sgRegister = learnerInfoRequest.getSgRegister();
        if (null != sgRegister) {
        learnerInfo.setSGRegister(sgRegister);
        } else {
        	learnerInfoRequest.setSgRegister(0);
        }
        
        Integer sgReceive = learnerInfoRequest.getSgReceive();
        if (null != sgReceive) {
        learnerInfo.setSGReceive(sgReceive);
        } else {
        	learnerInfoRequest.setSgReceive(0);
        }
        
        String drName = learnerInfoRequest.getDrName();
        if (null != drName) {
        learnerInfo.setDrName(learnerInfoRequest.getDrName());
        }
        
        String drTel = learnerInfoRequest.getDrTel();
        if (null != drTel) {
        learnerInfo.setDrTel(learnerInfoRequest.getDrTel());
        }
        
        Integer dexterity = learnerInfoRequest.getDexterity();
        if (null != dexterity) {
        learnerInfo.setDexterity(dexterity);
        } else {
        	learnerInfoRequest.setDexterity(0);
        }
        
        Integer psnp = learnerInfoRequest.getPsnp();
        if (null != psnp) {
        learnerInfo.setPSNP(psnp);
        } else { 
        	learnerInfoRequest.setPsnp(0);
        }
        
        Integer noFamily = learnerInfoRequest.getNoFamily();
        if (null != noFamily) {
        learnerInfo.setNoFamily(noFamily);
        } else {
        	learnerInfoRequest.setNoFamily(0);
        }
        
        String positionFamily = learnerInfoRequest.getPositionFamily();
        if (null != positionFamily) {
        learnerInfo.setPositionFamily(learnerInfoRequest.getPositionFamily());
        }
        
        Integer reportLanguage = learnerInfoRequest.getReportLanguage();
        if (null != reportLanguage) {
        learnerInfo.setReportLanguage(reportLanguage);
        } else {
        	learnerInfoRequest.setReportLanguage(0);
        }
        
        String foreignID = learnerInfoRequest.getForeignID();
        if (null != foreignID) {
        learnerInfo.setForeignID(learnerInfoRequest.getForeignID());
        }
        
        String learnerComment = learnerInfoRequest.getLearnerComment();
        if (null != learnerComment) {
        learnerInfo.setLearnerComment(learnerInfoRequest.getLearnerComment());
        }
        
        String photoName = learnerInfoRequest.getPhotoName();
        if (null != photoName) {
        learnerInfo.setPhotoName(learnerInfoRequest.getPhotoName());
        }
        
        Integer gradeEntered = learnerInfoRequest.getGradeEntered();
        if (null != gradeEntered) {
        learnerInfo.setGradeEntered(gradeEntered);
        } else {
        	learnerInfoRequest.setGradeEntered(0);
        }
        
        Integer gradeLeft = learnerInfoRequest.getGradeLeft();
        if (null != gradeLeft) {
        learnerInfo.setGradeLeft(gradeLeft);
        } else {
        	learnerInfoRequest.setGradeLeft(0);
        }
        
        String boarderNumber = learnerInfoRequest.getBoarderNumber();
        if (null != boarderNumber) {
        learnerInfo.setBoarderNumber(learnerInfoRequest.getBoarderNumber());
        }
        
        String boarderHostel = learnerInfoRequest.getBoarderHostel();
        if (null != boarderHostel) {
        learnerInfo.setBoarderHostel(learnerInfoRequest.getBoarderHostel());
        }
        
        String thirdName = learnerInfoRequest.getThirdName();
        if (null != thirdName) {
        learnerInfo.setThirdName(learnerInfoRequest.getThirdName());
        }
        
        String email = learnerInfoRequest.getEmail();
        if (null != email) {
        learnerInfo.setEmail(learnerInfoRequest.getEmail());
        }
        
        String socialGrantNo = learnerInfoRequest.getSocialGrantNo();
        if (null != socialGrantNo) {
        learnerInfo.setSocialGrantNo(learnerInfoRequest.getSocialGrantNo());
        }
        
        Integer tsTransactionCategory = learnerInfoRequest.getTsTransactionCategory();
        if (null != tsTransactionCategory) {
        learnerInfo.setTSTransactionCategory(tsTransactionCategory);
        } else {
        	learnerInfoRequest.setTsTransactionCategory(0);
        }
        
        Integer tsStatusFlag = learnerInfoRequest.getTsStatusFlag();
        if (null != tsStatusFlag) {
        learnerInfo.setTSStatusFlag(tsStatusFlag);
        } else {
        	learnerInfoRequest.setTsStatusFlag(0);
        }
        
        Integer tsReportStatusFlag = learnerInfoRequest.getTsReportStatusFlag();
        if (null != tsReportStatusFlag) {
        learnerInfo.setTSReportStatusFlag(tsReportStatusFlag);
        } else {
        	learnerInfoRequest.setTsReportStatusFlag(0);
        }
        
        Integer tsReasonCode = learnerInfoRequest.getTsReasonCode();
        if (null != tsReasonCode) {
        learnerInfo.setTSReasonCode(tsReasonCode);
        } else {
        	learnerInfoRequest.setTsReasonCode(0);
        }
        
        Integer luritsIndicator = learnerInfoRequest.getLuritsIndicator();
        if (null != luritsIndicator) {
        learnerInfo.setLuritsIndicator(luritsIndicator);
        } else {
        	learnerInfoRequest.setLuritsIndicator(0);
        }
        
        Integer luritsFlag = learnerInfoRequest.getLuritsFlag();
        if (null != luritsFlag) {
        learnerInfo.setLuritsFlag(luritsFlag);
        } else {
        	learnerInfoRequest.setLuritsFlag(0);
        }
        
        Double luritsNumber = learnerInfoRequest.getLuritsNumber();
        if (null != luritsNumber) {
        learnerInfo.setLuritsNumber(luritsNumber);
        } else {
        	learnerInfoRequest.setLuritsNumber(0.0);
        }
        
        String tsSentfileName = learnerInfoRequest.getTsSentfileName();
        if (null != tsSentfileName) {
        learnerInfo.setTSSentfileName(learnerInfoRequest.getTsSentfileName());
        }

        String tsDateLastUpdate1 = learnerInfoRequest.getTsDateLastUpdate();
        if (null != tsDateLastUpdate1) {
            learnerInfo.setTSDateLastUpdate(sharedMapper.dateToXMLGregorianCalendar(tsDateLastUpdate1));
        }
//        else {
//            learnerInfo.setTSDateLastUpdate(sharedMapper.dateToXMLGregorianCalendar());
//        }


        String tsLastUpdatedBy = learnerInfoRequest.getTsLastUpdatedBy();
        if (null != tsLastUpdatedBy) {
        learnerInfo.setTSLastUpdatedBy(learnerInfoRequest.getTsLastUpdatedBy());
        }
        
        String learnerName2 = learnerInfoRequest.getLearnerName2();
        if (null != learnerName2) {
        learnerInfo.setLearnerName2(learnerInfoRequest.getLearnerName2());
        }
        
        String learnerName3 = learnerInfoRequest.getLearnerName3();
        if (null != learnerName3) {
        learnerInfo.setLearnerName3(learnerInfoRequest.getLearnerName3());
        }
        
        String nameDiacritics = learnerInfoRequest.getNameDiacritics();
        if (null != nameDiacritics) {
        learnerInfo.setNameDiacritics(learnerInfoRequest.getNameDiacritics());
        }
        
        String otherHomeLanguage = learnerInfoRequest.getOtherHomeLanguage();
        if (null != otherHomeLanguage) {
        learnerInfo.setOtherHomeLanguage(learnerInfoRequest.getOtherHomeLanguage());
        }
        
        String otherLanguage = learnerInfoRequest.getOtherLanguage();
        if (null != otherLanguage) {
        learnerInfo.setOtherLanguage(learnerInfoRequest.getOtherLanguage());
        }
        
        String otherPreferredLanguage = learnerInfoRequest.getOtherPreferredLanguage();
        if (null != otherPreferredLanguage) {
        learnerInfo.setOtherPreferredLanguage(learnerInfoRequest.getOtherPreferredLanguage());
        }
        
        String otherTeachingLanguage = learnerInfoRequest.getOtherTeachingLanguage();
        if (null != otherTeachingLanguage) {
        learnerInfo.setOtherTeachingLanguage(learnerInfoRequest.getOtherTeachingLanguage());
        }
        
        String luritsStatus = learnerInfoRequest.getLuritsStatus();
        if (null != luritsStatus) {
        learnerInfo.setLuritsStatus(learnerInfoRequest.getLuritsStatus());
        }
        
        String secondName = learnerInfoRequest.getSecondName();
        if (null != secondName) {
        learnerInfo.setSecondName(learnerInfoRequest.getSecondName());
        }
        
        String pastelCode = learnerInfoRequest.getPastelCode();
        if (null != pastelCode) {
        learnerInfo.setPastelCode(learnerInfoRequest.getPastelCode());
        }
        
        Integer busRouteId = learnerInfoRequest.getBusRouteId();
        if (null != busRouteId) {
        learnerInfo.setBusRouteId(busRouteId);
        } else { 
        	learnerInfoRequest.setBusRouteId(0);
        }
        
        String subjHL = learnerInfoRequest.getSubjHL();
        if (null != subjHL) {
        learnerInfo.setSubjHL(learnerInfoRequest.getSubjHL());
        }
        
        String subjFAL = learnerInfoRequest.getSubjFAL();
        if (null != subjFAL) {
        learnerInfo.setSubjFAL(learnerInfoRequest.getSubjFAL());
        }
        
        String prevSName = learnerInfoRequest.getPrevSName();
        if (null != prevSName) {
        learnerInfo.setPrevSName(learnerInfoRequest.getPrevSName());
        }
        
        String positionFamilyF = learnerInfoRequest.getPositionFamilyF();
        if (null != positionFamilyF) {
        learnerInfo.setPositionFamilyF(learnerInfoRequest.getPositionFamilyF());
        }
        
        Short reasonForNoIDNo = learnerInfoRequest.getReasonForNoIDNo();
        if (null != reasonForNoIDNo) {
        learnerInfo.setReasonForNoIDNo(reasonForNoIDNo);
        } else {
        	 learnerInfoRequest.setReasonForNoIDNo(Short.valueOf("0"));
        }
        
        Short grantCReg = learnerInfoRequest.getGrantCReg();
        if (null != grantCReg) {
        learnerInfo.setGrantCReg(grantCReg);
        } else {
        	learnerInfoRequest.setGrantCReg(Short.valueOf("0"));
        }
        
        Short grantCReceive = learnerInfoRequest.getGrantCReceive();
        if (null != grantCReceive) {
        learnerInfo.setGrantCReceive(grantCReceive);
        } else {
        	learnerInfoRequest.setGrantCReceive(Short.valueOf("0"));
        }
        
        String grantCNo = learnerInfoRequest.getGrantCNo();
        if (null != grantCNo) {
        learnerInfo.setGrantCNo(learnerInfoRequest.getGrantCNo());
        }
        
        Short grant4Reg = learnerInfoRequest.getGrant4Reg();
        if (null != grant4Reg) {
        learnerInfo.setGrant4Reg(grant4Reg);
        } else {
        	learnerInfoRequest.setGrant4Reg(Short.valueOf("0"));
        }
        
        Short grant4Receive = learnerInfoRequest.getGrant4Receive();
        if (null != grant4Receive) {
        learnerInfo.setGrant4Receive(grant4Receive);
        } else {
        	learnerInfoRequest.setGrant4Receive(Short.valueOf("0"));
        }
        
        String grant4No = learnerInfoRequest.getGrant4No();
        if (null != grant4No) {
        learnerInfo.setGrant4No(learnerInfoRequest.getGrant4No());
        }
        
        Short grant5Reg = learnerInfoRequest.getGrant5Reg();
        if (null != grant5Reg) {
        learnerInfo.setGrant5Reg(grant5Reg);
        } else {
        	learnerInfoRequest.setGrant5Reg(Short.valueOf("0"));
        }
        
        Short grant5Receive = learnerInfoRequest.getGrant5Receive();
        if (null != grant5Receive) {
        learnerInfo.setGrant5Receive(grant5Receive);
        } else {
        	learnerInfoRequest.setGrant5Receive(Short.valueOf("0"));
        }
        
        String grant5No = learnerInfoRequest.getGrant5No();
        if (null != grant5No) {
        learnerInfo.setGrant5No(learnerInfoRequest.getGrant5No());
        }
        
        Short grant9Reg = learnerInfoRequest.getGrant9Reg();
        if (null != grant9Reg) {
        learnerInfo.setGrant9Reg(grant9Reg);
        } else {
        	learnerInfoRequest.setGrant9Reg(Short.valueOf("0"));
        }
        
        Short grant9Receive = learnerInfoRequest.getGrant9Receive();
        if (null != grant9Receive) {
        learnerInfo.setGrant9Receive(grant9Receive);
        } else {
        	learnerInfoRequest.setGrant9Receive(Short.valueOf("0"));
        }
        
        String grant9No = learnerInfoRequest.getGrant9No();
        if (null != grant9No) {
        learnerInfo.setGrant9No(learnerInfoRequest.getGrant9No());
        }
        
        String clinicName = learnerInfoRequest.getClinicName();
        if (null != clinicName) {
        learnerInfo.setClinicName(learnerInfoRequest.getClinicName());
        }
        
        String clinicAccRef = learnerInfoRequest.getClinicAccRef();
        if (null != clinicAccRef) {
        learnerInfo.setClinicAccRef(learnerInfoRequest.getClinicAccRef());
        }
        
        String clinicTelCode = learnerInfoRequest.getClinicTelCode();
        if (null != clinicTelCode) {
        learnerInfo.setClinicTelCode(learnerInfoRequest.getClinicTelCode());
        }
        
        String clinicTel = learnerInfoRequest.getClinicTel();
        if (null != clinicTel) {
        learnerInfo.setClinicTel(learnerInfoRequest.getClinicTel());
        }
        
        String subjLOI = learnerInfoRequest.getSubjLOI();
        if (null != subjLOI) {
        learnerInfo.setSubjLOI(learnerInfoRequest.getSubjLOI());
        }
        
        Integer hseID = learnerInfoRequest.getHseID();
        if (null != hseID) {
        learnerInfo.setHseID(hseID);
        } else {
        	learnerInfoRequest.setHseID(0);
        }
        
        Short phaseYears = learnerInfoRequest.getPhaseYears();
        if (null != phaseYears) {
        learnerInfo.setPhaseYears(phaseYears);
        } else {
        	learnerInfoRequest.setPhaseYears(Short.valueOf("0"));
        }
        
        learnerInfo.setProgressedToGrade(learnerInfoRequest.isProgressedToGrade());
        
        Short studyPermit = learnerInfoRequest.getStudyPermit();
        if (null != studyPermit) {
        learnerInfo.setStudyPermit(studyPermit);
        } else {
        	learnerInfoRequest.setStudyPermit(Short.valueOf("0"));
        }
        
        String studyPermitNo = learnerInfoRequest.getStudyPermitNo();
        if (null != studyPermitNo) {
        learnerInfo.setStudyPermitNo(learnerInfoRequest.getStudyPermitNo());
        }
        
        String studyPermitDate = learnerInfoRequest.getStudyPermitDate();
        if (null != studyPermitDate) {
        learnerInfo.setStudyPermitDate(learnerInfoRequest.getStudyPermitDate());
        }
        
        String idNoNotValidating = learnerInfoRequest.getIdNoNotValidating();
        if (null != idNoNotValidating) {
        learnerInfo.setIDNoNotValidating(learnerInfoRequest.getIdNoNotValidating());
        }
        
        String oldMentor = learnerInfoRequest.getOldMentor();
        if (null != oldMentor) {
        learnerInfo.setOldMentor(learnerInfoRequest.getOldMentor());
        }
        
        learnerInfo.setLSENAnaInc(learnerInfoRequest.isLsenAnaInc());
        
        String lsenAnaHL = learnerInfoRequest.getLsenAnaHL();
        if (null != lsenAnaHL) {
        learnerInfo.setLSENAnaHL(learnerInfoRequest.getLsenAnaHL());
        }
        
        String lsenAnaFAL = learnerInfoRequest.getLsenAnaFAL();
        if (null != lsenAnaFAL) {
        learnerInfo.setLSENAnaFAL(learnerInfoRequest.getLsenAnaFAL());
        }
        
        Integer previousPlacementofSchoolYear = learnerInfoRequest.getPreviousPlacementofSchoolYear();
        if (null != previousPlacementofSchoolYear) {
        learnerInfo.setPreviousPlacementofSchoolYear(previousPlacementofSchoolYear);
        } else learnerInfoRequest.setPreviousPlacementofSchoolYear(0);
        
        Short foreignIDType = learnerInfoRequest.getForeignIDType();
        if (null != foreignIDType) {
        learnerInfo.setForeignIDType(foreignIDType);
        } else {
        	learnerInfoRequest.setForeignIDType(Short.valueOf("0"));
        }
        
        learnerInfo.setAgeRuleOverwritten(learnerInfoRequest.isAgeRuleOverwritten());
        
        Short reasonForNoForeignID = learnerInfoRequest.getReasonForNoForeignID();
        if (null != reasonForNoForeignID) {
        learnerInfo.setReasonForNoForeignID(reasonForNoForeignID);
        } else {
        	learnerInfoRequest.setReasonForNoForeignID(Short.valueOf("0"));
        }
        
        String farmProj = learnerInfoRequest.getFarmProj();
        if (null != farmProj) {
        learnerInfo.setFarmProj(learnerInfoRequest.getFarmProj());
        }
        
        learnerInfo.setRoad2Health(learnerInfoRequest.isRoad2Health());
        
        learnerInfo.setImmunizationCard(learnerInfoRequest.isImmunizationCard());
        
        String iceName = learnerInfoRequest.getIceName();
        if (null != iceName) {
        learnerInfo.setICEName(learnerInfoRequest.getIceName());
        }
        
        String iceSurname = learnerInfoRequest.getIceSurname();
        if (null != iceSurname) {
        learnerInfo.setICESurname(learnerInfoRequest.getIceSurname());
        }
        
        String iceRelation = learnerInfoRequest.getIceRelation();
        if (null != iceRelation) {
        learnerInfo.setICERelation(learnerInfoRequest.getIceRelation());
        }

        return learnerInfo;
    }

}
