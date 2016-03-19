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
public class SingleFileUploadController {

	@RequestMapping(value = { "/uploadSingle" })
	public String getPage() {
		return "uploadSingle";

	}

	@RequestMapping(value = "/uploadSingleFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				Files.write(Paths.get(ProjectConstants.UPLOAD_DIR_PATH + file.getOriginalFilename()), bytes);

				return file.getOriginalFilename() + " is successfully uploaded.";
			} catch (Exception e) {
				e.printStackTrace();
				return "There is an error while uploading file " + file.getOriginalFilename();
			}
		} else {
			return "Please choose a file to upload.";
		}
	}
}
