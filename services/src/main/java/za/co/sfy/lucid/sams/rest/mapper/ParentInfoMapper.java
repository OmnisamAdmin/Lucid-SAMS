package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.sams.vo.ParentInfoRequest;
import za.co.sfy.sams.lucid.schema.ParentInfo;

/**
 * @author muzim
 */
@Component
public class ParentInfoMapper {

    private final SharedMapper sharedMapper;

    public ParentInfoMapper(SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public ParentInfo ParentInfoRequestToParentInfo(ParentInfoRequest parentInfoRequest)
            throws LucidSamsExecutionException {

        ParentInfo parentInfo = new ParentInfo();

            String accPayer = parentInfoRequest.getAccPayer();
            if (null != accPayer) {
                parentInfo.setAccPayer(parentInfoRequest.getAccPayer());
            }

            String archiveDate = parentInfoRequest.getArchiveDate();
            if (null != archiveDate) {
                parentInfo.setArchiveDate(sharedMapper.dateToXMLGregorianCalendar(archiveDate));
            }

            String archiveReason = parentInfoRequest.getArchiveReason();
            if (null != archiveReason) {
                parentInfo.setArchiveReason(parentInfoRequest.getArchiveReason());
            }

            String birthDate = parentInfoRequest.getBirthDate();
            if (null != birthDate) {
                parentInfo.setBirthDate(parentInfoRequest.getBirthDate());
            }

            String corrSurname = parentInfoRequest.getCorrSurname();
            if (null != corrSurname) {
                parentInfo.setCorrSurname(parentInfoRequest.getCorrSurname());
            }

            String corrTitle = parentInfoRequest.getCorrTitle();
            if (null != corrTitle) {
                parentInfo.setCorrTitle(parentInfoRequest.getCorrTitle());

            }
            String custodial = parentInfoRequest.getCustodial();
            if (null != custodial) {
                parentInfo.setCustodial(parentInfoRequest.getCustodial());
            }

            String eMail = parentInfoRequest.geteMail();
            if (null != eMail) {
                parentInfo.setEMail(parentInfoRequest.geteMail());
            }

            String employer = parentInfoRequest.getEmployer();
            if (null != employer) {
                parentInfo.setEmployer(parentInfoRequest.getEmployer());
            }

            String faxCode = parentInfoRequest.getFaxCode();
            if (null != faxCode) {
                parentInfo.setFaxCode(parentInfoRequest.getFaxCode());

            }

            String faxNo = parentInfoRequest.getFaxNo();
            if (null != faxNo) {
                parentInfo.setFaxNo(parentInfoRequest.getFaxNo());
            }

            String fName = parentInfoRequest.getfName();
            if (null != fName) {
                parentInfo.setFName(parentInfoRequest.getfName());
            }

            String gender = parentInfoRequest.getGender();
            if (null != gender) {
                parentInfo.setGender(parentInfoRequest.getGender());
            }
            String govBody = parentInfoRequest.getGovBody();
            if (null != govBody) {
                parentInfo.setGovBody(parentInfoRequest.getGovBody());
            }

            String homelanguage = parentInfoRequest.getHomelanguage();
            if (null != homelanguage) {
                parentInfo.setHomelanguage(parentInfoRequest.getHomelanguage());
            }

            String id = parentInfoRequest.getId();
            if (null != id) {
                parentInfo.setID(parentInfoRequest.getId());
            }

            String idNumber = parentInfoRequest.getIdNumber();
            if (null != idNumber) {
                parentInfo.setIDNumber(parentInfoRequest.getIdNumber());

            }

            String initials = parentInfoRequest.getInitials();
            if (null != initials) {
                parentInfo.setInitials(parentInfoRequest.getInitials());

            }

            String maritalstatus = parentInfoRequest.getMaritalstatus();
            if (null != maritalstatus) {
                parentInfo.setMaritalstatus(parentInfoRequest.getMaritalstatus());
            }

            String occupation = parentInfoRequest.getOccupation();
            if (null != occupation) {
                parentInfo.setOccupation(parentInfoRequest.getOccupation());
            }
            Integer parentID = parentInfoRequest.getParentID();
            if (null != parentID) {
                parentInfo.setParentID(parentID);
            } else {
                parentInfo.setParentID(0);
            }

            String parentsAss = parentInfoRequest.getParentsAss();
            if (null != parentsAss) {
                parentInfo.setParentsAss(parentInfoRequest.getParentsAss());

            }

            String postalAddress1 = parentInfoRequest.getPostalAddress1();
            if (null != postalAddress1) {
                parentInfo.setPostalAddress1(parentInfoRequest.getPostalAddress1());
            }

            String postalAddress2 = parentInfoRequest.getPostalAddress2();
            if (null != postalAddress2) {
                parentInfo.setPostalAddress2(parentInfoRequest.getPostalAddress2());

            }

            String postalAddress3 = parentInfoRequest.getPostalAddress3();
            if (null != postalAddress3) {
                parentInfo.setPostalAddress3(parentInfoRequest.getPostalAddress3());

            }
            String postalCode = parentInfoRequest.getPostalCode();
            if (null != postalCode) {
                parentInfo.setPostalCode(parentInfoRequest.getPostalCode());

            }

            String poverty = parentInfoRequest.getPoverty();
            if (null != poverty) {
                parentInfo.setPoverty(parentInfoRequest.getPoverty());

            }

            String race = parentInfoRequest.getRace();
            if (null != race) {
                parentInfo.setRace(parentInfoRequest.getRace());

            }

            String reasonNoID = parentInfoRequest.getReasonNoID();
            if (null != reasonNoID) {
                parentInfo.setReasonNoID(parentInfoRequest.getReasonNoID());
            }

            String religion = parentInfoRequest.getReligion();
            if (null != religion) {
                parentInfo.setReligion(parentInfoRequest.getReligion());

            }

            String relship = parentInfoRequest.getRelship();
            if (null != relship) {
                parentInfoRequest.setRelship(parentInfoRequest.getRelship());
            }
            String sName = parentInfoRequest.getsName();
            if (null != sName) {
                parentInfo.setSName(parentInfoRequest.getsName());
            }

            String spouse = parentInfoRequest.getSpouse();
            if (null != spouse) {
                parentInfo.setSpouse(parentInfoRequest.getSpouse());

            }

            String spouseCell = parentInfoRequest.getSpouseCell();
            if (null != spouseCell) {
                parentInfo.setSpouseCell(parentInfoRequest.getSpouseCell());

            }

            String spouseEmail = parentInfoRequest.getSpouseEmail();
            if (null != spouseEmail) {
                parentInfo.setSpouseEmail(parentInfoRequest.getSpouseEmail());

            }

            String spouseFname = parentInfoRequest.getSpouseFname();
            if (null != spouseFname) {
                parentInfo.setSpouseFname(parentInfoRequest.getSpouseFname());

            }

            String spouseGender = parentInfoRequest.getSpouseGender();
            if (null != spouseGender) {
                parentInfo.setSpouseGender(parentInfoRequest.getSpouseGender());

            }
            String spouseID = parentInfoRequest.getSpouseID();
            if (null != spouseID) {
                parentInfo.setSpouseID(spouse);

            }

            String spouseOccupation = parentInfoRequest.getSpouseOccupation();
            if (null != spouseOccupation) {
                parentInfo.setSpouseOccupation(parentInfoRequest.getSpouseOccupation());

            }

            String spouseWorkTel = parentInfoRequest.getSpouseWorkTel();
            if (null != spouseWorkTel) {
                parentInfo.setSpouseWorkTel(parentInfoRequest.getSpouseWorkTel());

            }

            String status = parentInfoRequest.getStatus();
            if (null != status) {
                parentInfo.setStatus(parentInfoRequest.getStatus());

            }

            String streetAddress1 = parentInfoRequest.getStreetAddress1();
            if (null != streetAddress1) {
                parentInfo.setStreetAddress1(parentInfoRequest.getStreetAddress1());

            }

            String streetAddress2 = parentInfoRequest.getStreetAddress2();
            if (null != streetAddress2) {
                parentInfo.setStreetAddress2(parentInfoRequest.getStreetAddress2());

            }
            String streetAddress3 = parentInfoRequest.getStreetAddress3();
            if (null != streetAddress3) {
                parentInfo.setStreetAddress3(parentInfoRequest.getStreetAddress3());

            }

            String streetCode = parentInfoRequest.getStreetCode();
            if (null != streetCode) {
                parentInfo.setStreetCode(parentInfoRequest.getStreetCode());

            }

            String tel1 = parentInfoRequest.getTel1();
            if (null != tel1) {
                parentInfo.setTel1(parentInfoRequest.getTel1());

            }

            String tel1Code = parentInfoRequest.getTel1Code();
            if (null != tel1Code) {
                parentInfo.setTel1Code(parentInfoRequest.getTel1Code());

            }

            String tel2 = parentInfoRequest.getTel2();
            if (null != tel2) {
                parentInfo.setTel2(parentInfoRequest.getTel2());
            }

            String tel2Code = parentInfoRequest.getTel2Code();
            if (null != tel2Code) {
                parentInfo.setTel2Code(parentInfoRequest.getTel2Code());
            }
            String tel3 = parentInfoRequest.getTel3();
            if (null != tel3) {
                parentInfo.setTel3(parentInfoRequest.getTel3());
            }

            String tel3Code = parentInfoRequest.getTel3Code();
            if (null != tel3Code) {
                parentInfo.setTel3Code(parentInfoRequest.getTel3Code());

            }

            String title = parentInfoRequest.getTitle();
            if (null != title) {

                parentInfo.setTitle(parentInfoRequest.getTitle());
            }

            return parentInfo;

    }
}