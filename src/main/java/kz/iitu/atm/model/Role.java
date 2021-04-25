package kz.iitu.atm.model;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
@ToString
public enum Role implements GrantedAuthority {
    ADMIN,USER;

    @Override
    public String getAuthority() {
        return  toString();
    }
}
