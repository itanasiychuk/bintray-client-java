package com.jfrog.bintray.client.api.model;

/**
 * @author Ihor Tanasiychuk
 */
public interface SystemInfo {

    String getType();

    Integer getVersion();

    String getDefaultOrganization();

    String getStatus();
}
