package za.co.sfy.lucid.sams.rest.mapper;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.rest.vo.data.writer.EducatorsRequest;
import za.co.sfy.sams.lucid.schema.Educators;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class EducatorsMapper {

    private final SharedMapper sharedMapper;

    public EducatorsMapper(final SharedMapper sharedMapper) {
        this.sharedMapper = sharedMapper;
    }

    public Educators educatorsRequestToEducators(EducatorsRequest educatorsRequest) throws LucidSamsExecutionException {
        Educators educators = new Educators();

        Integer edID = educatorsRequest.getEdID();
        if (edID != null) {
            educators.setEdID(edID);
        }
        String fName = educatorsRequest.getfName();
        if (fName != null) {
            educators.setFName(fName);
        }
        String sName = educatorsRequest.getsName();
        if (sName != null) {
            educators.setSName(sName);
        }
        String initials = educatorsRequest.getInitials();
        if (initials != null) {
            educators.setInitials(initials);
        }
        String key = educatorsRequest.getKey();
        if (key != null) {
            educators.setKey(key);
        }
        String address1 = educatorsRequest.getAddress1();
        if (address1 != null) {
            educators.setAddress1(address1);
        }
        String address2 = educatorsRequest.getAddress2();
        if (address2 != null) {
            educators.setAddress2(address2);
        }
        String address3 = educatorsRequest.getAddress3();
        if (address3 != null) {
            educators.setAddress3(address3);
        }
        String code = educatorsRequest.getCode();
        if (code != null) {
            educators.setCode(code);
        }
        String tel1Code = educatorsRequest.getTel1Code();
        if (tel1Code != null) {
            educators.setTel1Code(tel1Code);
        }
        String tel1 = educatorsRequest.getTel1();
        if (tel1 != null) {
            educators.setTel1(tel1);
        }
        String birthDate = educatorsRequest.getBirthDate();
        if (birthDate != null) {
            educators.setBirthDate(birthDate);
        }
        String idNumber = educatorsRequest.getIdNumber();
        if (idNumber != null) {
            educators.setIDNumber(idNumber);
        }
        String depCode = educatorsRequest.getDepCode();
        if (depCode != null) {
            educators.setDepCode(depCode);
        }
        String subsidies = educatorsRequest.getSubsidies();
        if (subsidies != null) {
            educators.setSubsidies(subsidies);
        }
        String medName = educatorsRequest.getMedName();
        if (medName != null) {
            educators.setMedName(medName);
        }
        String medNo = educatorsRequest.getMedNo();
        if (medNo != null) {
            educators.setMedNo(medNo);
        }
        String spouse = educatorsRequest.getSpouse();
        if (spouse != null) {
            educators.setSpouse(spouse);
        }
        String eNumber = educatorsRequest.geteNumber();
        if (eNumber != null) {
            educators.setENumber(eNumber);
        }
        String licenses = educatorsRequest.getLicenses();
        if (licenses != null) {
            educators.setLicenses(licenses);
        }
        String taxNo = educatorsRequest.getTaxNo();
        if (taxNo != null) {
            educators.setTaxNo(taxNo);
        }
        String academic = educatorsRequest.getAcademic();
        if (academic != null) {
            educators.setAcademic(academic);
        }
        String institution = educatorsRequest.getInstitution();
        if (institution != null) {
            educators.setInstitution(institution);
        }
        String skills = educatorsRequest.getSkills();
        if (skills != null) {
            educators.setSkills(skills);
        }
        String dateJoined = educatorsRequest.getDateJoined();
        if (dateJoined != null) {
            educators.setDateJoined(dateJoined);
        }
        String managementPosition = educatorsRequest.getManagementPosition();
        if (managementPosition != null) {
            educators.setManagementPosition(managementPosition);
        }
        String postLevel = educatorsRequest.getPostLevel();
        if (postLevel != null) {
            educators.setPostLevel(postLevel);
        }
        String tel2Code = educatorsRequest.getTel2Code();
        if (tel2Code != null) {
            educators.setTel2Code(tel2Code);
        }
        String tel2 = educatorsRequest.getTel2();
        if (tel2 != null) {
            educators.setTel2(tel2);
        }
        String professional = educatorsRequest.getProfessional();
        if (professional != null) {
            educators.setProfessional(professional);
        }
        String registerClass = educatorsRequest.getRegisterClass();
        if (registerClass != null) {
            educators.setRegisterClass(registerClass);
        }
        String persalNumber = educatorsRequest.getPersalNumber();
        if (persalNumber != null) {
            educators.setPersalNumber(persalNumber);
        }
        String homelanguage = educatorsRequest.getHomelanguage();
        if (homelanguage != null) {
            educators.setHomelanguage(homelanguage);
        }
        String x0032Ndlanguage = educatorsRequest.getX0032Ndlanguage();
        if (x0032Ndlanguage != null) {
            educators.setX0032Ndlanguage(x0032Ndlanguage);
        }
        String race = educatorsRequest.getRace();
        if (race != null) {
            educators.setRace(race);
        }
        String title = educatorsRequest.getTitle();
        if (title != null) {
            educators.setTitle(title);
        }
        String gender = educatorsRequest.getGender();
        if (gender != null) {
            educators.setGender(gender);
        }
        String educatorType = educatorsRequest.getEducatorType();
        if (educatorType != null) {
            educators.setEducatorType(educatorType);
        }
        String maritalStatus = educatorsRequest.getMaritalStatus();
        if (maritalStatus != null) {
            educators.setMaritalStatus(maritalStatus);
        }
        String disabilityStatus = educatorsRequest.getDisabilityStatus();
        if (disabilityStatus != null) {
            educators.setDisabilityStatus(disabilityStatus);
        }
        String actual = educatorsRequest.getActual();
        if (actual != null) {
            educators.setActual(actual);
        }
        String acting = educatorsRequest.getActing();
        if (acting != null) {
            educators.setActing(acting);
        }
        String natureofApointment = educatorsRequest.getNatureofApointment();
        if (natureofApointment != null) {
            educators.setNatureofApointment(natureofApointment);
        }
        String remuneration = educatorsRequest.getRemuneration();
        if (remuneration != null) {
            educators.setRemuneration(remuneration);
        }
        String qualification = educatorsRequest.getQualification();
        if (qualification != null) {
            educators.setQualification(qualification);
        }
        String qualificationType = educatorsRequest.getQualificationType();
        if (qualificationType != null) {
            educators.setQualificationType(qualificationType);
        }
        String preGradeR = educatorsRequest.getPreGradeR();
        if (preGradeR != null) {
            educators.setPreGradeR(preGradeR);
        }
        String secondary = educatorsRequest.getSecondary();
        if (secondary != null) {
            educators.setSecondary(secondary);
        }
        String gradeR = educatorsRequest.getGradeR();
        if (gradeR != null) {
            educators.setGradeR(gradeR);
        }
        String primary = educatorsRequest.getPrimary();
        if (primary != null) {
            educators.setPrimary(primary);
        }
        String lsen = educatorsRequest.getLsen();
        if (lsen != null) {
            educators.setLSEN(lsen);
        }
        String academicDegree = educatorsRequest.getAcademicDegree();
        if (academicDegree != null) {
            educators.setAcademicDegree(academicDegree);
        }
        String professionalDegree = educatorsRequest.getProfessionalDegree();
        if (professionalDegree != null) {
            educators.setProfessionalDegree(professionalDegree);
        }
        String technicalCerDip = educatorsRequest.getTechnicalCerDip();
        if (technicalCerDip != null) {
            educators.setTechnicalCerDip(technicalCerDip);
        }
        String professionalDiploma = educatorsRequest.getProfessionalDiploma();
        if (professionalDiploma != null) {
            educators.setProfessionalDiploma(professionalDiploma);
        }
        Integer yearsExperience = educatorsRequest.getYearsExperience();
        if (yearsExperience != null) {
            educators.setYearsExperience(yearsExperience);
        }
        String time = educatorsRequest.getTime();
        if (time != null) {
            educators.setTime(time);
        }
        String instructionLanguage = educatorsRequest.getInstructionLanguage();
        if (instructionLanguage != null) {
            educators.setInstructionLanguage(instructionLanguage);
        }
        String status = educatorsRequest.getStatus();
        if (status != null) {
            educators.setStatus(status);
        }
        String sace = educatorsRequest.getSace();
        if (sace != null) {
            educators.setSACE(sace);
        }
        Integer wcType = educatorsRequest.getWcType();
        if (wcType != null) {
            educators.setWCType(wcType);
        }
        String emailAddress = educatorsRequest.getEmailAddress();
        if (emailAddress != null) {
            educators.setEmailAddress(emailAddress);
        }
        String ictSkill = educatorsRequest.getIctSkill();
        if (ictSkill != null) {
            educators.setICTSkill(ictSkill);
        }
        String ictUsage = educatorsRequest.getIctUsage();
        if (ictUsage != null) {
            educators.setICTUsage(ictUsage);
        }
        String country = educatorsRequest.getCountry();
        if (country != null) {
            educators.setCountry(country);
        }
        String photoname = educatorsRequest.getPhotoname();
        if (photoname != null) {
            educators.setPhotoname(photoname);
        }
        String intermediate = educatorsRequest.getIntermediate();
        if (intermediate != null) {
            educators.setIntermediate(intermediate);
        }
        Integer luritsNumber = educatorsRequest.getLuritsNumber();
        if (luritsNumber != null) {
            educators.setLuritsNumber(luritsNumber);
        }
        Integer tsTransactionCategory = educatorsRequest.getTsTransactionCategory();
        if (tsTransactionCategory != null) {
            educators.setTSTransactionCategory(tsTransactionCategory);
        }
        Integer tsStatusFlag = educatorsRequest.getTsStatusFlag();
        if (tsStatusFlag != null) {
            educators.setTSStatusFlag(tsStatusFlag);
        }
        Integer tsReportStatusFlag = educatorsRequest.getTsReportStatusFlag();
        if (tsReportStatusFlag != null) {
            educators.setTSReportStatusFlag(tsReportStatusFlag);
        }
        Integer tsReasonCode = educatorsRequest.getTsReasonCode();
        if (tsReasonCode != null) {
            educators.setTSReasonCode(tsReasonCode);
        }
        Integer luritsIndicator = educatorsRequest.getLuritsIndicator();
        if (luritsIndicator != null) {
            educators.setLuritsIndicator(luritsIndicator);
        }
        Integer luritsFlag = educatorsRequest.getLuritsFlag();
        if (luritsFlag != null) {
            educators.setLuritsFlag(luritsFlag);
        }
        String tsSentFileName = educatorsRequest.getTsSentFileName();
        if (tsSentFileName != null) {
            educators.setTSSentFileName(tsSentFileName);
        }
        String tsDateLastUpdate = educatorsRequest.getTsDateLastUpdate();
        if (tsDateLastUpdate != null) {
            XMLGregorianCalendar convertedTSDateLastUpdate = sharedMapper.dateToXMLGregorianCalendar(tsDateLastUpdate);
            educators.setTSDateLastUpdate(convertedTSDateLastUpdate);
        }
        String tsLastUpdatedBy = educatorsRequest.getTsLastUpdatedBy();
        if (tsLastUpdatedBy != null) {
            educators.setTSLastUpdatedBy(tsLastUpdatedBy);
        }
        String luritsStatus = educatorsRequest.getLuritsStatus();
        if (luritsStatus != null) {
            educators.setLuritsStatus(luritsStatus);
        }
        String kinSName = educatorsRequest.getKinSName();
        if (kinSName != null) {
            educators.setKinSName(kinSName);
        }
        String kinFName = educatorsRequest.getKinFName();
        if (kinFName != null) {
            educators.setKinFName(kinFName);
        }
        Short saCitizen = educatorsRequest.getSaCitizen();
        if (saCitizen != null) {
            educators.setSACitizen(saCitizen);
        }
        Short workPermit = educatorsRequest.getWorkPermit();
        if (workPermit != null) {
            educators.setWorkPermit(workPermit);
        }
        String workPermitNo = educatorsRequest.getWorkPermitNo();
        if (workPermitNo != null) {
            educators.setWorkPermitNo(workPermitNo);
        }
        String workPermitDate = educatorsRequest.getWorkPermitDate();
        if (workPermitDate != null) {
            educators.setWorkPermitDate(workPermitDate);
        }
        String prevSName = educatorsRequest.getPrevSName();
        if (prevSName != null) {
            educators.setPrevSName(prevSName);
        }
        String compUsage = educatorsRequest.getCompUsage();
        if (compUsage != null) {
            educators.setCompUsage(compUsage);
        }
        Short reasonForNoSACE = educatorsRequest.getReasonForNoSACE();
        if (reasonForNoSACE != null) {
            educators.setReasonForNoSACE(reasonForNoSACE);
        }
        String unionName = educatorsRequest.getUnionName();
        if (unionName != null) {
            educators.setUnionName(unionName);
        }
        String unionNo = educatorsRequest.getUnionNo();
        if (unionNo != null) {
            educators.setUnionNo(unionNo);
        }
        String unionName2 = educatorsRequest.getUnionName2();
        if (unionName2 != null) {
            educators.setUnionName2(unionName2);
        }
        String unionNo2 = educatorsRequest.getUnionNo2();
        if (unionNo2 != null) {
            educators.setUnionNo2(unionNo2);
        }
        String unionNameX = educatorsRequest.getUnionNameX();
        if (unionNameX != null) {
            educators.setUnionNameX(unionNameX);
        }
        String unionNoX = educatorsRequest.getUnionNoX();
        if (unionNoX != null) {
            educators.setUnionNoX(unionNoX);
        }
        String religion = educatorsRequest.getReligion();
        if (religion != null) {
            educators.setReligion(religion);
        }
        String foreignID = educatorsRequest.getForeignID();
        if (foreignID != null) {
            educators.setForeignID(foreignID);
        }
        Integer bursar = educatorsRequest.getBursar();
        if (bursar != null) {
            educators.setBursar(bursar);
        }

        return educators;

    }
}
