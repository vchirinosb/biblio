package com.biblio.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biblio.dao.UsuarioDao;
import com.biblio.pojo.Usuario;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioDao usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Usuario usuario = usuarioDAO.findByUsuario(username);
		
		if (usuario != null) {
			// authorities.add(new SimpleGrantedAuthority(usuario.getPermiso()));
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			User user = new User(usuario.getUsuario(), usuario.getPassword(), authorities);
			return user;
		} 
		else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
