package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author muzim
 */
public class LearnerInfoRequest implements Serializable {

    private static final long serialVersionUID = -1102915228465220301L;

    private int id;
    @NotBlank
    private String learnerID;
    @NotBlank
    private String accessionNo;
    @NotBlank
    private String theDate;
    @NotBlank
    private String sName;
    @NotBlank
    private String fName;
    @NotBlank
    private String nickName;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String idNo;
    @NotBlank
    private String gender;
    @NotBlank
    private Integer homeLanguage;
    @NotBlank
    private Integer instructionLanguage;
    @NotBlank
    private Integer preferredLanguage;
    private String address1;
    private String address2;
    private String address3;
    @NotBlank
    private String addressCode;
    @NotBlank
    private String guardian;
    private String tel1Code;
    @NotBlank
    private String tel1;
    private String tel2Code;
    private String tel2;
    @NotBlank
    private String tel3Code;
    @NotBlank
    private String tel3;
    @NotBlank
    private int grade;
    @NotBlank
    private Integer clazz;
    @NotBlank
    private Integer gradeYears;
    @NotBlank
    private String previousSchool;
    private String schoolAddress1;
    private String schoolAddress2;
    private String schoolAddress3;
    private String schoolCode;
    private String religion;
    private String disciplinary;
    private String medicalConditions;
    private String drInfo;
    private String medicalAidName;
    private String medicalAidNo;
    private String medicalAidMember;
    private String guidance;
    @NotBlank
    private String initials;
    @NotBlank
    private String citizenship;
    private String provincial;
    private String schoolProvince;
    @NotBlank
    private String previousSchoolProvince;
    @NotBlank
    private boolean assignClass;
    @NotBlank
    private String physProvince;
    @NotBlank
    private String race;
    @NotBlank
    private String title;
    @NotBlank
    private Integer previousPlacementofSchool;
    @NotBlank
    private Integer transport;
    @NotBlank
    private Integer lsenDisabilities;
    private String dateLeft;
    private String reason;
    @NotBlank
    private Integer lsenStatus;
    @NotBlank
    private String status;
    @NotBlank
    private Integer boarder;
    @NotBlank
    private String countryResidence;
    @NotBlank
    private String provinceResidence;
    @NotBlank
    private Integer firstProvince;
    @NotBlank
    private Integer deceasedParent;
    @NotBlank
    private Integer sgRegister;
    @NotBlank
    private Integer sgReceive;
    private String drName;
    private String drTel;
    @NotBlank
    private Integer dexterity;
    @NotBlank
    private Integer psnp;
    @NotBlank
    private Integer noFamily;
    private String positionFamily;
    @NotBlank
    private Integer reportLanguage;
    private String foreignID;
    private String learnerComment;
    private String photoName;
    @NotBlank
    private Integer gradeEntered;
    @NotBlank
    private Integer gradeLeft;
    private String boarderNumber;
    private String boarderHostel;
    private String thirdName;
    @NotBlank
    private String email;
    private String socialGrantNo;
    @NotBlank
    private Integer tsTransactionCategory;
    @NotBlank
    private Integer tsStatusFlag;
    @NotBlank
    private Integer tsReportStatusFlag;
    @NotBlank
    private Integer tsReasonCode;
    @NotBlank
    private Integer luritsIndicator;
    @NotBlank
    private Integer luritsFlag;
    @NotBlank
    private Double luritsNumber;
    private String tsSentfileName;
    @NotBlank
    private String tsDateLastUpdate;
    private String tsLastUpdatedBy;
    private String learnerName2;
    private String learnerName3;
    private String nameDiacritics;
    private String otherHomeLanguage;
    private String otherLanguage;
    private String otherPreferredLanguage;
    private String otherTeachingLanguage;
    private String luritsStatus;
    private String secondName;
    private String pastelCode;
    @NotBlank
    private Integer busRouteId;
    private String subjHL;
    private String subjFAL;
    private String prevSName;
    private String positionFamilyF;
    @NotBlank
    private Short reasonForNoIDNo;
    @NotBlank
    private Short grantCReg;
    @NotBlank
    private Short grantCReceive;
    private String grantCNo;
    @NotBlank
    private Short grant4Reg;
    @NotBlank
    private Short grant4Receive;
    private String grant4No;
    @NotBlank
    private Short grant5Reg;
    @NotBlank
    private Short grant5Receive;
    private String grant5No;
    @NotBlank
    private Short grant9Reg;
    @NotBlank
    private Short grant9Receive;
    private String grant9No;
    private String clinicName;
    private String clinicAccRef;
    private String clinicTelCode;
    private String clinicTel;
    private String subjLOI;
    @NotBlank
    private Integer hseID;
    @NotBlank
    private Short phaseYears;
    @NotBlank
    private boolean progressedToGrade;
    @NotBlank
    private Short studyPermit;
    private String studyPermitNo;
    private String studyPermitDate;
    private String idNoNotValidating;
    private String oldMentor;
    @NotBlank
    private boolean lsenAnaInc;
    private String lsenAnaHL;
    private String lsenAnaFAL;
    @NotBlank
    private Integer previousPlacementofSchoolYear;
    @NotBlank
    private Short foreignIDType;
    @NotBlank
    private boolean ageRuleOverwritten;
    @NotBlank
    private Short reasonForNoForeignID;
    private String farmProj;
    @NotBlank
    private boolean road2Health;
    @NotBlank
    private boolean immunizationCard;
    @NotBlank
    private String iceName;
    @NotBlank
    private String iceSurname;
    @NotBlank
    private String iceRelation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(String learnerID) {
        this.learnerID = learnerID;
    }

