package net.softsociety.spring7.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {
	private static final long serialVersionUID = 5987395407301274659L;

	private String memberid; 
	private String memberpwd; 
	private String membername;
	private String email;
	private String phone;
	private String address;
	private boolean enabled;	// 계정상태정보 0:사용불가능, 1:사용가능
	private String rolename;	// 사용자 구분('ROLE_USER', 'ROLE_ADMIN')
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return this.memberpwd;
	}
	@Override
	public String getUsername() {
		return memberid;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
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








