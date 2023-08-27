package com.edson.worshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.edson.worshopmongo.domain.Post;
import com.edson.worshopmongo.domain.User;
import com.edson.worshopmongo.dto.AuthorDTO;
import com.edson.worshopmongo.repository.PostRepository;
import com.edson.worshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepositoty;
	@Autowired
	private PostRepository postRepositoty;
	
	@Override
	public void run(String... arg0) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepositoty.deleteAll();
		postRepositoty.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepositoty.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "vou viajar para SP", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/04/2018"), "bom dia", "acordei feliz hj", new AuthorDTO(maria));

		postRepositoty.saveAll(Arrays.asList(post1,post2));

		
	}

}
