package springSecurity.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import springSecurity.models.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {
    // Spring Security использует объект Authentication, пользователя авторизованной сессии.
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        if (roles.contains("ROLE_USER")) {
            System.out.println("roles1 " + roles);
            httpServletResponse.sendRedirect("/user");
//        } else if (roles.contains("ROLE_USER")) {
//            httpServletResponse.sendRedirect("/user");
        } else {
            System.out.println("roles2 " + roles);
            System.out.println("roles1 " + roles instanceof String);
//            httpServletResponse.sendRedirect("/auth/registration");
            httpServletResponse.sendRedirect("/admin");
        }
    }
}


//        System.out.println("roles " + roles);
//        for (String role : roles) {
//            System.out.println("role" + role);
//            if (role == "ROLE_ADMIN") {
//                Boolean id = role == "ROLE_ADMIN";
//                System.out.println("true" +  id);
//                httpServletResponse.sendRedirect("/admin");
//            } else {
//                System.out.println("true");
//                httpServletResponse.sendRedirect("/users/user");
//            }
//        }
//        System.out.println("roles.contains" + roles.stream().filter(data -> Objects.equals(data, "ROLE_ADMIN")).findFirst().get());
//        if (roles.contains("ROLE_ADMIN")) {
//            httpServletResponse.sendRedirect("/admin");
//        } else if (roles.contains("ROLE_USER")) {
//            httpServletResponse.sendRedirect("/user");
//        } else {
////            httpServletResponse.sendRedirect("/auth/registration");
//            httpServletResponse.sendRedirect("/user");
//        }
