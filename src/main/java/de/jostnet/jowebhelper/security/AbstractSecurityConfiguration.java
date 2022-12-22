package de.jostnet.jowebhelper.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.spring.security.VaadinWebSecurity;

public abstract class AbstractSecurityConfiguration extends VaadinWebSecurity
{
	public static final String LOGOUT_URL = "/";

	public abstract PasswordEncoder passwordEncoder();

	private Class<? extends Component> loginView;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		http.authorizeHttpRequests()
				.requestMatchers(new AntPathRequestMatcher("/images/*.png"))
				.permitAll();
		super.configure(http);
		setLoginView(http, loginView, LOGOUT_URL);
	}

	public void setLoginView(Class<? extends Component> loginView)
	{
		this.loginView = loginView;
	}
}
