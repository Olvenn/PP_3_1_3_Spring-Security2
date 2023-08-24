package springSecurity.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import springSecurity.models.Role;
import springSecurity.models.User;
import springSecurity.service.RoleServiceImpl;
import springSecurity.service.UserServiceImp;

import javax.annotation.PostConstruct;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseInit {
    private final UserServiceImp userService;
    private final RoleServiceImpl roleService;
    private final PasswordEncoder passwordEncoder;

    public DatabaseInit(UserServiceImp userService, RoleServiceImpl roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void postConstruct() {
//        Role roleUser = new Role("ROLE_USER");
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        String user1Password = passwordEncoder.encode("user1");
//        String admin1Password = passwordEncoder.encode("admin1");
//
//        User user = new User("user1", "user1", "user1", "user@gmail.com", user1Password);
//        User admin = new User("admin1", "admin1", "admin1",  "admin@gmail.com", admin1Password);
//
//        user.setRole(Set.of(roleUser));
//        admin.setRole(Set.of(roleAdmin));
//
//        roleService.saveRole(roleUser);
//        roleService.saveRole(roleAdmin);
//
//        userService.saveUser(user);
//        userService.saveUser(admin);
    }
}
