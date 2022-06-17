package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;

public class EducatorsRequest implements Serializable {

    private static final long serialVersionUID = -7729475728572376327L;

    private Integer edID;
    @NotBlank
    private String fName;
    @NotBlank
    private String sName;
    @NotBlank
    private String initials;
    @NotBlank
    private String key;
    @NotBlank
    private String address1;
    private String address2;
    private String address3;
    private String code;
    private String tel1Code;
    private String tel1;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String idNumber;
    @NotBlank
    private String depCode;
    private String subsidies;
    private String medName;
    private String medNo;
    private String spouse;
    private String eNumber;
    private String licenses;
    private String taxNo;
    private String academic;
    private String institution;
    private String skills;
    @NotBlank
    private String dateJoined;
    private String managementPosition;
    @NotBlank
    private String postLevel;
    private String tel2Code;
    private String tel2;
    private String professional;
    @NotBlank
    private String registerClass;
    @NotBlank
    private String persalNumber;
    @NotBlank
    private String homelanguage;
    private String x0032Ndlanguage;
    @NotBlank
    private String race;
    @NotBlank
    private String title;
    @NotBlank
    private String gender;
    @NotBlank
    private String educatorType;
    @NotBlank
    private String maritalStatus;
    private String disabilityStatus;
    @NotBlank
    private String actual;
    @NotBlank
    private String acting;
    @NotBlank
    private String natureofApointment;
    @NotBlank
    private String remuneration;
    @NotBlank
    private String qualification;
    @NotBlank
    private String qualificationType;
    @NotBlank
    private String preGradeR;
    @NotBlank
    private String secondary;
    @NotBlank
    private String gradeR;
    @NotBlank
    private String primary;
    @NotBlank
    private String lsen;
    private String academicDegree;
    private String professionalDegree;
    private String technicalCerDip;
    private String professionalDiploma;
    @NotNull
    private Integer yearsExperience;
    @NotBlank
    private String time;
    @NotBlank
    private String instructionLanguage;
    @NotBlank
    private String status;
    private String sace;
    @NotNull
    private Integer wcType;
    private String emailAddress;
    private String ictSkill;
    private String ictUsage;
    @NotBlank
    private String country;
    private String photoname;
    private String intermediate;
    private Integer luritsNumber;
    @NotNull
    private Integer tsTransactionCategory;
    @NotNull
    private Integer tsStatusFlag;
    private Integer tsReportStatusFlag;
    private Integer tsReasonCode;
    private Integer luritsIndicator;
    @NotNull
    private Integer luritsFlag;
    private String tsSentFileName;
    private String tsDateLastUpdate;
    private String tsLastUpdatedBy;
    private String luritsStatus;
    private String kinSName;
    private String kinFName;
    @NotNull
    private Short saCitizen;
    private Short workPermit;
    private String workPermitNo;
    private String workPermitDate;
    private String prevSName;
    @NotBlank
    private String compUsage;
    @NotNull
    private Short reasonForNoSACE;
    @NotBlank
    private String unionName;
    private String unionNo;
    private String unionName2;
    private String unionNo2;
    private String unionNameX;
    private String unionNoX;
    private String religion;
    private String foreignID;
    @NotNull
    private Integer bursar;

    public Integer getEdID() {
        return edID;
    }

