package za.co.sfy.lucid.sams.resource;

import org.springframework.stereotype.Component;
import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class SaSamsLearnerResource {

    private static SaSamsDatabaseConnectionFactory saSamsDatabaseConnectionFactory;

    public SaSamsLearnerResource(SaSamsDatabaseConnectionFactory saSamsDatabaseConnectionFactory) {
        this.saSamsDatabaseConnectionFactory = saSamsDatabaseConnectionFactory;
    }

    public void save() throws LucidSamsExecutionException {

        try(Connection databaseConnection = saSamsDatabaseConnectionFactory.createDatabaseConnection()) {

        } catch (SQLException e) {
            throw new LucidSamsExecutionException("Connection factory unable to return a database connection.", e);
        }

    }

}
