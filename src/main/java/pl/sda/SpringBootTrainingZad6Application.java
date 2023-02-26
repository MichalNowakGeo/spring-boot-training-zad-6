package pl.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.entity.PersonEntity;
import pl.sda.repository.AccountRepository;
import pl.sda.repository.PersonRepository;
import pl.sda.service.MoneyTransferExecutor;

import java.math.BigDecimal;
import java.util.List;


@SpringBootApplication
public class SpringBootTrainingZad6Application implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private MoneyTransferExecutor moneyTransferExecutor;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTrainingZad6Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		List<PersonEntity> persons = personRepository.findAll();
		System.out.println(persons);

		PersonEntity personWithPesel = personRepository.findByPesel("51101069339");
		System.out.println(personWithPesel);

		moneyTransferExecutor.send(1000L, 2000L, BigDecimal.valueOf(500));
		System.out.println(accountRepository.findAll());

	}
}