    public void setEdID(Integer edID) {
        this.edID = edID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getSubsidies() {
        return subsidies;
    }

    public void setSubsidies(String subsidies) {
        this.subsidies = subsidies;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedNo() {
        return medNo;
    }

    public void setMedNo(String medNo) {
        this.medNo = medNo;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public String getLicenses() {
        return licenses;
    }

    public void setLicenses(String licenses) {
        this.licenses = licenses;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getManagementPosition() {
        return managementPosition;
    }

    public void setManagementPosition(String managementPosition) {
        this.managementPosition = managementPosition;
    }

    public String getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(String postLevel) {
        this.postLevel = postLevel;
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

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getRegisterClass() {
        return registerClass;
    }

    public void setRegisterClass(String registerClass) {
        this.registerClass = registerClass;
    }

    public String getPersalNumber() {
        return persalNumber;
    }

    public void setPersalNumber(String persalNumber) {
        this.persalNumber = persalNumber;
    }

    public String getHomelanguage() {
        return homelanguage;
    }

    public void setHomelanguage(String homelanguage) {
        this.homelanguage = homelanguage;
    }

    public String getX0032Ndlanguage() {
        return x0032Ndlanguage;
    }

    public void setX0032Ndlanguage(String x0032Ndlanguage) {
        this.x0032Ndlanguage = x0032Ndlanguage;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducatorType() {
        return educatorType;
    }

    public void setEducatorType(String educatorType) {
        this.educatorType = educatorType;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getDisabilityStatus() {
        return disabilityStatus;
    }

    public void setDisabilityStatus(String disabilityStatus) {
        this.disabilityStatus = disabilityStatus;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getActing() {
        return acting;
    }

    public void setActing(String acting) {
        this.acting = acting;
    }

    public String getNatureofApointment() {
        return natureofApointment;
    }

    public void setNatureofApointment(String natureofApointment) {
        this.natureofApointment = natureofApointment;
    }

    public String getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(String remuneration) {
        this.remuneration = remuneration;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(String qualificationType) {
        this.qualificationType = qualificationType;
    }

    public String getPreGradeR() {
        return preGradeR;
    }

    public void setPreGradeR(String preGradeR) {
        this.preGradeR = preGradeR;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getGradeR() {
        return gradeR;
    }

    public void setGradeR(String gradeR) {
        this.gradeR = gradeR;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getLsen() {
        return lsen;
    }

    public void setLsen(String lsen) {
        this.lsen = lsen;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public String getProfessionalDegree() {
        return professionalDegree;
    }

    public void setProfessionalDegree(String professionalDegree) {
        this.professionalDegree = professionalDegree;
    }

    public String getTechnicalCerDip() {
        return technicalCerDip;
    }

    public void setTechnicalCerDip(String technicalCerDip) {
        this.technicalCerDip = technicalCerDip;
    }

    public String getProfessionalDiploma() {
        return professionalDiploma;
    }

    public void setProfessionalDiploma(String professionalDiploma) {
        this.professionalDiploma = professionalDiploma;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Integer yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInstructionLanguage() {
        return instructionLanguage;
    }

    public void setInstructionLanguage(String instructionLanguage) {
        this.instructionLanguage = instructionLanguage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSace() {
        return sace;
    }

    public void setSace(String sace) {
        this.sace = sace;
    }

    public Integer getWcType() {
        return wcType;
    }

    public void setWcType(Integer wcType) {
        this.wcType = wcType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getIctSkill() {
        return ictSkill;
    }

    public void setIctSkill(String ictSkill) {
        this.ictSkill = ictSkill;
    }

    public String getIctUsage() {
        return ictUsage;
    }

    public void setIctUsage(String ictUsage) {
        this.ictUsage = ictUsage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    public String getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(String intermediate) {
        this.intermediate = intermediate;
    }

    public Integer getLuritsNumber() {
        return luritsNumber;
    }

    public void setLuritsNumber(Integer luritsNumber) {
        this.luritsNumber = luritsNumber;
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

    public String getTsSentFileName() {
        return tsSentFileName;
    }

    public void setTsSentFileName(String tsSentFileName) {
        this.tsSentFileName = tsSentFileName;
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

    public String getLuritsStatus() {
        return luritsStatus;
    }

    public void setLuritsStatus(String luritsStatus) {
        this.luritsStatus = luritsStatus;
    }

    public String getKinSName() {
        return kinSName;
    }

    public void setKinSName(String kinSName) {
        this.kinSName = kinSName;
    }

    public String getKinFName() {
        return kinFName;
    }

    public void setKinFName(String kinFName) {
        this.kinFName = kinFName;
    }

    public Short getSaCitizen() {
        return saCitizen;
    }

    public void setSaCitizen(Short saCitizen) {
        this.saCitizen = saCitizen;
    }

    public Short getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(Short workPermit) {
        this.workPermit = workPermit;
    }

    public String getWorkPermitNo() {
        return workPermitNo;
    }

    public void setWorkPermitNo(String workPermitNo) {
        this.workPermitNo = workPermitNo;
    }

    public String getWorkPermitDate() {
        return workPermitDate;
    }

    public void setWorkPermitDate(String workPermitDate) {
        this.workPermitDate = workPermitDate;
    }

    public String getPrevSName() {
        return prevSName;
    }

    public void setPrevSName(String prevSName) {
        this.prevSName = prevSName;
    }

    public String getCompUsage() {
        return compUsage;
    }

    public void setCompUsage(String compUsage) {
        this.compUsage = compUsage;
    }

    public Short getReasonForNoSACE() {
        return reasonForNoSACE;
    }

    public void setReasonForNoSACE(Short reasonForNoSACE) {
        this.reasonForNoSACE = reasonForNoSACE;
    }

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getUnionNo() {
        return unionNo;
    }

    public void setUnionNo(String unionNo) {
        this.unionNo = unionNo;
    }

    public String getUnionName2() {
        return unionName2;
    }

    public void setUnionName2(String unionName2) {
        this.unionName2 = unionName2;
    }

    public String getUnionNo2() {
        return unionNo2;
    }

    public void setUnionNo2(String unionNo2) {
        this.unionNo2 = unionNo2;
    }

    public String getUnionNameX() {
        return unionNameX;
    }

    public void setUnionNameX(String unionNameX) {
        this.unionNameX = unionNameX;
    }

    public String getUnionNoX() {
        return unionNoX;
    }

    public void setUnionNoX(String unionNoX) {
        this.unionNoX = unionNoX;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getForeignID() {
        return foreignID;
    }

    public void setForeignID(String foreignID) {
        this.foreignID = foreignID;
    }

    public Integer getBursar() {
        return bursar;
    }

    public void setBursar(Integer bursar) {
        this.bursar = bursar;
    }
}
