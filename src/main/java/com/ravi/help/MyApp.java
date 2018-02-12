package com.ravi.help;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ravi.help.ctr.Contact;
import com.ravi.help.ctr.DataBase;

@SpringBootApplication
@Configuration
//@PropertySource({"classpath:database.properties","classpath:Email.properties"})
@PropertySources({
	@PropertySource("classpath:database.properties"),
	@PropertySource("classpath:Email.properties"),
})
public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx=SpringApplication.run(MyApp.class, args);
		DataBase db=(DataBase)ctx.getBean(DataBase.class);
		System.out.println("name="+db.getName());
		System.out.println("password="+db.getPassword());
		
		Contact cntc=(Contact)ctx.getBean(Contact.class);
		System.out.println("Email="+cntc.getEmailid());
		System.out.println("phon="+cntc.getPhon());
		System.out.println("zip="+cntc.getZip());
	}

	@Value("${user.name}")
	public String name;
	@Value("${user.password}")
	public String password;
	
	@Value("${contact.emailid}")
	public String email;
	@Value("${contact.phon}")
	public String phon;
	@Value("${contact.zip}")
	public String zip;
	
	@Bean
	public Contact getContact() {
		Contact cntc=new Contact();
		cntc.setEmailid(email);
		cntc.setPhon(phon);
		cntc.setZip(zip);
		return cntc;
	}
	
	@Bean
	public DataBase getDetails() {
		DataBase db=new DataBase();
		db.setName(name);
		db.setPassword(password);
		return db;
	}
	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
