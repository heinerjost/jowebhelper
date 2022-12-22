package de.jostnet.jowebhelper.security;

import java.util.Optional;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;

import de.jostnet.jowebhelper.interfaces.IBenutzer;
import de.jostnet.jowebhelper.interfaces.IMandant;

public abstract class AbstractAuthenticatedUser<MANDANT extends IMandant, BENUTZER extends IBenutzer<MANDANT>>
{
	public Optional<Authentication> getAuthentication()
	{
		SecurityContext context = SecurityContextHolder.getContext();
		return Optional.ofNullable(context.getAuthentication()).filter(
				authentication -> !(authentication instanceof AnonymousAuthenticationToken));
	}

	public abstract Optional<BENUTZER> get();

	public void logout()
	{
		UI.getCurrent().getPage()
				.setLocation(AbstractSecurityConfiguration.LOGOUT_URL);
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(
				VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
	}

}
