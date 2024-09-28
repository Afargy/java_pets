package edu.school21.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.school21.service.repositories.UsersRepository;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "context.xml");
        UsersRepository usersRepository = context.getBean("usersRepositoryJdbc",
                UsersRepository.class);

        System.out.println(usersRepository.findAll());

        usersRepository = context.getBean("usersRepositoryJdbcTemplate",
                UsersRepository.class);
        System.out.println(usersRepository.findAll());

        ((AbstractApplicationContext) context).close();
    }
}
