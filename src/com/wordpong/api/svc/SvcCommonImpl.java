package com.wordpong.api.svc;

import java.util.logging.Logger;

import com.google.appengine.api.capabilities.CapabilitiesService;
import com.google.appengine.api.capabilities.CapabilitiesServiceFactory;
import com.google.appengine.api.capabilities.Capability;
import com.google.appengine.api.capabilities.CapabilityState;
import com.google.appengine.api.capabilities.CapabilityStatus;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.users.UserServiceFactory;

public class SvcCommonImpl implements SvcCommon {
    private static final Logger log = Logger.getLogger(SvcCommonImpl.class.getName());

    public SvcCommonImpl() {
    }

    @Override
    public void clearCacheAll() {
        MemcacheServiceFactory.getMemcacheService().clearAll();
    }

    public boolean isLoggedIn() {
        return UserServiceFactory.getUserService().isUserLoggedIn();
    }

    public boolean isUserAdmin() {
        return isLoggedIn() && UserServiceFactory.getUserService().isUserAdmin();
    }

    public String getLogoutUrl(String baseUrl) {
        return UserServiceFactory.getUserService().createLogoutURL(baseUrl);
    }

    @Override
    public boolean isDatastoreUp() {
        CapabilityStatus status = CapabilityStatus.DISABLED;
        try {
            CapabilitiesService cs = CapabilitiesServiceFactory.getCapabilitiesService();
            CapabilityState state = cs.getStatus(Capability.DATASTORE_WRITE);
            status = state.getStatus();
        } catch (Throwable t) {
        }
        boolean result = status == CapabilityStatus.ENABLED;
        if (result == false) {
            log.warning("Datastore is down");
        }
        return result;
    }
}
