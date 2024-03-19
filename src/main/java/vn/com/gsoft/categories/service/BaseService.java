package vn.com.gsoft.categories.service;

import vn.com.gsoft.categories.model.system.Profile;

public interface BaseService {
    Profile getLoggedUser() throws Exception;

}
