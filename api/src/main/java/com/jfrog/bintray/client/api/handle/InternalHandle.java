package com.jfrog.bintray.client.api.handle;

/**
 * @author Ihor Tanasiychuk
 */
public interface InternalHandle {
    SystemInfoHandle systemInfo();
    ConnectionHandle artifactories(Integer hours);
    ConnectionHandle edges(Integer hours);
}
