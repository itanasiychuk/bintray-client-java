package com.jfrog.bintray.client.impl.model;

import com.jfrog.bintray.client.api.details.SystemInfoDetails;
import com.jfrog.bintray.client.api.model.SystemInfo;

/**
 * @author Ihor Tanasiychuk
 */
public class SystemInfoImpl implements SystemInfo {
    private String type;
    private Integer version;
    private String defaultOrganization;
    private String status;

    public SystemInfoImpl() {
    }

    public SystemInfoImpl(SystemInfoDetails systemInfoDetails) {
        this.type = systemInfoDetails.getType();
        this.version = systemInfoDetails.getVersion();
        this.defaultOrganization = systemInfoDetails.getDefaultOrganization();
        this.status = systemInfoDetails.getStatus();
    }

    public SystemInfoImpl(String type, Integer version, String defaultOrganization, String status) {
        this.type = type;
        this.version = version;
        this.defaultOrganization = defaultOrganization;
        this.status = status;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public String getDefaultOrganization() {
        return defaultOrganization;
    }

    @Override
    public String getStatus() {
        return status;
    }
}
