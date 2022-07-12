package alumnimanagement.config;

import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.services.impl.UserAuthServiceImpl;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PermissionEvaluatorService implements PermissionEvaluator {

    private UserAuthServiceImpl userAuthRepo;

    public PermissionEvaluatorService(UserAuthServiceImpl userAuthRepo) {
        this.userAuthRepo = userAuthRepo;
    }

    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }
        String[] targetType = targetDomainObject.toString().replace('[', ' ').replace(']', ' ').trim().split(",");
        String userName = auth.getName();
        UserAuth user = userAuthRepo.getUserByUserName(userName);
        for (int i = 0; i < targetType.length; i++) {
            if (user.getRole().toUpperCase().equals(targetType[i].toUpperCase()))
                return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}