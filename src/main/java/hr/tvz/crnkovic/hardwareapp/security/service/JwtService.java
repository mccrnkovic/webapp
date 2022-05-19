package hr.tvz.crnkovic.hardwareapp.security.service;

import hr.tvz.crnkovic.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
