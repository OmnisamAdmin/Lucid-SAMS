package za.co.sfy.lucid.sams.rest.vo.data.writer;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class GeneralInfoRequest implements Serializable {

    private static final long serialVersionUID = -5550554900493974563L;

    private String schoolID;
    @NotNull
    private String schoolName;
    @NotNull
    private String provincialDep;
    @NotNull
    private String district;
    private String region;
    private String circuit;
    @NotNull
    private String address1;
    @NotNull
    private String address2;
    @NotNull
    private String address3;
    private String addressCode;
    @NotNull
    private String postAddress1;
    private String postAddress2;
    @NotNull
    private String postAddress3;
    @NotNull
    private String postCode;
    private String telCode1;
    private String telephone1;
    private String telCode2;
    private String telephone2;
    private String telcode3;
    private String telephone3;
    private String faxCode;
    private String fax;
    private String tSchool;
    private String tAdd1;
    private String tAdd2;
    private String tAdd3;
    private String tCode;
    private String tTelcode1;
    private String tTel1;
    private String tfaxcode;
    private String tFax;
    private String tPrincipal;
    private String contactPerson;
    @NotNull
    private String emisCode;
    private String eMail;
    private String predominantLanguage;
    private String persalPayPoint;
    @NotNull
    private String persalComponent;
    private String internetAccess;
    @NotNull
    private String ownership;
    @NotNull
    private String landOwnership;
    private String platoon;
    private String hostSchool;
    @NotNull
    private String doubleShifts;
    private String examAuthority;
    private String examCentre;
    private String examCentreNumber;
    private String specialised;
    private String specialisation;
    private String feePeriod;
    private String feeMonths;
    private String multigrade;
    private String remedial;
    @NotNull
    private String sgbStatus;
    private boolean maintainProperty;
    private boolean extraMural;
    private boolean textbooks;
    private boolean services;
    private boolean abet;
    private boolean otherFunctions;
    private String censusArea;
    private String erfNumber;
    private String emisHostSchool;
    private String hostTime;
    private String examAuthName;
    private String correspondenceLang;
    private String nearestTown;
    private String distanceTown;
    private String districtCode;
    @NotNull
    private String postalAddressType;
    @NotNull
    private String schoolLevel;
    private String tsSchoolStatus;
    // TODO: these two fields might be whats breaking it
    private String tsTransactionCategory;
    private String tsStatusFlag;
    private String tsReportStatusFlag;
    private String tsReasonCode;
    private String luritsYear;
    private String tsSentFileName;
    private String tsLastUpdatedBy;
    private String tsDateLastUpdate;
    @NotNull
    private String ownerBuildings;
    private String luritsIndicator;
    private String telcode4;
    private String telephone4;
    @NotNull
    private String adminComputers;
    @NotNull
    private String postAddress0;
    @NotNull
    private String postAddress0No;
    private String tEmisCode;
    private boolean useMarksSecurity;
    @NotNull
    private String psnp;
    private String tsIncludesANA;
    private String lastDBCompact;
    private String iqmsLastExpDate;
    private String iqmsLastImpDate;
    private String examBoard;
    private String examBoardOther;
    private String multigrades;
    private String emisOfficer;
    private boolean emisOffEducator;
    private String emailAlt;

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProvincialDep() {
        return provincialDep;
    }

    public void setProvincialDep(String provincialDep) {
        this.provincialDep = provincialDep;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
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

    public String getPostAddress1() {
        return postAddress1;
    }

    public void setPostAddress1(String postAddress1) {
        this.postAddress1 = postAddress1;
    }

    public String getPostAddress2() {
        return postAddress2;
    }

    public void setPostAddress2(String postAddress2) {
        this.postAddress2 = postAddress2;
    }

    public String getPostAddress3() {
        return postAddress3;
    }

    public void setPostAddress3(String postAddress3) {
        this.postAddress3 = postAddress3;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTelCode1() {
        return telCode1;
    }

    public void setTelCode1(String telCode1) {
        this.telCode1 = telCode1;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelCode2() {
        return telCode2;
    }

    public void setTelCode2(String telCode2) {
        this.telCode2 = telCode2;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getTelcode3() {
        return telcode3;
    }

    public void setTelcode3(String telcode3) {
        this.telcode3 = telcode3;
    }

    public String getTelephone3() {
        return telephone3;
    }

    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
    }

    public String getFaxCode() {
        return faxCode;
    }

    public void setFaxCode(String faxCode) {
        this.faxCode = faxCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String gettSchool() {
        return tSchool;
    }

    public void settSchool(String tSchool) {
        this.tSchool = tSchool;
    }

    public String gettAdd1() {
        return tAdd1;
    }

    public void settAdd1(String tAdd1) {
        this.tAdd1 = tAdd1;
    }

    public String gettAdd2() {
        return tAdd2;
    }

    public void settAdd2(String tAdd2) {
        this.tAdd2 = tAdd2;
    }

    public String gettAdd3() {
        return tAdd3;
    }

    public void settAdd3(String tAdd3) {
        this.tAdd3 = tAdd3;
    }

    public String gettCode() {
        return tCode;
    }

    public void settCode(String tCode) {
        this.tCode = tCode;
    }

    public String gettTelcode1() {
        return tTelcode1;
    }

    public void settTelcode1(String tTelcode1) {
        this.tTelcode1 = tTelcode1;
    }

    public String gettTel1() {
        return tTel1;
    }

    public void settTel1(String tTel1) {
        this.tTel1 = tTel1;
    }

    public String getTfaxcode() {
        return tfaxcode;
    }

    public void setTfaxcode(String tfaxcode) {
        this.tfaxcode = tfaxcode;
    }

    public String gettFax() {
        return tFax;
    }

    public void settFax(String tFax) {
        this.tFax = tFax;
    }

    public String gettPrincipal() {
        return tPrincipal;
    }

    public void settPrincipal(String tPrincipal) {
        this.tPrincipal = tPrincipal;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmisCode() {
        return emisCode;
    }

    public void setEmisCode(String emisCode) {
        this.emisCode = emisCode;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPredominantLanguage() {
        return predominantLanguage;
    }

    public void setPredominantLanguage(String predominantLanguage) {
        this.predominantLanguage = predominantLanguage;
    }

    public String getPersalPayPoint() {
        return persalPayPoint;
    }

    public void setPersalPayPoint(String persalPayPoint) {
        this.persalPayPoint = persalPayPoint;
    }

    public String getPersalComponent() {
        return persalComponent;
    }

    public void setPersalComponent(String persalComponent) {
        this.persalComponent = persalComponent;
    }

    public String getInternetAccess() {
        return internetAccess;
    }

    public void setInternetAccess(String internetAccess) {
        this.internetAccess = internetAccess;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getLandOwnership() {
        return landOwnership;
    }

    public void setLandOwnership(String landOwnership) {
        this.landOwnership = landOwnership;
    }

    public String getPlatoon() {
        return platoon;
    }

    public void setPlatoon(String platoon) {
        this.platoon = platoon;
    }

    public String getHostSchool() {
        return hostSchool;
    }

    public void setHostSchool(String hostSchool) {
        this.hostSchool = hostSchool;
    }

    public String getDoubleShifts() {
        return doubleShifts;
    }

    public void setDoubleShifts(String doubleShifts) {
        this.doubleShifts = doubleShifts;
    }

    public String getExamAuthority() {
        return examAuthority;
    }

    public void setExamAuthority(String examAuthority) {
        this.examAuthority = examAuthority;
    }

    public String getExamCentre() {
        return examCentre;
    }

    public void setExamCentre(String examCentre) {
        this.examCentre = examCentre;
    }

    public String getExamCentreNumber() {
        return examCentreNumber;
    }

    public void setExamCentreNumber(String examCentreNumber) {
        this.examCentreNumber = examCentreNumber;
    }

    public String getSpecialised() {
        return specialised;
    }

    public void setSpecialised(String specialised) {
        this.specialised = specialised;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getFeePeriod() {
        return feePeriod;
    }

    public void setFeePeriod(String feePeriod) {
        this.feePeriod = feePeriod;
    }

    public String getFeeMonths() {
        return feeMonths;
    }

    public void setFeeMonths(String feeMonths) {
        this.feeMonths = feeMonths;
    }

    public String getMultigrade() {
        return multigrade;
    }

    public void setMultigrade(String multigrade) {
        this.multigrade = multigrade;
    }

    public String getRemedial() {
        return remedial;
    }

    public void setRemedial(String remedial) {
        this.remedial = remedial;
    }

    public String getSgbStatus() {
        return sgbStatus;
    }

    public void setSgbStatus(String sgbStatus) {
        this.sgbStatus = sgbStatus;
    }

    public boolean getMaintainProperty() {
        return maintainProperty;
    }

    public void setMaintainProperty(boolean maintainProperty) {
        this.maintainProperty = maintainProperty;
    }

    public boolean getExtraMural() {
        return extraMural;
    }

    public void setExtraMural(boolean extraMural) {
        this.extraMural = extraMural;
    }

    public boolean getTextbooks() {
        return textbooks;
    }

    public void setTextbooks(boolean textbooks) {
        this.textbooks = textbooks;
    }

    public boolean getServices() {
        return services;
    }

    public void setServices(boolean services) {
        this.services = services;
    }

    public boolean getAbet() {
        return abet;
    }

    public void setAbet(boolean abet) {
        this.abet = abet;
    }

    public boolean getOtherFunctions() {
        return otherFunctions;
    }

    public void setOtherFunctions(boolean otherFunctions) {
        this.otherFunctions = otherFunctions;
    }

    public String getCensusArea() {
        return censusArea;
    }

    public void setCensusArea(String censusArea) {
        this.censusArea = censusArea;
    }

    public String getErfNumber() {
        return erfNumber;
    }

    public void setErfNumber(String erfNumber) {
        this.erfNumber = erfNumber;
    }

    public String getEmisHostSchool() {
        return emisHostSchool;
    }

    public void setEmisHostSchool(String emisHostSchool) {
        this.emisHostSchool = emisHostSchool;
    }

    public String getHostTime() {
        return hostTime;
    }

    public void setHostTime(String hostTime) {
        this.hostTime = hostTime;
    }

    public String getExamAuthName() {
        return examAuthName;
    }

    public void setExamAuthName(String examAuthName) {
        this.examAuthName = examAuthName;
    }

    public String getCorrespondenceLang() {
        return correspondenceLang;
    }

    public void setCorrespondenceLang(String correspondenceLang) {
        this.correspondenceLang = correspondenceLang;
    }

    public String getNearestTown() {
        return nearestTown;
    }

    public void setNearestTown(String nearestTown) {
        this.nearestTown = nearestTown;
    }

    public String getDistanceTown() {
        return distanceTown;
    }

    public void setDistanceTown(String distanceTown) {
        this.distanceTown = distanceTown;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getPostalAddressType() {
        return postalAddressType;
    }

    public void setPostalAddressType(String postalAddressType) {
        this.postalAddressType = postalAddressType;
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    public String getTsSchoolStatus() {
        return tsSchoolStatus;
    }

    public void setTsSchoolStatus(String tsSchoolStatus) {
        this.tsSchoolStatus = tsSchoolStatus;
    }

    public String getTsTransactionCategory() {
        return tsTransactionCategory;
    }

    public void setTsTransactionCategory(String tsTransactionCategory) {
        this.tsTransactionCategory = tsTransactionCategory;
    }

    public String getTsStatusFlag() {
        return tsStatusFlag;
    }

    public void setTsStatusFlag(String tsStatusFlag) {
        this.tsStatusFlag = tsStatusFlag;
    }

    public String getTsReportStatusFlag() {
        return tsReportStatusFlag;
    }

    public void setTsReportStatusFlag(String tsReportStatusFlag) {
        this.tsReportStatusFlag = tsReportStatusFlag;
    }

    public String getTsReasonCode() {
        return tsReasonCode;
    }

    public void setTsReasonCode(String tsReasonCode) {
        this.tsReasonCode = tsReasonCode;
    }

    public String getLuritsYear() {
        return luritsYear;
    }

    public void setLuritsYear(String luritsYear) {
        this.luritsYear = luritsYear;
    }

    public String getTsSentFileName() {
        return tsSentFileName;
    }

    public void setTsSentFileName(String tsSentFileName) {
        this.tsSentFileName = tsSentFileName;
    }

    public String getTsLastUpdatedBy() {
        return tsLastUpdatedBy;
    }

    public void setTsLastUpdatedBy(String tsLastUpdatedBy) {
        this.tsLastUpdatedBy = tsLastUpdatedBy;
    }

    public String getTsDateLastUpdate() {
        return tsDateLastUpdate;
    }

    public void setTsDateLastUpdate(String tsDateLastUpdate) {
        this.tsDateLastUpdate = tsDateLastUpdate;
    }

    public String getOwnerBuildings() {
        return ownerBuildings;
    }

    public void setOwnerBuildings(String ownerBuildings) {
        this.ownerBuildings = ownerBuildings;
    }

    public String getLuritsIndicator() {
        return luritsIndicator;
    }

    public void setLuritsIndicator(String luritsIndicator) {
        this.luritsIndicator = luritsIndicator;
    }

    public String getTelcode4() {
        return telcode4;
    }

    public void setTelcode4(String telcode4) {
        this.telcode4 = telcode4;
    }

    public String getTelephone4() {
        return telephone4;
    }

    public void setTelephone4(String telephone4) {
        this.telephone4 = telephone4;
    }

    public String getAdminComputers() {
        return adminComputers;
    }

    public void setAdminComputers(String adminComputers) {
        this.adminComputers = adminComputers;
    }

    public String getPostAddress0() {
        return postAddress0;
    }

    public void setPostAddress0(String postAddress0) {
        this.postAddress0 = postAddress0;
    }

    public String getPostAddress0No() {
        return postAddress0No;
    }

    public void setPostAddress0No(String postAddress0No) {
        this.postAddress0No = postAddress0No;
    }

    public String gettEmisCode() {
        return tEmisCode;
    }

    public void settEmisCode(String tEmisCode) {
        this.tEmisCode = tEmisCode;
    }

    public boolean getUseMarksSecurity() {
        return useMarksSecurity;
    }

    public void setUseMarksSecurity(boolean useMarksSecurity) {
        this.useMarksSecurity = useMarksSecurity;
    }

    public String getPsnp() {
        return psnp;
    }

    public void setPsnp(String psnp) {
        this.psnp = psnp;
    }

    public String getTsIncludesANA() {
        return tsIncludesANA;
    }

    public void setTsIncludesANA(String tsIncludesANA) {
        this.tsIncludesANA = tsIncludesANA;
    }

    public String getLastDBCompact() {
        return lastDBCompact;
    }

    public void setLastDBCompact(String lastDBCompact) {
        this.lastDBCompact = lastDBCompact;
    }

    public String getIqmsLastExpDate() {
        return iqmsLastExpDate;
    }

    public void setIqmsLastExpDate(String iqmsLastExpDate) {
        this.iqmsLastExpDate = iqmsLastExpDate;
    }

    public String getIqmsLastImpDate() {
        return iqmsLastImpDate;
    }

    public void setIqmsLastImpDate(String iqmsLastImpDate) {
        this.iqmsLastImpDate = iqmsLastImpDate;
    }

    public String getExamBoard() {
        return examBoard;
    }

    public void setExamBoard(String examBoard) {
        this.examBoard = examBoard;
    }

    public String getExamBoardOther() {
        return examBoardOther;
    }

    public void setExamBoardOther(String examBoardOther) {
        this.examBoardOther = examBoardOther;
    }

    public String getMultigrades() {
        return multigrades;
    }

    public void setMultigrades(String multigrades) {
        this.multigrades = multigrades;
    }

    public String getEmisOfficer() {
        return emisOfficer;
    }

    public void setEmisOfficer(String emisOfficer) {
        this.emisOfficer = emisOfficer;
    }

    public boolean isEmisOffEducator() {
        return emisOffEducator;
    }

    public void setEmisOffEducator(boolean emisOffEducator) {
        this.emisOffEducator = emisOffEducator;
    }

    public String getEmailAlt() {
        return emailAlt;
    }

    public void setEmailAlt(String emailAlt) {
        this.emailAlt = emailAlt;
    }
}