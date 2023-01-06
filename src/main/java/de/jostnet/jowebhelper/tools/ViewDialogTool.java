package de.jostnet.jowebhelper.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;

import de.jostnet.jowebhelper.data.AbstractSession;
import de.jostnet.jowebhelper.data.entity.AbstractEntity;
import de.jostnet.jowebhelper.interfaces.IBenutzer;
import de.jostnet.jowebhelper.interfaces.IMandant;
import de.jostnet.jowebhelper.listener.CanceledListener;
import de.jostnet.jowebhelper.listener.DeletedListener;
import de.jostnet.jowebhelper.listener.SavedListener;
import de.jostnet.jowebhelper.security.AbstractAuthenticatedUser;
import lombok.Getter;
import lombok.Setter;

public abstract class ViewDialogTool<BEAN extends AbstractEntity,
		BINDER extends BeanValidationBinder<BEAN>,
		REPO extends JpaRepository<BEAN, UUID>, MANDANT extends IMandant,
		SESSION extends AbstractSession<MANDANT, BENUTZER>,
		BENUTZER extends IBenutzer<MANDANT>>
{
	@Getter
	@Setter
	private BEAN bean;

	@Getter
	@Setter
	private BINDER binder;

	@Getter
	@Setter
	REPO repo;

	@Getter
	private SESSION session;

	private List<SavedListener> savedlisteners = new ArrayList<>();

	private List<DeletedListener> deletedlisteners = new ArrayList<>();

	private List<CanceledListener> canceledlisteners = new ArrayList<>();

	public ViewDialogTool(SESSION session)
	{
		this.session = session;
	}

	public BEAN speichern()
	{
		return speichern(true);
	}

	public BEAN speichern(boolean doItReally)
	{
		try
		{
			binder.writeBean(bean);
			if (doItReally)
			{
				bean = repo.save(bean);
			}
			if (doItReally)
			{
				showGespeichert();
			}
			else
			{
				showUebernommen();
			}
			fireSavedEvent();
			return bean;
		}
		catch (Exception e)
		{
			showFehler(e);
		}
		return null;
	}

	public void loeschen(String message)
	{
		loeschen(true, message);
	}

	public void loeschen(boolean doItReally, String message)
	{
		try
		{
			ConfirmDialog cd = this.getConfirmDeleteDialog(message);
			cd.addConfirmListener(e ->
			{
				try
				{
					binder.writeBean(bean);
					if (doItReally)
					{
						repo.delete(bean);
						showGeloescht();
					}
					else
					{
						showUebernommen();
					}
					fireDeletedEvent();
				}
				catch (ValidationException e1)
				{
					showFehler(e1);
				}
			});
		}
		catch (Exception e)
		{
			showFehler(e);
		}
	}

	public void abbrechen()
	{
		if (binder.hasChanges())
		{
			ConfirmDialog cd = getConfirmDialog();
			cd.addConfirmListener(e1 -> fireCanceledEvent());
		}
		else
		{
			fireCanceledEvent();
		}
	}

	public void fireSavedEvent()
	{
		for (SavedListener sl : savedlisteners)
		{
			sl.saved();
		}
	}

	public void fireDeletedEvent()
	{
		for (DeletedListener dl : deletedlisteners)
			dl.deleted();
	}

	public void fireCanceledEvent()
	{
		for (CanceledListener cl : canceledlisteners)
			cl.canceled();
	}

	public void addSavedListener(SavedListener toAdd)
	{
		savedlisteners.add(toAdd);
	}

	public void addDeletedListener(DeletedListener toAdd)
	{
		deletedlisteners.add(toAdd);
	}

	public void addCanceledListener(CanceledListener toAdd)
	{
		canceledlisteners.add(toAdd);
	}

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

	public ConfirmDialog getConfirmDeleteDialog(String text)
	{
		ConfirmDialog confirmDialog = new ConfirmDialog();
		confirmDialog.setHeader("Wirklich löschen?");
		confirmDialog.setText(text);
		confirmDialog.setCancelable(true);
		confirmDialog.setCancelText("Nein");
		confirmDialog.setConfirmText("Ja");
		confirmDialog.open();

		return confirmDialog;
	}

	public void showGespeichert()
	{
		Notification notification = Notification.show("gespeichert");
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		notification.setDuration(2000);
		notification.setPosition(Position.BOTTOM_CENTER);
	}

	public void showUebernommen()
	{
		Notification notification = Notification.show("übernommen");
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		notification.setDuration(2000);
		notification.setPosition(Position.BOTTOM_CENTER);
	}

	public void showGeloescht()
	{
		Notification notification = Notification.show("geloescht");
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		notification.setDuration(2000);
		notification.setPosition(Position.BOTTOM_CENTER);
	}

	public void showFehler(Exception e)
	{
		showFehler(MessageTranslator.get(e));
	}

	public void showFehler(String fehler)
	{
		Notification notification = Notification.show(fehler);
		notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
		notification.setDuration(5000);
		notification.setPosition(Position.BOTTOM_CENTER);
	}

	public void showMeldung(String meldung)
	{
		Notification notification = Notification.show(meldung);
		notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
		notification.setDuration(2000);
		notification.setPosition(Position.BOTTOM_CENTER);
	}

	public BENUTZER getBenutzer()
	{
		return session.getBenutzer();
	}

	public MANDANT getMandant()
	{
		return session.getMandant();
	}

	public AbstractAuthenticatedUser<MANDANT, BENUTZER> getAuthenticatedUser()
	{
		return session.getAuthenticatedUser();
	}

}
