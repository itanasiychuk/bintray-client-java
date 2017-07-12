package com.jfrog.bintray.client.impl.model;

import com.jfrog.bintray.client.api.details.ConnectionDetails;
import com.jfrog.bintray.client.api.model.Connection;

/**
 * @author Ihor Tanasiychuk
 */
public class ConnectionImpl implements Connection {
    private String url;
    private String serviceId;

    public ConnectionImpl() {
    }

    public ConnectionImpl(ConnectionDetails connectionDetails) {
        this.url = connectionDetails.getUrl();
        this.serviceId = connectionDetails.getServiceId();
    }

    public ConnectionImpl(String url, String serviceId) {
        this.url = url;
        this.serviceId = serviceId;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }
}
