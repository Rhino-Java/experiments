package test.example.controller;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import test.example.ProjectConstants;

@Controller
public class MultipleFileUploadController {

	@RequestMapping(value = { "/uploadMultiple" })
	public String getPage() {
		return "uploadMultiple";

	}

	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile[] files) {
		StringBuilder responseMessage = new StringBuilder();
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];

			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					Files.write(Paths.get(ProjectConstants.UPLOAD_DIR_PATH + file.getOriginalFilename()), bytes);

					responseMessage.append(file.getOriginalFilename() + " is successfully uploaded.<br/><br/>");
				} catch (Exception e) {
					e.printStackTrace();
					responseMessage.append(
							"There is an error while uploading file " + file.getOriginalFilename() + "<br/><br/>");
				}
			} else {
				responseMessage.append("Please choose a file to upload.<br/><br/>");
			}
		}
		return responseMessage.toString();
	}
}