package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;
import za.co.sfy.lucid.sams.resource.connection.EdusolStrucDatabaseConnectionManager;
import za.co.sfy.lucid.sams.resource.util.DateUtil;
import za.co.sfy.sams.lucid.schema.LearningBarriers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class LearningBarriersResource extends AbstractLucidSAMSResource implements ILucidSAMSResource {
    private final String TABLE_NAME = "LearningBarriers";
    private final DateUtil dateUtil = new DateUtil();

    public LearningBarriersResource(EdusolStrucDatabaseConnectionManager edusolStrucDatabaseConnectionManagerAbstractDatabaseConnectionManager) throws LucidSamsExecutionException {
        super(edusolStrucDatabaseConnectionManagerAbstractDatabaseConnectionManager);
    }


    @Override
    public PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException {
        LearningBarriers learningBarriers = (LearningBarriers) object;
        String sql = "INSERT INTO " + TABLE_NAME + "(Date,Learnerid,Comment,Barriercode,ActionCode) " + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, dateUtil.getSQLDate(learningBarriers.getDate()));
            preparedStatement.setInt(2, learningBarriers.getLearnerid());
            preparedStatement.setString(3, learningBarriers.getComment());
            preparedStatement.setInt(4, learningBarriers.getBarriercode());
            preparedStatement.setInt(5, learningBarriers.getActionCode());

            return preparedStatement;

        } catch (SQLException exception) {
            throw new LucidSamsExecutionException("Failed to retrieve save prepared statement ", exception);
        }
    }

    @Override
    public PreparedStatement retrieve(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public PreparedStatement update(Connection connection, Object object) throws LucidSamsExecutionException {
        return null;
    }

    @Override
    public String getTABLE_NAME() {
        return null;
    }
}
