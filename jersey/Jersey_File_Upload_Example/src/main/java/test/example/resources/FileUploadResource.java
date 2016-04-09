package test.example.resources;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import test.example.ProjectConstants;
import test.example.util.BinaryReader;

@Path("/upload")
public class FileUploadResource {

	@POST
	@Path("/file")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	public Response uploadFile(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition fileMetaData) throws Exception {

		try {
			byte[] fileData = BinaryReader.getInputStreamContentAsByteArray(fileInputStream);
			Files.write(Paths.get(ProjectConstants.UPLOAD_DIR_PATH + fileMetaData.getFileName()), fileData);

		} catch (IOException e) {
			return Response.ok("There is an error while uploading file.").build();
		}
		return Response.ok("File is successfully uploaded.").build();
	}

}
