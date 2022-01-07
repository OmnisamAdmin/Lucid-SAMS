package za.co.sfy.lucid.sams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import za.co.sfy.lucid.sams.domain.criteria.DataWriterCriteria;
import za.co.sfy.lucid.sams.domain.data.writer.DataWriter;

import java.util.List;

public interface DataWriterRepository extends JpaRepository<DataWriter, Long> {

    @Query(value = "select d from DataWriter d " +
            "where (:#{#dataWriterCriteria.schoolName} is null or d.schoolName = :#{#dataWriterCriteria.schoolName})" +
            "and (:#{#dataWriterCriteria.teacherName} is null or d.teacherName = :#{#dataWriterCriteria.teacherName})" +
            "and d.isDeleted = false")
    List<DataWriter> findDataWriterByCriteria(@Param("dataWriterCriteria") DataWriterCriteria dataWriterCriteria);

}
