package com.rbs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.rbs.tmg.stopit.dao.generator.DataBaseGeneratorDAO;

public class MainApp {
   public static void main(String[] args) {
	   ApplicationContext context = 
             new ClassPathXmlApplicationContext("Spring/ApplicationContext.xml");
	   DataBaseGeneratorDAO ds = (DataBaseGeneratorDAO) context.getBean("dataBaseGeneratorDAO");

   }
}
      