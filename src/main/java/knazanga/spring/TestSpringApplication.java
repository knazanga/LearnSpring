package knazanga.spring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import knazanga.spring.dao.EntityRepository;
import knazanga.spring.dao.IEntityRepository;
import knazanga.spring.dao.IUserRepository;
import knazanga.spring.entities.User;

@SpringBootApplication
public class TestSpringApplication {

	public static void main(String[] args) {
		ApplicationContext appContext=SpringApplication.run(TestSpringApplication.class, args);
		
		@SuppressWarnings("unchecked") //Disable warning for Bean type
		IEntityRepository<User> userDao=appContext.getBean(EntityRepository.class);
		
		userDao.save(new User("Frank NAZANGA", "knazanga@yah.fr", "kouba"));
		userDao.save(new User("Kouba AZANGA", "kouba@yah.fr", "kouba"));
		userDao.save(new User("Frank Kouba", "kfranck@yah.fr", "kouba"));
		
		
				
		IUserRepository dao=appContext.getBean(IUserRepository.class);
		List<User> users=dao.findAll();
		users.forEach(System.out::println);
		
	} 
}
