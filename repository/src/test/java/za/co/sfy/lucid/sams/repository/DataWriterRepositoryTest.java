package za.co.sfy.lucid.sams.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.sfy.lucid.sams.domain.criteria.DataWriterCriteria;
import za.co.sfy.lucid.sams.domain.data.writer.DataWriter;

import java.util.List;

@SpringBootTest(classes = RepositoriesTestConfiguration.class)
@RunWith(SpringRunner.class)
public class DataWriterRepositoryTest {

    @Autowired
    private DataWriterRepository dataWriterRepository;

    private DataWriter dataWriter;

    @Before
    public void setUpTests() {
        dataWriter = new DataWriter();
        dataWriter.setSchoolName("School Name");
        dataWriter.setTeacherName("Teacher Name");

    }

    @Test
    public void testCreateChangeIdea() {
        DataWriter returnedDataWriter = dataWriterRepository.save(dataWriter);
        Assert.assertNotNull(returnedDataWriter.getSchoolName());
        Assert.assertNotNull(returnedDataWriter.getId());
        Assert.assertNotNull(returnedDataWriter.getTeacherName());
        Assert.assertNotNull(returnedDataWriter.isDeleted());

    }

    @Test
    public void testFindDataWriterByCriteria() {
        dataWriterRepository.save(dataWriter);

        DataWriterCriteria dataWriterCriteria = new DataWriterCriteria();
        dataWriterCriteria.setSchoolName("School Name");

        List<DataWriter> foundDataWriters = dataWriterRepository.findDataWriterByCriteria(dataWriterCriteria);
        Assert.assertNotNull(foundDataWriters);

        DataWriter dataWriter = foundDataWriters.get(0);
        Assert.assertEquals("School Name", dataWriter.getSchoolName());
        Assert.assertEquals("Teacher Name", dataWriter.getTeacherName());

    }
}
