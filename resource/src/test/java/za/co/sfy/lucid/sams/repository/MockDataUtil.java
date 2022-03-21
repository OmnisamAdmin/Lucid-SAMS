package za.co.sfy.lucid.sams.repository;

import za.co.sfy.sams.lucid.schema.Classes;
import za.co.sfy.sams.lucid.schema.CycleInfo;
import za.co.sfy.sams.lucid.schema.GeneralInfo;
import za.co.sfy.sams.lucid.schema.LearnerInfo;

public class MockDataUtil {

    public LearnerInfo mockLearnerInfo() {
        LearnerInfo learnerInfo = new LearnerInfo();
        learnerInfo.setLearnerID("3332");
        learnerInfo.setAccessionNo("3332");
        learnerInfo.setTheDate("2022/03/25");
        learnerInfo.setSName("Malaza");
        learnerInfo.setFName("Muzikayise");
        learnerInfo.setNickName("muzi");
        learnerInfo.setBirthDate("19990504");
        learnerInfo.setIDNo("9905045800084");
        learnerInfo.setGender("Male");
        learnerInfo.setHomeLanguage(2);
        learnerInfo.setInstructionLanguage(2);
        learnerInfo.setPreferredLanguage(2);
        learnerInfo.setAddress1("");
        learnerInfo.setAddress2("");
        learnerInfo.setAddress3("");
        learnerInfo.setAddressCode("2007");
        learnerInfo.setGuardian("");
        learnerInfo.setTel1Code("");
        learnerInfo.setTel1("0614102557");
        learnerInfo.setTel2Code("");
        learnerInfo.setTel2("0614102557");
        learnerInfo.setTel3Code("");
        learnerInfo.setTel3("0614102557");
        learnerInfo.setGrade(7);
        learnerInfo.setClazz(5);
        learnerInfo.setGradeYears(1);
        learnerInfo.setPreviousSchoolProvince("");
        learnerInfo.setSchoolAddress1("");
        learnerInfo.setSchoolAddress2("");
        learnerInfo.setSchoolAddress3("");
        learnerInfo.setSchoolCode("");
        learnerInfo.setReligion("");
        learnerInfo.setDisciplinary("");
        learnerInfo.setMedicalConditions("");
        learnerInfo.setDrInfo("");
        learnerInfo.setMedicalAidName("");
        learnerInfo.setMedicalAidNo("");
        learnerInfo.setMedicalAidMember("");
        learnerInfo.setGuidance("");
        learnerInfo.setInitials("MS");
        learnerInfo.setCitizenship("SA Citizen");
        learnerInfo.setProvincial("");
        learnerInfo.setSchoolProvince("");
        learnerInfo.setPreviousSchool("Gauteng");
        learnerInfo.setAssignClass(true);
        learnerInfo.setPhysProvince("Gauteng");
        learnerInfo.setRace("African/Black");
        learnerInfo.setTitle("Mr");
        learnerInfo.setPreviousPlacementofSchool(1);
        learnerInfo.setTransport(0);
        learnerInfo.setLSENDisabilities(0);
        learnerInfo.setDateLeft("");
        learnerInfo.setReason("");
        learnerInfo.setLSENStatus(1);
        learnerInfo.setStatus("C");
        learnerInfo.setBoarder(0);
        learnerInfo.setCountryResidence("SA");
        learnerInfo.setProvinceResidence("Gauteng");
        learnerInfo.setFirstProvince(0);
        learnerInfo.setDeceasedParent(0);
        learnerInfo.setSGRegister(0);
        learnerInfo.setSGReceive(0);
        learnerInfo.setDrName("");
        learnerInfo.setDrTel("");
        learnerInfo.setDexterity(1);
        learnerInfo.setPSNP(2);
        learnerInfo.setNoFamily(0);
        learnerInfo.setPositionFamily("");
        learnerInfo.setReportLanguage(2);
        learnerInfo.setForeignID("");
        learnerInfo.setLearnerComment("");
        learnerInfo.setPhotoName("");
        learnerInfo.setGradeEntered(7);
        learnerInfo.setGradeLeft(0);
        learnerInfo.setBoarderNumber("");
        learnerInfo.setBoarderHostel("");
        learnerInfo.setThirdName("");
        learnerInfo.setEmail("muzi.malaza@gmail.com");
        learnerInfo.setSocialGrantNo("");
        learnerInfo.setTSTransactionCategory(4);
        learnerInfo.setTSStatusFlag(1);
        learnerInfo.setTSReportStatusFlag(0);
        learnerInfo.setTSReasonCode(0);
        learnerInfo.setLuritsIndicator(0);
        learnerInfo.setLuritsFlag(0);
        learnerInfo.setLuritsNumber(0.0);
        learnerInfo.setTSSentfileName("");
        learnerInfo.setTSDateLastUpdate(null);
        learnerInfo.setTSLastUpdatedBy("");
        learnerInfo.setLearnerName2("");
        learnerInfo.setLearnerName3("");
        learnerInfo.setNameDiacritics("");
        learnerInfo.setOtherHomeLanguage("");
        learnerInfo.setOtherLanguage("");
        learnerInfo.setOtherPreferredLanguage("");
        learnerInfo.setOtherTeachingLanguage("");
        learnerInfo.setLuritsStatus("");
        learnerInfo.setSecondName("");
        learnerInfo.setPastelCode("");
        learnerInfo.setBusRouteId(0);
        learnerInfo.setSubjHL("");
        learnerInfo.setSubjFAL("");
        learnerInfo.setPrevSName("");
        learnerInfo.setPositionFamilyF("");
        learnerInfo.setReasonForNoIDNo((short) 0);
        learnerInfo.setGrantCReg((short) 0);
        learnerInfo.setGrantCReceive((short) 0);
        learnerInfo.setGrantCNo("");
        learnerInfo.setGrant4Reg((short) 0);
        learnerInfo.setGrant4Receive((short) 0);
        learnerInfo.setGrant4No("");
        learnerInfo.setGrant5Reg((short) 0);
        learnerInfo.setGrant5Receive((short) 0);
        learnerInfo.setGrant5No("");
        learnerInfo.setGrant9Reg((short) 0);
        learnerInfo.setGrant9Receive((short) 0);
        learnerInfo.setGrant9No("");
        learnerInfo.setClinicName("");
        learnerInfo.setClinicAccRef("");
        learnerInfo.setClinicTelCode("");
        learnerInfo.setClinicTel("");
        learnerInfo.setSubjLOI("");
        learnerInfo.setHseID(0);
        learnerInfo.setPhaseYears((short) 1);
        learnerInfo.setProgressedToGrade(false);
        learnerInfo.setStudyPermit((short) 0);
        learnerInfo.setStudyPermitNo("");
        learnerInfo.setStudyPermitDate("");
        learnerInfo.setIDNoNotValidating("");
        learnerInfo.setOldMentor("");
        learnerInfo.setLSENAnaInc(false);
        learnerInfo.setLSENAnaHL("");
        learnerInfo.setLSENAnaFAL("");
        learnerInfo.setPreviousPlacementofSchoolYear(2022);
        learnerInfo.setForeignIDType((short) 0);
        learnerInfo.setAgeRuleOverwritten(false);
        learnerInfo.setReasonForNoForeignID((short) 0);
        learnerInfo.setFarmProj("");
        learnerInfo.setRoad2Health(false);
        learnerInfo.setImmunizationCard(false);
        learnerInfo.setICEName("Muzi");
        learnerInfo.setICESurname("Malaza");
        learnerInfo.setICERelation("Father");
        return learnerInfo;
    }

