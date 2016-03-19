package test.example.filters;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import test.example.ProjectConstants;

public class UploadFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(httpRequest);
		if (!isMultipartContent) {
			chain.doFilter(request, response);
			return;
		}
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		try {
			List<FileItem> fileItemList = (List<FileItem>) servletFileUpload.parseRequest(httpRequest);
			final Map<String, String[]> parameterMap = new HashMap<String, String[]>();
			for (FileItem fileItem : fileItemList) {
				String fileContent = fileItem.getString(ProjectConstants.FILE_ENCODING);
				if (fileItem.isFormField()) {
					parameterMap.put(fileItem.getFieldName(), new String[] { fileContent });
				} else {
					httpRequest.setAttribute(fileItem.getFieldName(), fileItem);
				}
			}
			/*
			 * Create wrapper class for HttpServletRequest so that, JSF can
			 * analyze HttpServletRequest.
			 */
			chain.doFilter(new HttpServletRequestWrapper(httpRequest) {
				public Map<String, String[]> getParameterMap() {
					return parameterMap;
				}

				public String[] getParameterValues(String name) {
					Map<String, String[]> parameterMap = getParameterMap();
					return (String[]) parameterMap.get(name);
				}

				public String getParameter(String name) {
					String[] params = getParameterValues(name);
					return params == null ? null : params[0];
				}

				public Enumeration<String> getParameterNames() {
					Map<String, String[]> parameterMap = getParameterMap();
					return Collections.enumeration(parameterMap.keySet());
				}
			}, response);
		} catch (FileUploadException ex) {
			ServletException servletException = new ServletException();
			servletException.initCause(ex);
			throw servletException;
		}
	}

	@Override
	public void destroy() {

	}
}