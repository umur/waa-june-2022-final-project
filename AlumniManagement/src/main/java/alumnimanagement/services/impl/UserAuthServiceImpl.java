package alumnimanagement.services.impl;

import alumnimanagement.entity.authUser.UserAuth;
import alumnimanagement.repo.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAuthServiceImpl implements UserDetailsService {
    @Autowired
    private UserAuthRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth user = userRepo.findByUsernameAndActive(username);
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), new ArrayList<>()
        );
        return user1;
    }

    public void save(UserAuth user) {
        userRepo.save(user);
    }

    public UserAuth getById(Long id) {
        var user = userRepo.findById(id);
        if (user == null)
            return new UserAuth();
        else
            return user.get();
    }

    public UserAuth getUserByUserName(String userName) {
        var user = userRepo.findByUsernameAndActive(userName);
        return user;
    }

    public String getRoleById(Long id) {

        String role = userRepo.getRoleById(id);
        return role;
    }

    public void deletById(Long id) {
        userRepo.deleteById(id);
    }
}
