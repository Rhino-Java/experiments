package test.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigParams {

	/**
	 * the value of @Value annotation is the key of the property file. If the
	 * mentioned key is not present in the property file, spring will give error
	 * on startup. However, keys with no value are allowed. In such case,
	 * corresponding variable will contain empty string, instead of null.
	 */
	@Value("${jdbc.driverClassName}")
	private String dbDriverClassName;

	@Value("${jdbc.url}")
	private String dbUrl;

	@Value("${jdbc.username}")
	private String dbUsername;

	@Value("${jdbc.password}")
	private String dbPassword;

	public String getDbDriverClassName() {
		return dbDriverClassName;
	}

	public void setDbDriverClassName(String dbDriverClassName) {
		this.dbDriverClassName = dbDriverClassName;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	@Override
	public String toString() {
		return "ConfigParams [dbDriverClassName=" + dbDriverClassName
				+ ", dbUrl=" + dbUrl + ", dbUsername=" + dbUsername
				+ ", dbPassword=" + dbPassword + "]";
	}

}