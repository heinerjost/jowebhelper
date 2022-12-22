package de.jostnet.jowebhelper.dialogs;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.data.binder.BeanValidationBinder;

import de.jostnet.jowebhelper.data.AbstractSession;
import de.jostnet.jowebhelper.data.entity.AbstractEntity;
import de.jostnet.jowebhelper.interfaces.IBenutzer;
import de.jostnet.jowebhelper.interfaces.IMandant;
import de.jostnet.jowebhelper.listener.CanceledListener;
import de.jostnet.jowebhelper.listener.DeletedListener;
import de.jostnet.jowebhelper.listener.SavedListener;
import de.jostnet.jowebhelper.tools.MessageTranslator;
import de.jostnet.jowebhelper.tools.ViewDialogTool;

public class AbstractDialog<BEAN extends AbstractEntity,
		BINDER extends BeanValidationBinder<BEAN>,
		REPO extends JpaRepository<BEAN, UUID>, MANDANT extends IMandant,
		SESSION extends AbstractSession<MANDANT, BENUTZER>,
		BENUTZER extends IBenutzer<MANDANT>> extends Dialog
{

	private static final long serialVersionUID = 1L;

	private ViewDialogTool<BEAN, BINDER, REPO, MANDANT, SESSION, BENUTZER> vdt;

	public AbstractDialog(
			ViewDialogTool<BEAN, BINDER, REPO, MANDANT, SESSION, BENUTZER> vdt)
	{
		super();
		this.vdt = vdt;
	}

	public SESSION getSession()
	{
		return vdt.getSession();
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
		return vdt.speichern(true);
	}

	public BEAN speichern(boolean doItReally)
	{
		return vdt.speichern(doItReally);
	}

	public void loeschen(boolean doItReally, String message)
	{
		vdt.loeschen(doItReally, message);
	}

	public void loeschen(String message)
	{
		vdt.loeschen(true, message);
	}

	public void abbrechen()
	{
		vdt.abbrechen();
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

	public void showGespeichert()
	{
		vdt.showGespeichert();
	}

	public void showUebernehmen()
	{
		vdt.showUebernommen();
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

}
