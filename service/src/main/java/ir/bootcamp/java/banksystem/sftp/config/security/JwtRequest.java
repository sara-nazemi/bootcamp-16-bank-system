package ir.bootcamp.java.banksystem.sftp.config.security;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JwtRequest {

    private String username;
    private String password;

}