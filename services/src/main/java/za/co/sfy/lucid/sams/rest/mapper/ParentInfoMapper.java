package za.co.sfy.lucid.sams.rest.mapper;

import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.ParentInfoRequest;
import za.co.sfy.sams.lucid.schema.ParentInfo;

import javax.xml.datatype.XMLGregorianCalendar;

public class ParentInfoMapper {

    private final SharedMapper sharedMapper;

    public ParentInfoMapper(SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public ParentInfo ParentInfoRequestToParentInfo(ParentInfoRequest parentInfoRequest) throws LucidSamsExecutionException {

        ParentInfo parentInfo = new ParentInfo();

        parentInfo.setAccPayer(parentInfoRequest.getAccPayer());
        XMLGregorianCalendar archiveDate = sharedMapper.dateToXMLGregorianCalendar(parentInfoRequest.getArchiveDate());
        parentInfo.setArchiveDate(archiveDate);
        parentInfo.setArchiveReason(parentInfoRequest.getArchiveReason());
        parentInfo.setBirthDate(parentInfoRequest.getBirthDate());
        parentInfo.setCorrSurname(parentInfoRequest.getCorrSurname());
        parentInfo.setCorrTitle(parentInfoRequest.getCorrTitle());
        parentInfo.setCustodial(parentInfoRequest.getCustodial());
        parentInfo.setEMail(parentInfoRequest.geteMail());
        parentInfo.setEmployer(parentInfoRequest.getEmployer());
        parentInfo.setFaxCode(parentInfoRequest.getFaxCode());
        parentInfo.setFaxNo(parentInfoRequest.getFaxNo());
        parentInfo.setFName(parentInfoRequest.getfName());
        parentInfo.setGender(parentInfoRequest.getGender());
        parentInfo.setGovBody(parentInfoRequest.getGovBody());
        parentInfo.setHomelanguage(parentInfoRequest.getHomelanguage());
//      parentInfo.setID(parentInfoRequest.getId());
        parentInfo.setIDNumber(parentInfoRequest.getIdNumber());
        parentInfo.setInitials(parentInfoRequest.getInitials());
        parentInfo.setMaritalstatus(parentInfoRequest.getMaritalstatus());
        parentInfo.setOccupation(parentInfoRequest.getOccupation());
        parentInfo.setParentID(parentInfoRequest.getParentID());
        parentInfo.setParentsAss(parentInfoRequest.getParentsAss());
        parentInfo.setPostalAddress1(parentInfoRequest.getPostalAddress1());
        parentInfo.setPostalAddress2(parentInfoRequest.getPostalAddress2());
        parentInfo.setPostalAddress3(parentInfoRequest.getPostalAddress3());
        parentInfo.setPostalCode(parentInfoRequest.getPostalCode());
        parentInfo.setPoverty(parentInfoRequest.getPoverty());
        parentInfo.setRace(parentInfoRequest.getRace());
        parentInfo.setReasonNoID(parentInfoRequest.getReasonNoID());
        parentInfo.setReligion(parentInfoRequest.getReligion());
        parentInfo.setRelship(parentInfoRequest.getRelship());
        parentInfo.setSName(parentInfoRequest.getReligion());
        parentInfo.setSpouse(parentInfoRequest.getSpouse());
        parentInfo.setSpouseCell(parentInfoRequest.getSpouseCell());
        parentInfo.setSpouseEmail(parentInfoRequest.getSpouseEmail());
        parentInfo.setSpouseFname(parentInfoRequest.getSpouseFname());
        parentInfo.setSpouseGender(parentInfoRequest.getSpouseGender());
        parentInfo.setSpouseID(parentInfoRequest.getSpouseFname());
        parentInfo.setSpouseOccupation(parentInfoRequest.getSpouseOccupation());
        parentInfo.setSpouseWorkTel(parentInfoRequest.getSpouseWorkTel());
        parentInfo.setStatus(parentInfoRequest.getStatus());
        parentInfo.setStreetAddress1(parentInfoRequest.getStreetAddress1());
        parentInfo.setStreetAddress2(parentInfoRequest.getStreetAddress2());
        parentInfo.setStreetAddress3(parentInfoRequest.getStreetAddress1());
        parentInfo.setStreetCode(parentInfoRequest.getStreetCode());
        parentInfo.setTel1(parentInfoRequest.getTel1());
        parentInfo.setTel1Code(parentInfoRequest.getTel1Code());
        parentInfo.setTel2(parentInfoRequest.getTel1());
        parentInfo.setTel2Code(parentInfoRequest.getTel1Code());
        parentInfo.setTel3(parentInfoRequest.getTel1());
        parentInfo.setTel3Code(parentInfoRequest.getTel3Code());
        parentInfo.setTitle(parentInfoRequest.getTitle());

        return parentInfo;
    }
}
