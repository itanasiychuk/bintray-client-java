package com.jfrog.bintray.client.api.details;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This class is used to serialize and deserialize the needed json to
 * pass to or receive from Bintray when performing actions on a system info
 *
 * @author Ihor Tanasiychuk
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemInfoDetails {
    @JsonProperty("type")
    String type;
    @JsonProperty("version")
    Integer version;
    @JsonProperty("default_organization")
    String defaultOrganization;
    @JsonProperty("status")
    String status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDefaultOrganization() {
        return defaultOrganization;
    }

    public void setDefaultOrganization(String defaultOrganization) {
        this.defaultOrganization = defaultOrganization;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
