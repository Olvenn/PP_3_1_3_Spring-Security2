package springSecurity.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springSecurity.models.Role;
import springSecurity.models.User;
import springSecurity.repositories.RoleRepository;
import springSecurity.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository peopleRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = peopleRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(User person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
//        Optional<Role> roleUser = roleRepository.getRoleByName("ROLE_USER");
//        List<Optional<Role>> userRole = new ArrayList<>();
//        userRole.add(roleUser);

        System.out.println("person" + person.getRole());

        userRepository.save(person);
    }
}
