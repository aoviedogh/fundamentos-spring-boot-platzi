package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDepedency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private final Log LOGGER = LogFactory.getLog(this.getClass());

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDepedency myBeanWithDepedency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDepedency myBeanWithDepedency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDepedency = myBeanWithDepedency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		guardarUsuario();
		obtieneUsuario();
	}

	private void guardarUsuario() {
		User u1 = new User("Aurelio", "aoviedo2701@gmail.com", LocalDate.of(1990, 2, 07));
		User u2 = new User("Fabio", "foviedo@gmail.com", LocalDate.of(2013, 1, 03));
		User u3 = new User("Ale", "ale@gmail.com", LocalDate.of(2015, 4, 13));

		List<User> lista = Arrays.asList(u1, u2, u3);
		lista.stream().forEach(userRepository::save);
	}

	private void obtieneUsuario(){
		LOGGER.info("Obtiene usuario con métdodo obtieneUsuario: " + userRepository.findByUserEmail("aoviedo2701@gmail.com")
				.orElseThrow(()-> new RuntimeException("No se encontró usuario")));

		userRepository.findAndSort("Aurelio", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con método Sort: " + user));
	}

	private void ejemplosAnteriores() {
		componentDependency.saludar();
		myBean.imprimir();
		myBeanWithDepedency.imprimirWithDependency();
		System.out.println(myBeanWithProperties.function() + ", Edad: " + userPojo.getEdad());
		System.out.println(userPojo.getEmail() + "/" + userPojo.getPassword());

		try {
			int value = 10/0;
			LOGGER.debug("variable: " + value);
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir entre 0" + e.getStackTrace());
		}
	}
}