    //Minimal valid data needed for a successful save to the 'general_info' table
    public GeneralInfo mockGeneralInfo() {
        GeneralInfo generalInfo = new GeneralInfo();
        generalInfo.setSchoolName("Bishop Bavin");
        generalInfo.setEmisCode("700160226");
        generalInfo.setProvincialDep("Gauteng");
        generalInfo.setDistrict("GAUTENG EAST");
        generalInfo.setPostalAddressType("Street");
        generalInfo.setPostAddress1("St Georges Road 19");
        generalInfo.setPostAddress3("Johanessburg");
        generalInfo.setPostCode("2007");
        generalInfo.setPostAddress0("St Georges Road");
        generalInfo.setPostAddress0No("19");
        generalInfo.setAddress1("34 Millard Rd Bedfordview");
        generalInfo.setAddress2("Bedfordview");
        generalInfo.setAddress3("Bedfordview");
        generalInfo.setAdminComputers(200);
        generalInfo.setPersalComponent("888844");
        generalInfo.setDoubleShifts("Yes");
        generalInfo.setPSNP(Short.valueOf("1"));
        generalInfo.setSchoolLevel(5);
        generalInfo.setOwnership("Independent");
        generalInfo.setLandOwnership("Church");
        generalInfo.setSGBStatus("21");
        return generalInfo;
    }

    public CycleInfo mockCycleInfo() {
        CycleInfo cycleInfo = new CycleInfo();
        cycleInfo.setFETDays(2);
        cycleInfo.setFETlength(2);
        cycleInfo.setFETPeriods(2);
        cycleInfo.setFETTotal(2);
        cycleInfo.setGETDays(2);
        cycleInfo.setGETLength(2);
        cycleInfo.setGETPeriods(2);
        cycleInfo.setGETTotal(2);
        cycleInfo.setHighestGrade(2);
        cycleInfo.setLowestGrade(2);
        cycleInfo.setLSEN("Yes");
        cycleInfo.setLSENSchool(true);
        cycleInfo.setMultiGrade("Yes");
        cycleInfo.setRemedial("Yes");
        cycleInfo.setRooms(2);
        cycleInfo.setSchoolname("bedford high");
        cycleInfo.setSchoolType((short) 2);
        cycleInfo.setSID("KJI3");
        cycleInfo.setSIDHighestYear(2023);
        cycleInfo.setSIDLowestYear(2010);
        cycleInfo.setSNESpec(4);
        cycleInfo.setSNESpecOther("other");
        return cycleInfo;
    }

    public Classes mockClasses() {
        Classes classes = new Classes();
        classes.setGrade(7);
        classes.setClassName("Math 7A");
        classes.setEdCode("Not assigned");
        classes.setType(1);
        return classes;
    }
}
