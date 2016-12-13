package knazanga.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import knazanga.spring.entities.User;

//Repository using spring data tools
public interface IUserRepository extends JpaRepository<User, Long> {

	
}
