package com.rbs.tmg.stopit.dao.generator;

import java.io.File;
import java.nio.file.Path;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * 
 * @author KHANDES
 */
public class DataBaseGeneratorDAO {

	private String fileLocationPath;

	public String getFileLocationPath() {
		return fileLocationPath;
	}

	public void setFileLocationPath(String fileLocationPath) {
		this.fileLocationPath = fileLocationPath;
	}

	private EmbeddedDatabase embeddedDataSource;

	@Bean
	@PostConstruct
	public void createDataSource() {
		File dir = new File(fileLocationPath);
		File[] sqlFiles = dir.listFiles();
		String[] sqlPaths = new String[1]; 
		sqlPaths[0]="classpath:com/rbs/ApplicationStatsControl.sql";
		int i = 0;
		/*for (File sql : sqlFiles) {
			sqlPaths[i++] = sql.getAbsolutePath();
		}*/
		System.out.println("The files present in the generate folder are : ");
		System.out.println(sqlFiles.length);

		embeddedDataSource = new EmbeddedDatabaseBuilder().setName("testdb").setType(EmbeddedDatabaseType.H2)
				.addScripts(sqlPaths).build();
		// return embeddedDataSource;
	}

	@PreDestroy
	public void tearDown() {
		embeddedDataSource.shutdown();
	}
}