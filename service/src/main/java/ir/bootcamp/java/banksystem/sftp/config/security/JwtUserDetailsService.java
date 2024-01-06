package ir.bootcamp.java.banksystem.sftp.config.security;

import ir.bootcamp.java.banksystem.models.documents.models.UserEntity;
import ir.bootcamp.java.banksystem.sftp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    @Lazy
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.loadByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }

        JwtBankUserDetailsDto jwtBankUserDetailsDto = new JwtBankUserDetailsDto();
        jwtBankUserDetailsDto.setUsername(user.getUsername());
        jwtBankUserDetailsDto.setPassword(user.getPassword());
        jwtBankUserDetailsDto.setTelephone(user.getTelephone());
        jwtBankUserDetailsDto.setEmail(user.getEmail());

        //role
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        jwtBankUserDetailsDto.setAuthorities(simpleGrantedAuthorities);

        return jwtBankUserDetailsDto;
    }

}
