package za.co.sfy.lucid.sams.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest(classes = za.co.sfy.lucid.sams.repository.RecourceTestConfiguration.class)
@RunWith(SpringRunner.class)
public class DataWriterRepositoryTest {


//    @Test
//    public void testCreateChangeIdea() {
//        DataWriter returnedDataWriter = dataWriterRepository.save(dataWriter);
//        Assert.assertNotNull(returnedDataWriter.getSchoolName());
//        Assert.assertNotNull(returnedDataWriter.getId());
//        Assert.assertNotNull(returnedDataWriter.getTeacherName());
//        Assert.assertNotNull(returnedDataWriter.isDeleted());
//
//    }
//
//    @Test
//    public void testFindDataWriterByCriteria() {
//        dataWriterRepository.save(dataWriter);
//
//        DataWriterCriteria dataWriterCriteria = new DataWriterCriteria();
//        dataWriterCriteria.setSchoolName("School Name");
//
//        List<DataWriter> foundDataWriters = dataWriterRepository.findDataWriterByCriteria(dataWriterCriteria);
//        Assert.assertNotNull(foundDataWriters);
//
//        DataWriter dataWriter = foundDataWriters.get(0);
//        Assert.assertEquals("School Name", dataWriter.getSchoolName());
//        Assert.assertEquals("Teacher Name", dataWriter.getTeacherName());
//
//    }
    @Test
    public void jdbcTest() {
        String databaseURL = "jdbc:ucanaccess://e://Java//JavaSE//MsAccess//Contacts.accdb";
    }

}