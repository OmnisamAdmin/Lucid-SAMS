package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.GeneralInfoRequest;
import za.co.sfy.sams.lucid.schema.GeneralInfo;

import javax.xml.datatype.XMLGregorianCalendar;

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

        Long schoolID = generalInfoRequest.getSchoolID();
        if (null != schoolID) {
            generalInfo.setSchoolID(Math.toIntExact(schoolID));
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

        Integer districtCode = generalInfoRequest.getDistrictCode();
        if (null != districtCode) {
            generalInfo.setDistrictCode(districtCode);
        } else {
            generalInfo.setDistrictCode(0);
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

        String tSchool = generalInfoRequest.gettSchool();
        if (null != tSchool) {
            generalInfo.setTSchool(tSchool);
        }

        String tAdd1 = generalInfoRequest.gettAdd1();
        if (null != tAdd1) {
            generalInfo.setTAdd1(tAdd1);
        }

        String tAdd2 = generalInfoRequest.gettAdd2();
        if (tAdd2 != null) {
            generalInfo.setTAdd2(tAdd2);
        }

        String tAdd3 = generalInfoRequest.gettAdd3();
        if (null != tAdd3) {
            generalInfo.setTAdd3(tAdd3);
        }

        String tCode = generalInfoRequest.gettCode();
        if (null != tCode) {
            generalInfo.setTCode(tCode);
        }

        String tTelcode1 = generalInfoRequest.gettTelcode1();
        if (null != tTelcode1) {
            generalInfo.setTtelcode1(tTelcode1);
        }

        String tTel1 = generalInfoRequest.gettTel1();
        if (null != tTel1) {
            generalInfo.setTTel1(tTel1);
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

        Integer predominantLanguage = generalInfo.getPredominantLanguage();
        if (null != predominantLanguage) {
            generalInfo.setPredominantLanguage(predominantLanguage);
        } else {
            generalInfo.setPredominantLanguage(0);
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

        Integer feeMonths = generalInfo.getFeeMonths();
        if (null != feeMonths) {
            generalInfo.setFeeMonths(feeMonths);
        } else {
            generalInfo.setFeeMonths(0);
        }

        Integer multigrade = generalInfoRequest.getMultigrade();
        if (null != multigrade) {
            generalInfo.setMultigrade(multigrade);
        } else {
            generalInfo.setMultigrade(0);
        }

        Integer remedial = generalInfoRequest.getRemedial();
        if (null != remedial) {
            generalInfo.setRemedial(remedial);
        } else {
            generalInfo.setRemedial(0);
        }

        String sgbStatus = generalInfoRequest.getSgbStatus();
        if (null != sgbStatus) {
            generalInfo.setSGBStatus(sgbStatus);
        }

        generalInfo.setMaintainProperty(generalInfoRequest.getMaintainProperty());

        generalInfo.setExtraMural(generalInfoRequest.getExtraMural());

        generalInfo.setTextbooks(generalInfoRequest.getTextbooks());

        generalInfo.setServices(generalInfoRequest.getServices());

        generalInfo.setAbet(generalInfoRequest.getAbet());

        generalInfo.setOtherFunctions(generalInfoRequest.getOtherFunctions());

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

        Integer hostTime = generalInfoRequest.getHostTime();
        if (null != hostTime) {
            generalInfo.setHostTime(hostTime);
        } else {
            generalInfo.setHostTime(0);
        }

        String examAuthName = generalInfoRequest.getExamAuthName();
        if (null != examAuthName) {
            generalInfo.setExamAuthName(examAuthName);
        }

        Integer correspondenceLang = generalInfoRequest.getCorrespondenceLang();
        if (null != correspondenceLang) {
            generalInfo.setCorrespondenceLang(correspondenceLang);
        } else generalInfo.setCorrespondenceLang(0);

        String nearestTown = generalInfoRequest.getNearestTown();
        if (null != nearestTown) {
            generalInfo.setNearestTown(nearestTown);
        }

        Double distanceTown = generalInfoRequest.getDistanceTown();
        if (null != distanceTown) {
            generalInfo.setDistanceTown(distanceTown);
        } else {
            generalInfo.setDistanceTown((double) 0);
        }

        String postalAddressType = generalInfoRequest.getPostalAddressType();
        if (null != postalAddressType) {
            generalInfo.setPostalAddressType(postalAddressType);
        }

        Integer schoolLevel = generalInfoRequest.getSchoolLevel();
        // TODO: we need to do mapping from the value that they put in to the integer or we need to define an enum on the service-layer to define what type of school they are.
        if (null != schoolLevel) {
            generalInfo.setSchoolLevel(schoolLevel);
        } else {
            generalInfo.setSchoolLevel(0);
        }

        Integer tsSchoolStatus = generalInfoRequest.getTsSchoolStatus();
        if (null != tsSchoolStatus) {
            generalInfo.setTSSchoolStatus(tsSchoolStatus);
        } else {
            generalInfo.setTSSchoolStatus(0);
        }

        Integer tsTransactionCategory = generalInfoRequest.getTsTransactionCategory();
        if (null != tsTransactionCategory) {
            generalInfo.setTSTransactionCategory(tsTransactionCategory);
        } else {
            generalInfo.setTSTransactionCategory(0);
        }

        Integer tsStatusFlag = generalInfoRequest.getTsStatusFlag();
        if (null != tsStatusFlag) {
            generalInfo.setTSStatusFlag(tsStatusFlag);
        } else {
            generalInfo.setTSStatusFlag(0);
        }

        Integer tsReportStatusFlag = generalInfoRequest.getTsReportStatusFlag();
        if (null != tsReportStatusFlag) {
            generalInfo.setTSReportStatusFlag(tsReportStatusFlag);
        } else {
            generalInfo.setTSReportStatusFlag(0);
        }

        Integer tsReasonCode = generalInfoRequest.getTsReasonCode();
        if (null != tsReasonCode) {
            generalInfo.setTSReasonCode(tsReasonCode);
        } else {
            generalInfo.setTSReasonCode(0);
        }

        Integer luritsYear = generalInfoRequest.getLuritsYear();
        if (null != luritsYear) {
            generalInfo.setLuritsYear(luritsYear);
        } else {
            generalInfo.setLuritsYear(0);
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

        Integer luritsIndicator = generalInfoRequest.getLuritsIndicator();
        if (null != luritsIndicator) {
            generalInfo.setLuritsIndicator(luritsIndicator);
        } else {
            generalInfo.setLuritsIndicator(0);
        }

        String telcode4 = generalInfoRequest.getTelcode4();
        if (null != telcode4) {
            generalInfo.setTelcode4(telcode4);
        }

        String telephone4 = generalInfoRequest.getTelephone4();
        if (null != telephone4) {
            generalInfo.setTelephone4(telephone4);
        }

        Integer adminComputers = generalInfoRequest.getAdminComputers();
        if (null != adminComputers) {
            generalInfo.setAdminComputers(adminComputers);
        } else {
            generalInfo.setAdminComputers(0);
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

        generalInfo.setUseMarksSecurity(generalInfoRequest.getUseMarksSecurity());

        Short psnp = generalInfoRequest.getPsnp();
        if (null != psnp) {
            generalInfo.setPSNP(psnp);
        } else {
            generalInfo.setPSNP((short) 0);
        }

        Short tsIncludesANA = generalInfoRequest.getTsIncludesANA();
        if (null != tsIncludesANA) {
            generalInfo.setTSIncludesANA(tsIncludesANA);
        } else {
            generalInfo.setTSIncludesANA((short) 0);
        }

        Integer examBoard = generalInfoRequest.getExamBoard();
        if (null != examBoard) {
            generalInfo.setExamBoard(examBoard);
        } else {
            generalInfo.setExamBoard(0);
        }

        String examBoardOther = generalInfoRequest.getExamBoardOther();
        if (null != examBoardOther) {
            generalInfo.setExamBoardOther(examBoardOther);
        }

        String tsDateLastUpdateString = generalInfoRequest.getTsDateLastUpdate();
        if (!tsDateLastUpdateString.isEmpty()) {
            XMLGregorianCalendar tsDateLastUpdate = sharedMapper.dateToXMLGregorianCalendar(tsDateLastUpdateString);
            generalInfo.setTSDateLastUpdate(tsDateLastUpdate);
        } else {
            generalInfo.setTSDateLastUpdate(null);
        }

        String lastDBCompactString = generalInfoRequest.getLastDBCompact();
        if (!lastDBCompactString.isEmpty()) {
            XMLGregorianCalendar lastDBCompact = sharedMapper.dateToXMLGregorianCalendar(lastDBCompactString);
            generalInfo.setLastDBCompact(lastDBCompact);
        } else {
            generalInfo.setLastDBCompact(null);
        }

        String iqmsLastExpDateString = generalInfoRequest.getIqmsLastExpDate();
        if (!iqmsLastExpDateString.isEmpty()) {
            XMLGregorianCalendar iqmsLastExpDate = sharedMapper.dateToXMLGregorianCalendar(iqmsLastExpDateString);
            generalInfo.setIQMSLastExpDate(iqmsLastExpDate);
        } else {
            generalInfo.setIQMSLastExpDate(null);
        }

        String iqmsLastImpDateString = generalInfoRequest.getIqmsLastImpDate();
        if (!iqmsLastImpDateString.isEmpty()) {
            XMLGregorianCalendar iqmsLastImpDate = sharedMapper.dateToXMLGregorianCalendar(iqmsLastImpDateString);
            generalInfo.setIQMSLastImpDate(iqmsLastImpDate);
        } else {
            generalInfo.setIQMSLastImpDate(null);
        }

        return generalInfo;
    }
}
