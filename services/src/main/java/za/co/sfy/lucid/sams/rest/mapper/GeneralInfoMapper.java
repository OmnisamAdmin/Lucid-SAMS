package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.GeneralInfoRequest;
import za.co.sfy.sams.lucid.schema.GeneralInfo;

/**
 * @author muzim
 */
@Component
public class GeneralInfoMapper {

    private final SharedMapper sharedMapper;

    public GeneralInfoMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public GeneralInfo generalInfoRequestToGeneralInfo(GeneralInfoRequest generalInfoRequest) throws LucidSamsExecutionException {

        GeneralInfo generalInfo = new GeneralInfo();
        String schoolID = generalInfoRequest.getSchoolID();
        if (null != schoolID) {
            generalInfo.setSchoolID(Integer.parseInt(schoolID));
        }

        String multigrade = generalInfoRequest.getMultigrade();
        if (null != multigrade) {
            generalInfo.setMultigrade(Integer.valueOf(multigrade));
        } else {
            generalInfo.setMultigrade(Integer.valueOf(0));
        }

        String remedial = generalInfoRequest.getRemedial();
        if (null != remedial) {
            generalInfo.setRemedial(Integer.valueOf(remedial));
        } else {
            generalInfo.setRemedial(Integer.valueOf(0));
        }

        String hostTime = generalInfoRequest.getHostTime();
        if (null != hostTime) {
            generalInfo.setHostTime(Integer.valueOf(hostTime));
        } else {
            generalInfo.setHostTime(Integer.valueOf(0));
        }

        String distanceTown = generalInfoRequest.getDistanceTown();
        if (null != distanceTown) {
            generalInfo.setDistanceTown(Double.valueOf(distanceTown));
        } else {
            generalInfo.setDistanceTown(Double.valueOf(0));
        }

        String districtCode = generalInfoRequest.getDistrictCode();
        if (null != districtCode) {
            generalInfo.setDistrictCode(Integer.valueOf(districtCode));
        } else {
            generalInfo.setDistrictCode(Integer.valueOf(0));
        }

        String correspondenceLang = generalInfoRequest.getCorrespondenceLang();
        if (null != correspondenceLang) {
            generalInfo.setCorrespondenceLang(Integer.valueOf(correspondenceLang));
        } else {
            generalInfo.setCorrespondenceLang(Integer.valueOf(0));
        }

        String schoolLevel = generalInfoRequest.getSchoolLevel();
        // TODO: we need to do mapping from the value that they put in to the integer or we need to define an enum on the service-layer to define what type of school they are.
        if (null != schoolLevel) {
            generalInfo.setSchoolLevel(Integer.valueOf(schoolLevel));
        } else {
            generalInfo.setSchoolLevel(Integer.valueOf(0));
        }

        String tsSchoolStatus = generalInfoRequest.getTsSchoolStatus();
        if (null != tsSchoolStatus) {
            generalInfo.setTSSchoolStatus(Integer.valueOf(tsSchoolStatus));
        } else {
            generalInfo.setTSSchoolStatus(Integer.valueOf(0));
        }

        String tsTransactionCategory = generalInfoRequest.getTsTransactionCategory();
        if (null != tsTransactionCategory) {
            generalInfo.setTSTransactionCategory(Integer.valueOf(tsTransactionCategory));
        } else {
            generalInfo.setTSTransactionCategory(Integer.valueOf(0));
        }

        String tsStatusFlag = generalInfoRequest.getTsStatusFlag();
        if (null != tsStatusFlag) {
            generalInfo.setTSStatusFlag(Integer.valueOf(tsStatusFlag));
        } else {
            generalInfo.setTSStatusFlag(Integer.valueOf(0));
        }

        String tsReportStatusFlag = generalInfoRequest.getTsReportStatusFlag();
        if (null != tsReportStatusFlag) {
            generalInfo.setTSReportStatusFlag(Integer.valueOf(tsReportStatusFlag));
        } else {
            generalInfo.setTSReportStatusFlag(Integer.valueOf(0));
        }

        String tsReasonCode = generalInfoRequest.getTsReasonCode();
        if (null != tsReasonCode) {
            generalInfo.setTSReasonCode(Integer.valueOf(tsReasonCode));
        } else {
            generalInfo.setTSReasonCode(Integer.valueOf(0));
        }

        String luritsYear = generalInfoRequest.getLuritsYear();
        if (null != luritsYear) {
            generalInfo.setLuritsYear(Integer.valueOf(luritsYear));
        } else {
            generalInfo.setLuritsYear(Integer.valueOf(0));
        }

        String luritsIndicator = generalInfoRequest.getLuritsIndicator();
        if (null != luritsIndicator) {
            generalInfo.setLuritsIndicator(Integer.valueOf(luritsIndicator));
        } else {
            generalInfo.setLuritsIndicator(Integer.valueOf(0));
        }

        String adminComputers = generalInfoRequest.getAdminComputers();
        if (null != adminComputers) {
            generalInfo.setAdminComputers(Integer.valueOf(adminComputers));
        } else {
            generalInfo.setAdminComputers(Integer.valueOf(0));
        }

        String psnp = generalInfoRequest.getPsnp();
        if (null != psnp) {
            generalInfo.setPSNP(Short.valueOf(psnp));
        } else {
            generalInfo.setPSNP(Short.valueOf((short) 0));
        }

        String tsIncludesANA = generalInfoRequest.getTsIncludesANA();
        if (null != tsIncludesANA) {
            generalInfo.setTSIncludesANA(Short.valueOf(tsIncludesANA));
        } else {
            generalInfo.setTSIncludesANA(Short.valueOf((short) 0));
        }

        String examBoard = generalInfoRequest.getExamBoard();
        if (null != examBoard) {
            generalInfo.setExamBoard(Integer.valueOf(examBoard));
        } else {
            generalInfo.setExamBoard(Integer.valueOf(0));
        }
        Integer predominantLanguage = generalInfo.getPredominantLanguage();
        if (null != predominantLanguage) {
            generalInfo.setPredominantLanguage(Integer.valueOf(predominantLanguage));
        } else {
            generalInfo.setPredominantLanguage(Integer.valueOf(0));
        }

        Integer feeMonths = generalInfo.getFeeMonths();
        if (null != feeMonths) {
            generalInfo.setFeeMonths(feeMonths);
        } else {
            generalInfo.setFeeMonths(0);
        }

        String tsDateLastUpdate = generalInfoRequest.getTsDateLastUpdate();
        if (null != tsDateLastUpdate) {
            generalInfo.setTSDateLastUpdate(sharedMapper.dateToXMLGregorianCalendar(tsDateLastUpdate));
        } else {
            generalInfo.setTSDateLastUpdate(sharedMapper.dateToXMLGregorianCalendar());
        }


        String lastDBCompact = generalInfoRequest.getLastDBCompact();
        if (null != lastDBCompact) {
            generalInfo.setLastDBCompact(sharedMapper.dateToXMLGregorianCalendar(lastDBCompact));
        } else {
            generalInfo.setLastDBCompact(sharedMapper.dateToXMLGregorianCalendar());
        }

        String iqmsLastExpDate = generalInfoRequest.getIqmsLastExpDate();
        if (null != iqmsLastExpDate) {
            generalInfo.setIQMSLastExpDate(sharedMapper.dateToXMLGregorianCalendar(iqmsLastExpDate));
        } else {
            generalInfo.setIQMSLastExpDate(sharedMapper.dateToXMLGregorianCalendar());
        }


        String iqmsLastImpDate = generalInfoRequest.getIqmsLastImpDate();
        if (null != iqmsLastImpDate) {
            generalInfo.setIQMSLastImpDate(sharedMapper.dateToXMLGregorianCalendar(iqmsLastImpDate));
        } else {
            generalInfo.setIQMSLastImpDate(sharedMapper.dateToXMLGregorianCalendar());
        }


        String schoolName = generalInfoRequest.getSchoolName();
        if (null != schoolName) {
            generalInfo.setSchoolName(schoolName);
        }

        String provincialDep = generalInfoRequest.getProvincialDep();
        if (null != provincialDep) {
            generalInfo.setProvincialDep(provincialDep);
        }

        String district = generalInfoRequest.getDistrict();
        if (null != district) {
            generalInfo.setDistrict(district);
        }

        String region = generalInfoRequest.getRegion();
        if (null != region) {
            generalInfo.setRegion(region);
        }

        String circuit = generalInfoRequest.getCircuit();
        if (null != circuit) {
            generalInfo.setCircuit(circuit);
        }

        String address1 = generalInfoRequest.getAddress1();
        if (null != address1) {
            generalInfo.setAddress1(address1);
        }

        String address2 = generalInfoRequest.getAddress2();
        if (null != address2) {
            generalInfo.setAddress2(address2);
        }

        String address3 = generalInfoRequest.getAddress3();
        if (null != address3) {
            generalInfo.setAddress3(address3);
        }

        String addressCode = generalInfoRequest.getAddressCode();
        if (null != addressCode) {
            generalInfo.setAddressCode(addressCode);
        }

        String postAddress1 = generalInfoRequest.getPostAddress1();
        if (null != postAddress1) {
            generalInfo.setPostAddress1(postAddress1);
        }

        String postAddress2 = generalInfoRequest.getPostAddress2();
        if (null != postAddress2) {
            generalInfo.setPostAddress2(postAddress2);
        }

        String postAddress3 = generalInfoRequest.getPostAddress3();
        if (null != postAddress3) {
            generalInfo.setPostAddress3(postAddress3);
        }

        String telCode1 = generalInfoRequest.getTelCode1();
        if (null != telCode1) {
            generalInfo.setTelCode1(telCode1);
        }

        String telephone1 = generalInfoRequest.getTelephone1();
        if (null != telephone1) {
            generalInfo.setTelephone1(telephone1);
        }

        String telCode2 = generalInfoRequest.getTelCode2();
        if (null != telCode2) {
            generalInfo.setTelCode2(telCode2);
        }

        String telephone2 = generalInfoRequest.getTelephone2();
        if (null != telephone2) {
            generalInfo.setTelephone2(telephone2);
        }

        String telcode3 = generalInfoRequest.getTelcode3();
        if (null != telcode3) {
            generalInfo.setTelcode3(telcode3);
        }

        String telephone3 = generalInfoRequest.getTelephone3();
        if (null != telephone3) {
            generalInfo.setTelephone3(telephone3);
        }

        String faxCode = generalInfoRequest.getFaxCode();
        if (null != faxCode) {
            generalInfo.setFaxCode(faxCode);
        }

        String fax = generalInfoRequest.getFax();
        if (null != fax) {
            generalInfo.setFax(fax);
        }

        String school = generalInfoRequest.gettSchool();
        if (null != school) {
            generalInfo.setTSchool(school);
        }

        String add1 = generalInfoRequest.gettAdd1();
        if (null != add1) {
            generalInfo.setTAdd1(add1);
        }

        String add2 = generalInfoRequest.gettAdd2();
        if (add2 != null) {
            generalInfo.setTAdd2(add2);
        }

        String add3 = generalInfoRequest.gettAdd3();
        if (null != add3) {
            generalInfo.setTAdd3(add3);
        }

        String tCode = generalInfoRequest.gettCode();
        if (null != tCode) {
            generalInfo.setTCode(tCode);
        }

        String telcode1 = generalInfoRequest.gettTelcode1();
        if (null != telcode1) {
            generalInfo.setTtelcode1(telcode1);
        }

        String tel1 = generalInfoRequest.gettTel1();
        if (null != tel1) {
            generalInfo.setTTel1(tel1);
        }

        String tfaxcode = generalInfoRequest.getTfaxcode();
        if (null != tfaxcode) {
            generalInfo.setTfaxcode(tfaxcode);
        }

        String tFax = generalInfoRequest.gettFax();
        if (null != tFax) {
            generalInfo.setTFax(tFax);
        }

        String tPrincipal = generalInfoRequest.gettPrincipal();
        if (null != tPrincipal) {
            generalInfo.setTPrincipal(tPrincipal);
        }

        String contactPerson = generalInfoRequest.getContactPerson();
        if (null != contactPerson) {
            generalInfo.setContactPerson(contactPerson);
        }

        String emisCode = generalInfoRequest.getEmisCode();
        if (null != emisCode) {
            generalInfo.setEmisCode(emisCode);
        }

        String email = generalInfoRequest.geteMail();
        if (null != email) {
            generalInfo.setEMail(email);
        }

        String persalPayPoint = generalInfoRequest.getPersalPayPoint();
        if (null != persalPayPoint) {
            generalInfo.setPersalPayPoint(persalPayPoint);
        }

        String persalComponent = generalInfoRequest.getPersalComponent();
        if (null != persalComponent) {
            generalInfo.setPersalComponent(persalComponent);
        }

        String internetAccess = generalInfoRequest.getInternetAccess();
        if (null != internetAccess) {
            generalInfo.setInternetAccess(internetAccess);
        }

        String ownership = generalInfoRequest.getOwnership();
        if (null != ownership) {
            generalInfo.setOwnership(ownership);
        }

        String landOwnership = generalInfoRequest.getLandOwnership();
        if (null != landOwnership) {
            generalInfo.setLandOwnership(landOwnership);
        }

        String platoon = generalInfoRequest.getPlatoon();
        if (null != platoon) {
            generalInfo.setPlatoon(platoon);
        }

        String hostSchool = generalInfoRequest.getHostSchool();
        if (null != hostSchool) {
            generalInfo.setHostSchool(hostSchool);
        }

        String doubleShifts = generalInfoRequest.getDoubleShifts();
        if (null != doubleShifts) {
            generalInfo.setDoubleShifts(doubleShifts);
        }

        String examAuthority = generalInfoRequest.getExamAuthority();
        if (null != examAuthority) {
            generalInfo.setExamAuthority(examAuthority);
        }

        String examCentre = generalInfoRequest.getExamCentre();
        if (null != examCentre) {
            generalInfo.setExamCentre(examCentre);
        }

        String examCentreNumber = generalInfoRequest.getExamCentreNumber();
        if (null != examCentreNumber) {
            generalInfo.setExamCentreNumber(examCentreNumber);
        }

        String specialised = generalInfoRequest.getSpecialised();
        if (null != specialised) {
            generalInfo.setSpecialised(specialised);
        }

        String specialisation = generalInfoRequest.getSpecialisation();
        if (null != specialisation) {
            generalInfo.setSpecialisation(specialisation);
        }

        String feePeriod = generalInfoRequest.getFeePeriod();
        if (null != feePeriod) {
            generalInfo.setFeePeriod(feePeriod);
        }

        String sgbStatus = generalInfoRequest.getSgbStatus();
        if (null != sgbStatus) {
            generalInfo.setSGBStatus(sgbStatus);
        }

        String censusArea = generalInfoRequest.getCensusArea();
        if (null != censusArea) {
            generalInfo.setCensusArea(censusArea);
        }

        String erfNumber = generalInfoRequest.getErfNumber();
        if (null != erfNumber) {
            generalInfo.setErfNumber(erfNumber);
        }

        String emisHostSchool = generalInfoRequest.getEmisHostSchool();
        if (null != emisHostSchool) {
            generalInfo.setEmisHostSchool(emisHostSchool);
        }

        String examAuthName = generalInfoRequest.getExamAuthName();
        if (null != examAuthName) {
            generalInfo.setExamAuthName(examAuthName);
        }

        String nearestTown = generalInfoRequest.getNearestTown();
        if (null != nearestTown) {
            generalInfo.setNearestTown(nearestTown);
        }

        String postalAddressType = generalInfoRequest.getPostalAddressType();
        if (null != postalAddressType) {
            generalInfo.setPostalAddressType(postalAddressType);
        }

        String tsSentFileName = generalInfoRequest.getTsSentFileName();
        if (null != tsSentFileName) {
            generalInfo.setTSSentFileName(tsSentFileName);
        }

        String tsLastUpdatedBy = generalInfoRequest.getTsLastUpdatedBy();
        if (null != tsLastUpdatedBy) {
            generalInfo.setTSLastUpdatedBy(tsLastUpdatedBy);
        }

        String ownerBuildings = generalInfoRequest.getOwnerBuildings();
        if (null != ownerBuildings) {
            generalInfo.setOwnerBuildings(ownerBuildings);
        }

        String telcode4 = generalInfoRequest.getTelcode4();
        if (null != telcode4) {
            generalInfo.setTelcode4(telcode4);
        }

        String telephone4 = generalInfoRequest.getTelephone4();
        if (null != telephone4) {
            generalInfo.setTelephone4(telephone4);
        }

        String postAddress0 = generalInfoRequest.getPostAddress0();
        if (null != postAddress0) {
            generalInfo.setPostAddress0(postAddress0);
        }

        String postAddress0No = generalInfoRequest.getPostAddress0No();
        if (null != postAddress0No) {
            generalInfo.setPostAddress0No(postAddress0No);
        }

        String tEmisCode = generalInfoRequest.gettEmisCode();
        if (null != tEmisCode) {
            generalInfo.setTEmisCode(tEmisCode);
        }

        String examBoardOther = generalInfoRequest.getExamBoardOther();
        if (null != examBoardOther) {
            generalInfo.setExamBoardOther(examBoardOther);
        }

        generalInfo.setUseMarksSecurity(generalInfoRequest.getUseMarksSecurity());
        generalInfo.setMaintainProperty(generalInfoRequest.getMaintainProperty());
        generalInfo.setExtraMural(generalInfoRequest.getExtraMural());
        generalInfo.setTextbooks(generalInfoRequest.getTextbooks());
        generalInfo.setServices(generalInfoRequest.getServices());
        generalInfo.setAbet(generalInfoRequest.getAbet());
        generalInfo.setOtherFunctions(generalInfoRequest.getOtherFunctions());

        return generalInfo;
    }
}