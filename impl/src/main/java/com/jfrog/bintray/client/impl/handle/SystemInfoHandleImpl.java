package com.jfrog.bintray.client.impl.handle;

import com.jfrog.bintray.client.api.BintrayCallException;
import com.jfrog.bintray.client.api.ObjectMapperHelper;
import com.jfrog.bintray.client.api.details.SystemInfoDetails;
import com.jfrog.bintray.client.api.handle.SystemInfoHandle;
import com.jfrog.bintray.client.api.model.SystemInfo;
import com.jfrog.bintray.client.impl.model.SystemInfoImpl;

import org.apache.http.HttpResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import static com.jfrog.bintray.client.api.BintrayClientConstatnts.API_SYSTEM_INFORMATION;

/**
 * @author Ihor Tanasiychuk
 */
public class SystemInfoHandleImpl implements SystemInfoHandle {
    private static final Logger log = LoggerFactory.getLogger(SystemInfoHandleImpl.class);

    private BintrayImpl bintrayHandle;

    SystemInfoHandleImpl(BintrayImpl bintrayHandle) {
        this.bintrayHandle = bintrayHandle;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public SystemInfo get() throws IOException, BintrayCallException {
        HttpResponse response = bintrayHandle.get(API_SYSTEM_INFORMATION, null);
        SystemInfoDetails systemInfoDetails;
        InputStream jsonContentStream = response.getEntity().getContent();
        ObjectMapper mapper = ObjectMapperHelper.get();
        try {
            systemInfoDetails = mapper.readValue(jsonContentStream, SystemInfoDetails.class);
        } catch (IOException e) {
              log.error("Can't process the json file: " + e.getMessage());
              throw e;
        }

        return new SystemInfoImpl(systemInfoDetails);
    }
}
