package de.jostnet.jowebhelper.tools;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vaadin.flow.component.upload.UploadI18N;

public class JoUploadI18N extends UploadI18N
{
	private static final long serialVersionUID = 1L;

	public JoUploadI18N()
	{
		this.setDropFiles(new UploadI18N.DropFiles().setOne("Datei ablegen...")
				.setMany("Dateien ablegen..."))
				.setAddFiles(new UploadI18N.AddFiles().setOne("Datei auswählen")
						.setMany("Dateien auswählen"))
				.setError(new UploadI18N.Error().setTooManyFiles("Zu viele Dateien.")
						.setFileIsTooBig("Datei ist zu groß.")
						.setIncorrectFileType("Ungültiger Dateityp."))
				.setUploading(new UploadI18N.Uploading()
						.setStatus(new UploadI18N.Uploading.Status()
								.setConnecting("Verbinde...").setStalled("Download blockiert.")
								.setProcessing("verarbeite..."))
						.setRemainingTime(new UploadI18N.Uploading.RemainingTime()
								.setPrefix("verbleibende Zeit: ")
								.setUnknown("Die verbleibende Zeit ist unbekannt."))
						.setError(new UploadI18N.Uploading.Error()
								.setServerUnavailable("Server nicht verfügbar")
								.setUnexpectedServerError("Unerwarteter Serverfehler")
								.setForbidden("Download verboten")))
				.setUnits(
						Stream.of("Bytes", "KB", "MB", "GB", "TB", "PB", "ZB", "EB", "")
								.collect(Collectors.toList()));

	}
}
