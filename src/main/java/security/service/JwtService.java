package security.service;

import security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
