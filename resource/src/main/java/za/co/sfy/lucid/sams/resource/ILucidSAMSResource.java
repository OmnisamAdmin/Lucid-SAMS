package za.co.sfy.lucid.sams.resource;

import za.co.sfy.lucid.sams.domain.exception.LucidSamsExecutionException;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author muzim
 * <p>
 * Allows for different implementations of setting up a prepared statement for saves,updates and retrievals
 */
public interface ILucidSAMSResource {

    PreparedStatement save(Connection connection, Object object) throws LucidSamsExecutionException;

    PreparedStatement retrieve(Connection connection, Object object) throws LucidSamsExecutionException;

    PreparedStatement update(Connection connection, Object object) throws LucidSamsExecutionException;

    String getTABLE_NAME();
}
