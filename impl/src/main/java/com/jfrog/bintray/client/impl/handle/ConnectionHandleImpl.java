package com.jfrog.bintray.client.impl.handle;

import com.jfrog.bintray.client.api.BintrayCallException;
import com.jfrog.bintray.client.api.ObjectMapperHelper;
import com.jfrog.bintray.client.api.details.ConnectionDetails;
import com.jfrog.bintray.client.api.handle.ConnectionHandle;
import com.jfrog.bintray.client.api.model.Connection;
import com.jfrog.bintray.client.impl.model.ConnectionImpl;

import org.apache.http.HttpResponse;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import static com.jfrog.bintray.client.api.BintrayClientConstatnts.API_DISTRIBUTION_CONNECTIONS;

/**
 * @author Ihor Tanasiychuk
 */
public class ConnectionHandleImpl implements ConnectionHandle {
    private static final Logger log = LoggerFactory.getLogger(ConnectionHandleImpl.class);

    private static final String HOURS_PARAM = "hours";

    private BintrayImpl bintrayHandle;
    private ConnectionType type;
    private Integer hours;

    ConnectionHandleImpl(BintrayImpl bintrayHandle, ConnectionType type, Integer hours) {
        this.bintrayHandle = bintrayHandle;
        this.type = type;
        this.hours = hours;
    }

    @Override
    public Collection<Connection> get() throws IOException, BintrayCallException {
        HttpResponse response = bintrayHandle.get(getDistributionConnection(), null);
        InputStream jsonContentStream = response.getEntity().getContent();
        try {
            Collection<ConnectionDetails> connectionDetails = ObjectMapperHelper.get().readValue(jsonContentStream,
                new TypeReference<Collection<ConnectionDetails>>(){});

            Collection<Connection> connections = new ArrayList<>();
            for(ConnectionDetails details : connectionDetails) {
                connections.add(new ConnectionImpl(details));
            }

            return connections;
        } catch (IOException e) {
            log.error("Can't process the json file: " + e.getMessage());
            throw e;
        }
    }

    private String getDistributionConnection() {
        StringBuilder sb = new StringBuilder(API_DISTRIBUTION_CONNECTIONS + type.value);
        if (hours != null && hours > 0) {
            sb.append("?" + HOURS_PARAM + "=" + hours.toString());
        }

        return sb.toString();
    }

    @Override
    public String name() {
        return null;
    }

    public enum ConnectionType {
        ARTIFACTORY("artifactories"),
        EDGE("edges");

        private String value;

        ConnectionType(String value) {
            this.value = value;
        }
    }
}
