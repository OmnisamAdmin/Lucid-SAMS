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

        //TODO: Please add null checks to the not required fields so that we do not get null pointers when trying to map them.
        generalInfo.setSchoolID(Integer.parseInt(generalInfoRequest.getSchoolID()));
        generalInfo.setSchoolName(generalInfoRequest.getSchoolName());
        generalInfo.setProvincialDep(generalInfoRequest.getProvincialDep());
        generalInfo.setDistrict(generalInfoRequest.getDistrict());
        generalInfo.setRegion(generalInfoRequest.getRegion());
        generalInfo.setCircuit(generalInfoRequest.getCircuit());
        generalInfo.setAddress1(generalInfoRequest.getAddress1());
        generalInfo.setAddress2(generalInfoRequest.getAddress2());
        generalInfo.setAddress3(generalInfoRequest.getAddress3());
        generalInfo.setAddressCode(generalInfoRequest.getAddressCode());
        generalInfo.setPostAddress1(generalInfoRequest.getPostAddress1());
        generalInfo.setPostAddress2(generalInfoRequest.getPostAddress1());
        generalInfo.setPostAddress3(generalInfoRequest.getPostAddress1());
        generalInfo.setTelCode1(generalInfoRequest.getTelCode1());
        generalInfo.setTelephone1(generalInfoRequest.getTelephone1());
        generalInfo.setTelCode2(generalInfoRequest.getTelCode2());
        generalInfo.setTelephone2(generalInfoRequest.getTelephone2());
        generalInfo.setTelcode3(generalInfoRequest.getTelcode3());
        generalInfo.setTelephone3(generalInfoRequest.getTelephone3());
        generalInfo.setFaxCode(generalInfoRequest.getFaxCode());
        generalInfo.setFax(generalInfoRequest.getFax());
        generalInfo.setTSchool(generalInfoRequest.gettSchool());
        generalInfo.setTAdd1(generalInfoRequest.gettAdd1());
        generalInfo.setTAdd2(generalInfoRequest.gettAdd2());
        generalInfo.setTAdd3(generalInfoRequest.gettAdd3());
        generalInfo.setTCode(generalInfoRequest.gettCode());
        generalInfo.setTtelcode1(generalInfoRequest.gettTelcode1());
        generalInfo.setTTel1(generalInfoRequest.gettTel1());
        generalInfo.setTfaxcode(generalInfoRequest.getTfaxcode());
        generalInfo.setTFax(generalInfoRequest.gettFax());
        generalInfo.setTPrincipal(generalInfoRequest.gettPrincipal());
        generalInfo.setContactPerson(generalInfoRequest.getContactPerson());
        generalInfo.setEmisCode(generalInfoRequest.getEmisCode());
        generalInfo.setEMail(generalInfoRequest.geteMail());
        generalInfo.setPredominantLanguage(Integer.valueOf(generalInfoRequest.getPredominantLanguage()));
        generalInfo.setPersalPayPoint(generalInfoRequest.getPersalPayPoint());
        generalInfo.setPersalComponent(generalInfoRequest.getPersalComponent());
        generalInfo.setInternetAccess(generalInfoRequest.getInternetAccess());
        generalInfo.setOwnership(generalInfoRequest.getOwnership());
        generalInfo.setLandOwnership(generalInfoRequest.getLandOwnership());
        generalInfo.setPlatoon(generalInfoRequest.getPlatoon());
        generalInfo.setHostSchool(generalInfoRequest.getHostSchool());
        generalInfo.setDoubleShifts(generalInfoRequest.getDoubleShifts());
        generalInfo.setExamAuthority(generalInfoRequest.getExamAuthority());
        generalInfo.setExamCentre(generalInfoRequest.getExamCentre());
        generalInfo.setExamCentreNumber(generalInfoRequest.getExamCentreNumber());
        generalInfo.setSpecialised(generalInfoRequest.getSpecialised());
        generalInfo.setSpecialisation(generalInfoRequest.getSpecialisation());
        generalInfo.setFeePeriod(generalInfoRequest.getFeePeriod());
        generalInfo.setFeeMonths(Integer.valueOf(generalInfoRequest.getFeeMonths()));
        generalInfo.setMultigrade(Integer.valueOf(generalInfoRequest.getMultigrade()));
        generalInfo.setRemedial(Integer.valueOf(generalInfoRequest.getRemedial()));
        generalInfo.setSGBStatus(generalInfoRequest.getSgbStatus());
        generalInfo.setMaintainProperty(generalInfoRequest.getMaintainProperty());
        generalInfo.setExtraMural(generalInfoRequest.getExtraMural());
        generalInfo.setTextbooks(generalInfoRequest.getTextbooks());
        generalInfo.setServices(generalInfoRequest.getServices());
        generalInfo.setAbet(generalInfoRequest.getAbet());
        generalInfo.setOtherFunctions(generalInfoRequest.getOtherFunctions());
        generalInfo.setCensusArea(generalInfoRequest.getCensusArea());
        generalInfo.setErfNumber(generalInfoRequest.getErfNumber());
        generalInfo.setEmisHostSchool(generalInfoRequest.getEmisHostSchool());
        generalInfo.setHostTime(Integer.valueOf(generalInfoRequest.getHostTime()));
        generalInfo.setExamAuthName(generalInfoRequest.getExamAuthName());
        generalInfo.setCorrespondenceLang(Integer.valueOf(generalInfoRequest.getCorrespondenceLang()));
        generalInfo.setNearestTown(generalInfoRequest.getNearestTown());
        generalInfo.setDistanceTown(Double.valueOf(generalInfoRequest.getDistanceTown()));
        generalInfo.setDistrictCode(Integer.valueOf(generalInfoRequest.getDistrictCode()));
        generalInfo.setPostalAddressType(generalInfoRequest.getPostalAddressType());
        generalInfo.setSchoolLevel(Integer.valueOf(generalInfoRequest.getSchoolLevel()));
        generalInfo.setTSSchoolStatus(Integer.valueOf(generalInfoRequest.getTsSchoolStatus()));
        generalInfo.setTSTransactionCategory(Integer.valueOf(generalInfoRequest.getTsTransactionCategory()));
        generalInfo.setTSStatusFlag(Integer.valueOf(generalInfoRequest.getTsStatusFlag()));
        generalInfo.setTSReportStatusFlag(Integer.valueOf(generalInfoRequest.getTsReportStatusFlag()));
        generalInfo.setTSReasonCode(Integer.valueOf(generalInfoRequest.getTsReasonCode()));
        generalInfo.setLuritsYear(Integer.valueOf(generalInfoRequest.getLuritsYear()));
        generalInfo.setTSSentFileName(generalInfoRequest.getTsSentFileName());
        generalInfo.setTSLastUpdatedBy(generalInfoRequest.getTsLastUpdatedBy());
        generalInfo.setOwnerBuildings(generalInfoRequest.getOwnerBuildings());
        generalInfo.setLuritsIndicator(Integer.valueOf(generalInfoRequest.getLuritsIndicator()));
        generalInfo.setTelcode4(generalInfoRequest.getTelcode4());
        generalInfo.setTelephone4(generalInfoRequest.getTelephone4());
        generalInfo.setAdminComputers(Integer.valueOf(generalInfoRequest.getAdminComputers()));
        generalInfo.setPostAddress0(generalInfoRequest.getPostAddress0());
        generalInfo.setPostAddress0No(generalInfoRequest.getPostAddress0No());
        generalInfo.setTEmisCode(generalInfoRequest.gettEmisCode());
        generalInfo.setUseMarksSecurity(generalInfoRequest.getUseMarksSecurity());
        generalInfo.setPSNP(Short.valueOf(generalInfoRequest.getPsnp()));
        generalInfo.setTSIncludesANA(Short.valueOf(generalInfoRequest.getTsIncludesANA()));
        generalInfo.setExamBoard(Integer.valueOf(generalInfoRequest.getExamBoard()));
        generalInfo.setExamBoardOther(generalInfoRequest.getExamBoardOther());

        XMLGregorianCalendar tsDateLastUpdate = sharedMapper.dateToXMLGregorianCalendar(generalInfoRequest.getTsDateLastUpdate());
        generalInfo.setTSDateLastUpdate(tsDateLastUpdate);
        XMLGregorianCalendar lastDBCompact = sharedMapper.dateToXMLGregorianCalendar(generalInfoRequest.getLastDBCompact());
        generalInfo.setLastDBCompact(lastDBCompact);
        XMLGregorianCalendar iqmsLastExpDate = sharedMapper.dateToXMLGregorianCalendar(generalInfoRequest.getIqmsLastExpDate());
        generalInfo.setIQMSLastExpDate(iqmsLastExpDate);
        XMLGregorianCalendar iqmsLastImpDate = sharedMapper.dateToXMLGregorianCalendar(generalInfoRequest.getIqmsLastImpDate());
        generalInfo.setIQMSLastImpDate(iqmsLastImpDate);

        return generalInfo;
    }


}
