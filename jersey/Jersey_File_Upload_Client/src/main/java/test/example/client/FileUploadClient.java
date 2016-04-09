package test.example.client;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import test.example.ProjectConstants;

public class FileUploadClient {

	public void upload() throws IOException {
		Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();

		FileDataBodyPart filePart = new FileDataBodyPart("file", new File(ProjectConstants.UPLOAD_FILE_PATH));
		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		final FormDataMultiPart multipart = (FormDataMultiPart) formDataMultiPart.bodyPart(filePart);

		WebTarget target = client.target(ProjectConstants.REST_API_PATH);
		Response response = target.request().post(Entity.entity(multipart, multipart.getMediaType()));

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			System.out.println(response.readEntity(String.class));
		} else {
			System.out.println(
					"There is an error while uploading file. Received HTTP Status code= " + response.getStatus());
		}
		formDataMultiPart.close();
		multipart.close();
	}
}