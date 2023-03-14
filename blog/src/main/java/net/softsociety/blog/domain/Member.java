package net.softsociety.blog.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {
    private static final long serialVersionUID = 8973332414547633009L;
    private String blogid;
    private String blogpwd;
    private String blogername;
    private String photo;
    private boolean enabled;	// 계정상태정보 0:사용불가능, 1:사용가능
    private String rolename;	// 사용자 구분('ROLE_USER', 'ROLE_ADMIN')

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.blogpwd;
    }

    @Override
    public String getUsername() {
        return blogid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
