package vn.com.gsoft.categories.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.CachingConstant;
import vn.com.gsoft.categories.constant.UserStatus;
import vn.com.gsoft.categories.entity.Department;
import vn.com.gsoft.categories.entity.User;
import vn.com.gsoft.categories.model.system.Profile;
import vn.com.gsoft.categories.repository.DepartmentRepository;
import vn.com.gsoft.categories.repository.RoleRepository;
import vn.com.gsoft.categories.repository.UserRepository;
import vn.com.gsoft.categories.repository.feign.UserProfileFeign;
import vn.com.gsoft.categories.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserProfileFeign userProfileFeign;

    @Override
    public Optional<Profile> findUserByToken(String token) {
        return Optional.of(userProfileFeign.getProfile());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
