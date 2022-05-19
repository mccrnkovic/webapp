package hr.tvz.crnkovic.hardwareapp.security.service;

import hr.tvz.crnkovic.hardwareapp.security.command.LoginCommand;
import hr.tvz.crnkovic.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