    public String getAccessionNo() {
        return accessionNo;
    }

    public void setAccessionNo(String accessionNo) {
        this.accessionNo = accessionNo;
    }

    public String getTheDate() {
        return theDate;
    }

    public void setTheDate(String theDate) {
        this.theDate = theDate;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHomeLanguage() {
        return homeLanguage;
    }

    public void setHomeLanguage(Integer homeLanguage) {
        this.homeLanguage = homeLanguage;
    }

    public Integer getInstructionLanguage() {
        return instructionLanguage;
    }

    public void setInstructionLanguage(Integer instructionLanguage) {
        this.instructionLanguage = instructionLanguage;
    }

    public Integer getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(Integer preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getTel1Code() {
        return tel1Code;
    }

    public void setTel1Code(String tel1Code) {
        this.tel1Code = tel1Code;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2Code() {
        return tel2Code;
    }

    public void setTel2Code(String tel2Code) {
        this.tel2Code = tel2Code;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getTel3Code() {
        return tel3Code;
    }

    public void setTel3Code(String tel3Code) {
        this.tel3Code = tel3Code;
    }

    public String getTel3() {
        return tel3;
    }

    public void setTel3(String tel3) {
        this.tel3 = tel3;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getGradeYears() {
        return gradeYears;
    }

    public void setGradeYears(Integer gradeYears) {
        this.gradeYears = gradeYears;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public String getSchoolAddress1() {
        return schoolAddress1;
    }

    public void setSchoolAddress1(String schoolAddress1) {
        this.schoolAddress1 = schoolAddress1;
    }

    public String getSchoolAddress2() {
        return schoolAddress2;
    }

    public void setSchoolAddress2(String schoolAddress2) {
        this.schoolAddress2 = schoolAddress2;
    }

    public String getSchoolAddress3() {
        return schoolAddress3;
    }

    public void setSchoolAddress3(String schoolAddress3) {
        this.schoolAddress3 = schoolAddress3;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDisciplinary() {
        return disciplinary;
    }

    public void setDisciplinary(String disciplinary) {
        this.disciplinary = disciplinary;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getDrInfo() {
        return drInfo;
    }

    public void setDrInfo(String drInfo) {
        this.drInfo = drInfo;
    }

    public String getMedicalAidName() {
        return medicalAidName;
    }

    public void setMedicalAidName(String medicalAidName) {
        this.medicalAidName = medicalAidName;
    }

    public String getMedicalAidNo() {
        return medicalAidNo;
    }

    public void setMedicalAidNo(String medicalAidNo) {
        this.medicalAidNo = medicalAidNo;
    }

    public String getMedicalAidMember() {
        return medicalAidMember;
    }

    public void setMedicalAidMember(String medicalAidMember) {
        this.medicalAidMember = medicalAidMember;
    }

    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    public String getSchoolProvince() {
        return schoolProvince;
    }

    public void setSchoolProvince(String schoolProvince) {
        this.schoolProvince = schoolProvince;
    }

    public String getPreviousSchoolProvince() {
        return previousSchoolProvince;
    }

    public void setPreviousSchoolProvince(String previousSchoolProvince) {
        this.previousSchoolProvince = previousSchoolProvince;
    }

    public boolean isAssignClass() {
        return assignClass;
    }

    public void setAssignClass(boolean assignClass) {
        this.assignClass = assignClass;
    }

    public String getPhysProvince() {
        return physProvince;
    }

    public void setPhysProvince(String physProvince) {
        this.physProvince = physProvince;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPreviousPlacementofSchool() {
        return previousPlacementofSchool;
    }

    public void setPreviousPlacementofSchool(Integer previousPlacementofSchool) {
        this.previousPlacementofSchool = previousPlacementofSchool;
    }

    public Integer getTransport() {
        return transport;
    }

    public void setTransport(Integer transport) {
        this.transport = transport;
    }

    public Integer getLsenDisabilities() {
        return lsenDisabilities;
    }

    public void setLsenDisabilities(Integer lsenDisabilities) {
        this.lsenDisabilities = lsenDisabilities;
    }

    public String getDateLeft() {
        return dateLeft;
    }

    public void setDateLeft(String dateLeft) {
        this.dateLeft = dateLeft;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getLsenStatus() {
        return lsenStatus;
    }

    public void setLsenStatus(Integer lsenStatus) {
        this.lsenStatus = lsenStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBoarder() {
        return boarder;
    }

    public void setBoarder(Integer boarder) {
        this.boarder = boarder;
    }

    public String getCountryResidence() {
        return countryResidence;
    }

    public void setCountryResidence(String countryResidence) {
        this.countryResidence = countryResidence;
    }

    public String getProvinceResidence() {
        return provinceResidence;
    }

    public void setProvinceResidence(String provinceResidence) {
        this.provinceResidence = provinceResidence;
    }

    public Integer getFirstProvince() {
        return firstProvince;
    }

    public void setFirstProvince(Integer firstProvince) {
        this.firstProvince = firstProvince;
    }

    public Integer getDeceasedParent() {
        return deceasedParent;
    }

    public void setDeceasedParent(Integer deceasedParent) {
        this.deceasedParent = deceasedParent;
    }

    public Integer getSgRegister() {
        return sgRegister;
    }

    public void setSgRegister(Integer sgRegister) {
        this.sgRegister = sgRegister;
    }

    public Integer getSgReceive() {
        return sgReceive;
    }

    public void setSgReceive(Integer sgReceive) {
        this.sgReceive = sgReceive;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getDrTel() {
        return drTel;
    }

    public void setDrTel(String drTel) {
        this.drTel = drTel;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getPsnp() {
        return psnp;
    }

    public void setPsnp(Integer psnp) {
        this.psnp = psnp;
    }

    public Integer getNoFamily() {
        return noFamily;
    }

    public void setNoFamily(Integer noFamily) {
        this.noFamily = noFamily;
    }

    public String getPositionFamily() {
        return positionFamily;
    }

    public void setPositionFamily(String positionFamily) {
        this.positionFamily = positionFamily;
    }

    public Integer getReportLanguage() {
        return reportLanguage;
    }

    public void setReportLanguage(Integer reportLanguage) {
        this.reportLanguage = reportLanguage;
    }

    public String getForeignID() {
        return foreignID;
    }

    public void setForeignID(String foreignID) {
        this.foreignID = foreignID;
    }

    public String getLearnerComment() {
        return learnerComment;
    }

    public void setLearnerComment(String learnerComment) {
        this.learnerComment = learnerComment;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Integer getGradeEntered() {
        return gradeEntered;
    }

    public void setGradeEntered(Integer gradeEntered) {
        this.gradeEntered = gradeEntered;
    }

    public Integer getGradeLeft() {
        return gradeLeft;
    }

    public void setGradeLeft(Integer gradeLeft) {
        this.gradeLeft = gradeLeft;
    }

    public String getBoarderNumber() {
        return boarderNumber;
    }

    public void setBoarderNumber(String boarderNumber) {
        this.boarderNumber = boarderNumber;
    }

    public String getBoarderHostel() {
        return boarderHostel;
    }

    public void setBoarderHostel(String boarderHostel) {
        this.boarderHostel = boarderHostel;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialGrantNo() {
        return socialGrantNo;
    }

    public void setSocialGrantNo(String socialGrantNo) {
        this.socialGrantNo = socialGrantNo;
    }

    public Integer getTsTransactionCategory() {
        return tsTransactionCategory;
    }

    public void setTsTransactionCategory(Integer tsTransactionCategory) {
        this.tsTransactionCategory = tsTransactionCategory;
    }

    public Integer getTsStatusFlag() {
        return tsStatusFlag;
    }

    public void setTsStatusFlag(Integer tsStatusFlag) {
        this.tsStatusFlag = tsStatusFlag;
    }

    public Integer getTsReportStatusFlag() {
        return tsReportStatusFlag;
    }

    public void setTsReportStatusFlag(Integer tsReportStatusFlag) {
        this.tsReportStatusFlag = tsReportStatusFlag;
    }

    public Integer getTsReasonCode() {
        return tsReasonCode;
    }

    public void setTsReasonCode(Integer tsReasonCode) {
        this.tsReasonCode = tsReasonCode;
    }

    public Integer getLuritsIndicator() {
        return luritsIndicator;
    }

    public void setLuritsIndicator(Integer luritsIndicator) {
        this.luritsIndicator = luritsIndicator;
    }

    public Integer getLuritsFlag() {
        return luritsFlag;
    }

    public void setLuritsFlag(Integer luritsFlag) {
        this.luritsFlag = luritsFlag;
    }

    public Double getLuritsNumber() {
        return luritsNumber;
    }

    public void setLuritsNumber(Double luritsNumber) {
        this.luritsNumber = luritsNumber;
    }

    public String getTsSentfileName() {
        return tsSentfileName;
    }

    public void setTsSentfileName(String tsSentfileName) {
        this.tsSentfileName = tsSentfileName;
    }

    public String getTsDateLastUpdate() {
        return tsDateLastUpdate;
    }

    public void setTsDateLastUpdate(String tsDateLastUpdate) {
        this.tsDateLastUpdate = tsDateLastUpdate;
    }

    public String getTsLastUpdatedBy() {
        return tsLastUpdatedBy;
    }

    public void setTsLastUpdatedBy(String tsLastUpdatedBy) {
        this.tsLastUpdatedBy = tsLastUpdatedBy;
    }

    public String getLearnerName2() {
        return learnerName2;
    }

    public void setLearnerName2(String learnerName2) {
        this.learnerName2 = learnerName2;
    }

    public String getLearnerName3() {
        return learnerName3;
    }

    public void setLearnerName3(String learnerName3) {
        this.learnerName3 = learnerName3;
    }

    public String getNameDiacritics() {
        return nameDiacritics;
    }

    public void setNameDiacritics(String nameDiacritics) {
        this.nameDiacritics = nameDiacritics;
    }

    public String getOtherHomeLanguage() {
        return otherHomeLanguage;
    }

    public void setOtherHomeLanguage(String otherHomeLanguage) {
        this.otherHomeLanguage = otherHomeLanguage;
    }

    public String getOtherLanguage() {
        return otherLanguage;
    }

    public void setOtherLanguage(String otherLanguage) {
        this.otherLanguage = otherLanguage;
    }

    public String getOtherPreferredLanguage() {
        return otherPreferredLanguage;
    }

    public void setOtherPreferredLanguage(String otherPreferredLanguage) {
        this.otherPreferredLanguage = otherPreferredLanguage;
    }

    public String getOtherTeachingLanguage() {
        return otherTeachingLanguage;
    }

    public void setOtherTeachingLanguage(String otherTeachingLanguage) {
        this.otherTeachingLanguage = otherTeachingLanguage;
    }

    public String getLuritsStatus() {
        return luritsStatus;
    }

    public void setLuritsStatus(String luritsStatus) {
        this.luritsStatus = luritsStatus;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPastelCode() {
        return pastelCode;
    }

    public void setPastelCode(String pastelCode) {
        this.pastelCode = pastelCode;
    }

    public Integer getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(Integer busRouteId) {
        this.busRouteId = busRouteId;
    }

    public String getSubjHL() {
        return subjHL;
    }

    public void setSubjHL(String subjHL) {
        this.subjHL = subjHL;
    }

    public String getSubjFAL() {
        return subjFAL;
    }

    public void setSubjFAL(String subjFAL) {
        this.subjFAL = subjFAL;
    }

    public String getPrevSName() {
        return prevSName;
    }

    public void setPrevSName(String prevSName) {
        this.prevSName = prevSName;
    }

    public String getPositionFamilyF() {
        return positionFamilyF;
    }

    public void setPositionFamilyF(String positionFamilyF) {
        this.positionFamilyF = positionFamilyF;
    }

    public Short getReasonForNoIDNo() {
        return reasonForNoIDNo;
    }

    public void setReasonForNoIDNo(Short reasonForNoIDNo) {
        this.reasonForNoIDNo = reasonForNoIDNo;
    }

    public Short getGrantCReg() {
        return grantCReg;
    }

    public void setGrantCReg(Short grantCReg) {
        this.grantCReg = grantCReg;
    }

    public Short getGrantCReceive() {
        return grantCReceive;
    }

    public void setGrantCReceive(Short grantCReceive) {
        this.grantCReceive = grantCReceive;
    }

    public String getGrantCNo() {
        return grantCNo;
    }

    public void setGrantCNo(String grantCNo) {
        this.grantCNo = grantCNo;
    }

    public Short getGrant4Reg() {
        return grant4Reg;
    }

    public void setGrant4Reg(Short grant4Reg) {
        this.grant4Reg = grant4Reg;
    }

    public Short getGrant4Receive() {
        return grant4Receive;
    }

    public void setGrant4Receive(Short grant4Receive) {
        this.grant4Receive = grant4Receive;
    }

    public String getGrant4No() {
        return grant4No;
    }

    public void setGrant4No(String grant4No) {
        this.grant4No = grant4No;
    }

    public Short getGrant5Reg() {
        return grant5Reg;
    }

    public void setGrant5Reg(Short grant5Reg) {
        this.grant5Reg = grant5Reg;
    }

    public Short getGrant5Receive() {
        return grant5Receive;
    }

    public void setGrant5Receive(Short grant5Receive) {
        this.grant5Receive = grant5Receive;
    }

    public String getGrant5No() {
        return grant5No;
    }

    public void setGrant5No(String grant5No) {
        this.grant5No = grant5No;
    }

    public Short getGrant9Reg() {
        return grant9Reg;
    }

    public void setGrant9Reg(Short grant9Reg) {
        this.grant9Reg = grant9Reg;
    }

    public Short getGrant9Receive() {
        return grant9Receive;
    }

    public void setGrant9Receive(Short grant9Receive) {
        this.grant9Receive = grant9Receive;
    }

    public String getGrant9No() {
        return grant9No;
    }

    public void setGrant9No(String grant9No) {
        this.grant9No = grant9No;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicAccRef() {
        return clinicAccRef;
    }

    public void setClinicAccRef(String clinicAccRef) {
        this.clinicAccRef = clinicAccRef;
    }

    public String getClinicTelCode() {
        return clinicTelCode;
    }

    public void setClinicTelCode(String clinicTelCode) {
        this.clinicTelCode = clinicTelCode;
    }

    public String getClinicTel() {
        return clinicTel;
    }

    public void setClinicTel(String clinicTel) {
        this.clinicTel = clinicTel;
    }

    public String getSubjLOI() {
        return subjLOI;
    }

    public void setSubjLOI(String subjLOI) {
        this.subjLOI = subjLOI;
    }

    public Integer getHseID() {
        return hseID;
    }

    public void setHseID(Integer hseID) {
        this.hseID = hseID;
    }

    public Short getPhaseYears() {
        return phaseYears;
    }

    public void setPhaseYears(Short phaseYears) {
        this.phaseYears = phaseYears;
    }

    public boolean isProgressedToGrade() {
        return progressedToGrade;
    }

    public void setProgressedToGrade(boolean progressedToGrade) {
        this.progressedToGrade = progressedToGrade;
    }

    public Short getStudyPermit() {
        return studyPermit;
    }

    public void setStudyPermit(Short studyPermit) {
        this.studyPermit = studyPermit;
    }

    public String getStudyPermitNo() {
        return studyPermitNo;
    }

    public void setStudyPermitNo(String studyPermitNo) {
        this.studyPermitNo = studyPermitNo;
    }

    public String getStudyPermitDate() {
        return studyPermitDate;
    }

    public void setStudyPermitDate(String studyPermitDate) {
        this.studyPermitDate = studyPermitDate;
    }

    public String getIdNoNotValidating() {
        return idNoNotValidating;
    }

    public void setIdNoNotValidating(String idNoNotValidating) {
        this.idNoNotValidating = idNoNotValidating;
    }

    public String getOldMentor() {
        return oldMentor;
    }

    public void setOldMentor(String oldMentor) {
        this.oldMentor = oldMentor;
    }

    public boolean isLsenAnaInc() {
        return lsenAnaInc;
    }

    public void setLsenAnaInc(boolean lsenAnaInc) {
        this.lsenAnaInc = lsenAnaInc;
    }

    public String getLsenAnaHL() {
        return lsenAnaHL;
    }

    public void setLsenAnaHL(String lsenAnaHL) {
        this.lsenAnaHL = lsenAnaHL;
    }

    public String getLsenAnaFAL() {
        return lsenAnaFAL;
    }

    public void setLsenAnaFAL(String lsenAnaFAL) {
        this.lsenAnaFAL = lsenAnaFAL;
    }

    public Integer getPreviousPlacementofSchoolYear() {
        return previousPlacementofSchoolYear;
    }

    public void setPreviousPlacementofSchoolYear(Integer previousPlacementofSchoolYear) {
        this.previousPlacementofSchoolYear = previousPlacementofSchoolYear;
    }

    public Short getForeignIDType() {
        return foreignIDType;
    }

    public void setForeignIDType(Short foreignIDType) {
        this.foreignIDType = foreignIDType;
    }

    public boolean isAgeRuleOverwritten() {
        return ageRuleOverwritten;
    }

    public void setAgeRuleOverwritten(boolean ageRuleOverwritten) {
        this.ageRuleOverwritten = ageRuleOverwritten;
    }

    public Short getReasonForNoForeignID() {
        return reasonForNoForeignID;
    }

    public void setReasonForNoForeignID(Short reasonForNoForeignID) {
        this.reasonForNoForeignID = reasonForNoForeignID;
    }

    public String getFarmProj() {
        return farmProj;
    }

    public void setFarmProj(String farmProj) {
        this.farmProj = farmProj;
    }

    public boolean isRoad2Health() {
        return road2Health;
    }

    public void setRoad2Health(boolean road2Health) {
        this.road2Health = road2Health;
    }

    public boolean isImmunizationCard() {
        return immunizationCard;
    }

    public void setImmunizationCard(boolean immunizationCard) {
        this.immunizationCard = immunizationCard;
    }

    public String getIceName() {
        return iceName;
    }

    public void setIceName(String iceName) {
        this.iceName = iceName;
    }

    public String getIceSurname() {
        return iceSurname;
    }

    public void setIceSurname(String iceSurname) {
        this.iceSurname = iceSurname;
    }

    public String getIceRelation() {
        return iceRelation;
    }

    public void setIceRelation(String iceRelation) {
        this.iceRelation = iceRelation;
    }
}
