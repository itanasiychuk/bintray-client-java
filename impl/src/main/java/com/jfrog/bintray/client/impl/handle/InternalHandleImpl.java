package com.jfrog.bintray.client.impl.handle;

import com.jfrog.bintray.client.api.handle.ConnectionHandle;
import com.jfrog.bintray.client.api.handle.InternalHandle;
import com.jfrog.bintray.client.api.handle.SystemInfoHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jfrog.bintray.client.impl.handle.ConnectionHandleImpl.ConnectionType.ARTIFACTORY;
import static com.jfrog.bintray.client.impl.handle.ConnectionHandleImpl.ConnectionType.EDGE;

/**
 * @author Ihor Tanasiychuk
 */
public class InternalHandleImpl implements InternalHandle {
    private static final Logger log = LoggerFactory.getLogger(InternalHandleImpl.class);

    private BintrayImpl bintrayHandle;

    InternalHandleImpl(BintrayImpl bintrayHandle) {
        this.bintrayHandle = bintrayHandle;
    }

    public SystemInfoHandle systemInfo() {
        return new SystemInfoHandleImpl(bintrayHandle);
    }

    public ConnectionHandle artifactories(Integer hours) {
        return new ConnectionHandleImpl(bintrayHandle, ARTIFACTORY, hours);
    }

    public ConnectionHandle edges(Integer hours) {
        return new ConnectionHandleImpl(bintrayHandle, EDGE, hours);
    }
}
