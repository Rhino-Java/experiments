package test.example.beans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;

import test.example.ProjectConstants;
import test.example.util.BinaryReader;

@ManagedBean(name = "uploadSingleFile")
@RequestScoped
public class UploadSingleFile {

	public String upload() {

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		/**
		 * value of name attribute of the file input field in the form
		 */
		String nameAttributeValueOfFileInputField = "file";
		DiskFileItem fileItem = (DiskFileItem) request.getAttribute(nameAttributeValueOfFileInputField);
		String fileName = fileItem.getName();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			byte[] fileContent = BinaryReader.getInputStreamContentAsByteArray(fileItem.getInputStream());
			Files.write(Paths.get(ProjectConstants.UPLOAD_DIR_PATH + fileName), fileContent);
			context.addMessage(null, new FacesMessage("File is successfully uploaded"));
		} catch (IOException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage("There is an error while uplodaing file."));
		}
		return "uploadSingle";
	}
}