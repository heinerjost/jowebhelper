package de.jostnet.jowebhelper.views;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import de.jostnet.jowebhelper.data.AbstractSession;
import de.jostnet.jowebhelper.data.entity.AbstractEntity;
import de.jostnet.jowebhelper.help.AbstractHelp;
import de.jostnet.jowebhelper.interfaces.IBenutzer;
import de.jostnet.jowebhelper.interfaces.IMandant;
import de.jostnet.jowebhelper.listener.CanceledListener;
import de.jostnet.jowebhelper.listener.DeletedListener;
import de.jostnet.jowebhelper.listener.SavedListener;
import de.jostnet.jowebhelper.security.AbstractAuthenticatedUser;
import de.jostnet.jowebhelper.tools.MessageTranslator;
import de.jostnet.jowebhelper.tools.ViewDialogTool;

public abstract class AbstractView<BEAN extends AbstractEntity,
		BINDER extends BeanValidationBinder<BEAN>,
		REPO extends JpaRepository<BEAN, UUID>, MANDANT extends IMandant,
		SESSION extends AbstractSession<MANDANT, BENUTZER>,
		BENUTZER extends IBenutzer<MANDANT>> extends VerticalLayout
{

	private static final long serialVersionUID = 1L;

	private ViewDialogTool<BEAN, BINDER, REPO, MANDANT, SESSION, BENUTZER> vdt;

	private List<VerticalLayout> layouts = new ArrayList<>();

	public AbstractView(	ViewDialogTool<BEAN, BINDER, REPO, MANDANT, SESSION, BENUTZER> vdt)
	{
		this.vdt = vdt;
	}

	public void setRepo(REPO repo)
	{
		vdt.setRepo(repo);
	}

	public REPO getRepo()
	{
		return vdt.getRepo();
	}

	public void setBinder(BINDER binder)
	{
		vdt.setBinder(binder);
	}

	public BINDER getBinder()
	{
		return vdt.getBinder();
	}

	public void setBean(BEAN bean)
	{
		vdt.setBean(bean);
		vdt.getBinder().readBean(bean);
	}

	public BEAN getBean()
	{
		return vdt.getBean();
	}

	public void addLayout(VerticalLayout layout)
	{
		layouts.add(layout);
	}

	public void activate(VerticalLayout layout)
	{
		layouts.forEach(lay -> lay.setVisible(lay == layout));
	}

	public AbstractView(AbstractSession<MANDANT, BENUTZER> session,
			ViewDialogTool<BEAN, BINDER, REPO, MANDANT, SESSION, BENUTZER> vdt)
	{
		super();
		this.vdt = vdt;
	}

	public AbstractAuthenticatedUser<MANDANT, BENUTZER> getAuthenticatedUser()
	{
		return vdt.getAuthenticatedUser();
	}

	public void addSavedListener(SavedListener toAdd)
	{
		vdt.addSavedListener(toAdd);
	}

	public void addDeletedListener(DeletedListener toAdd)
	{
		vdt.addDeletedListener(toAdd);
	}

	public void addCanceledListener(CanceledListener toAdd)
	{
		vdt.addCanceledListener(toAdd);
	}

	public BENUTZER getBenutzer()
	{
		return vdt.getBenutzer();
	}

	public MANDANT getMandant()
	{
		return vdt.getMandant();
	}

	public BEAN speichern()
	{
		return vdt.speichern();
	}

	public void loeschen(String message)
	{
		vdt.loeschen(message);
	}

	public void abbrechen()
	{
		vdt.abbrechen();
	}

//	@Override
//	public void beforeLeave(BeforeLeaveEvent event)
//	{
//		if (vdt.getBinder() == null)
//		{
//			return;
//		}
//		if (vdt.getBinder().hasChanges())
//		{
//			ContinueNavigationAction action = event.postpone();
//			ConfirmDialog confirmDialog = new ConfirmDialog();
//			confirmDialog.setHeader("Nicht gespeicherte Änderungen!");
//			confirmDialog.setText("Wirklich verlassen?");
//			confirmDialog.setCancelable(true);
//			confirmDialog.setCancelText("Nein");
//			confirmDialog.setConfirmText("Ja");
//			confirmDialog.addConfirmListener(__ -> action.proceed());
//			confirmDialog.open();
//		}
//	}

	public ConfirmDialog getConfirmDialog()
	{
		ConfirmDialog confirmDialog = new ConfirmDialog();
		confirmDialog.setHeader("Nicht gespeicherte Änderungen!");
		confirmDialog.setText("Wirklich verlassen?");
		confirmDialog.setCancelable(true);
		confirmDialog.setCancelText("Nein");
		confirmDialog.setConfirmText("Ja");
		confirmDialog.open();

		return confirmDialog;
	}

	public void showGespeichert()
	{
		vdt.showGespeichert();
	}

	public void showGeloescht()
	{
		vdt.showGeloescht();
	}

	public void showFehler(Exception e)
	{
		vdt.showFehler(MessageTranslator.get(e));
	}

	public void showFehler(String fehler)
	{
		vdt.showFehler(fehler);
	}

	public void showMeldung(String meldung)
	{
		vdt.showMeldung(meldung);
	}

//	public EinstellungenAllgemein getEinstellungenAllgemein()
//	{
//		return vdt.getEinstellungenAllgemein();
//	}
//
//	public EinstellungenAbrechnung getEinstellungenAbrechnung()
//	{
//		return vdt.getEinstellungenAbrechnung();
//	}
//
//	public EinstellungenBuchfuehrung gEinstellungenBuchfuehrung()
//	{
//		return vdt.getEinstellungenBuchfuehrung();
//	}
//
	public SESSION getSession()
	{
		return vdt.getSession();
	}

	public ConfirmDialog getConfirmDeleteDialog(String message)
	{
		return vdt.getConfirmDeleteDialog(message);
	}

	public void fireSavedEvent()
	{
		vdt.fireSavedEvent();
	}

	public void fireDeletedEvent()
	{
		vdt.fireDeletedEvent();
	}

	public void fireCanceledEvent()
	{
		vdt.fireCanceledEvent();
	}

	public abstract Class<? extends AbstractHelp> getHelpClass();
	
}
