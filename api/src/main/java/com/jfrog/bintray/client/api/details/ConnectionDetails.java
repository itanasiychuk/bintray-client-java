package com.jfrog.bintray.client.api.details;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This class is used to serialize and deserialize the needed json to
 * pass to or receive from Bintray when performing actions on a connection
 *
 * @author Ihor Tanasiychuk
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectionDetails {
    @JsonProperty("url")
    String url;
    @JsonProperty("serviceId")
    String serviceId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
