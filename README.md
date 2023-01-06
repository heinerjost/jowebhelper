# JoWebHelper

## Maven Dependency
		<dependency>
			<groupId>de.jostnet</groupId>
			<artifactId>jowebhelper</artifactId>
			<version>1.0.2-SNAPSHOT</version>
		</dependency>

## ???Session

    package de.jostnet.ver1cloud.customized;
     
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    import org.springframework.web.context.annotation.SessionScope;
     
    import de.jostnet.jowebhelper.data.AbstractSession;
    import de.jostnet.ver1cloud.data.entity.Benutzer;
    import de.jostnet.ver1cloud.data.entity.EinstellungenAbrechnung;
    import de.jostnet.ver1cloud.data.entity.EinstellungenAllgemein;
    import de.jostnet.ver1cloud.data.entity.EinstellungenBuchfuehrung;
    import de.jostnet.ver1cloud.data.entity.Mandant;
    import de.jostnet.ver1cloud.security.AuthenticatedUser;
    import lombok.Getter;
    import lombok.Setter;
    import lombok.ToString;
     
    @Component
    @SessionScope
    @ToString
    public class V1cSession extends AbstractSession<Mandant, Benutzer>
    {
     
	  @Autowired
	  @Getter
	  @Setter
	  private AuthenticatedUser authenticatedUser;
    
	  public V1cSession(AuthenticatedUser authenticatedUser)
	  {
	     super(authenticatedUser);
	  }
       
	  @Getter
	  @Setter
	  private EinstellungenAllgemein einstellungenAllgemein;
       
	  @Getter
	  @Setter
	  private EinstellungenBuchfuehrung einstellungenBuchfuehrung;
      
	  @Getter
	  @Setter
	  private EinstellungenAbrechnung einstellungenAbrechnung;
      
    }


## ???AbstractView

    package de.jostnet.ver1cloud.customized;
     
    import java.util.UUID;
     
    import org.springframework.data.jpa.repository.JpaRepository;
     
    import com.vaadin.flow.data.binder.BeanValidationBinder;
     
    import de.jostnet.jowebhelper.data.entity.AbstractEntity;
    import de.jostnet.jowebhelper.help.AbstractHelp;
    import de.jostnet.jowebhelper.views.AbstractView;
    import de.jostnet.ver1cloud.data.entity.Benutzer;
    import de.jostnet.ver1cloud.data.entity.Mandant;
    import de.jostnet.ver1cloud.tools.V1cViewDialogTool;
      
     public abstract class V1cAbstractView<BEAN extends AbstractEntity,
		BINDER extends BeanValidationBinder<BEAN>,
		REPO extends JpaRepository<BEAN, UUID>>
		extends AbstractView<BEAN, BINDER, REPO, Mandant, V1cSession, Benutzer>
    {
	private static final long serialVersionUID = -4751320773480217021L;
     
	public V1cAbstractView(V1cSession session)
	{
	   super(new V1cViewDialogTool<>(session));
	}

	@Override
	public abstract Class<? extends AbstractHelp> getHelpClass();
 
    }

## ???Session

    package de.jostnet.ver1cloud.customized;
     
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;
    import org.springframework.web.context.annotation.SessionScope;
     
    import de.jostnet.jowebhelper.data.AbstractSession;
    import de.jostnet.ver1cloud.data.entity.Benutzer;
    import de.jostnet.ver1cloud.data.entity.EinstellungenAbrechnung;
    import de.jostnet.ver1cloud.data.entity.EinstellungenAllgemein;
    import de.jostnet.ver1cloud.data.entity.EinstellungenBuchfuehrung;
    import de.jostnet.ver1cloud.data.entity.Mandant;
    import de.jostnet.ver1cloud.security.AuthenticatedUser;
    import lombok.Getter;
    import lombok.Setter;
    import lombok.ToString;
      
    @Component
    @SessionScope
    @ToString
    public class V1cSession extends AbstractSession<Mandant, Benutzer>
    {
     
	  @Autowired
	  @Getter
	  @Setter
	  private AuthenticatedUser authenticatedUser;
    
	  public V1cSession(AuthenticatedUser authenticatedUser)
	  {
		super(authenticatedUser);
	  }

	  @Getter
	  @Setter
	  private EinstellungenAllgemein einstellungenAllgemein;
    
       @Getter
	  @Setter
	  private EinstellungenBuchfuehrung einstellungenBuchfuehrung;

	  @Getter
	  @Setter
	  private EinstellungenAbrechnung einstellungenAbrechnung;

    }

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/jowebhelper-1.0-SNAPSHOT.jar`

