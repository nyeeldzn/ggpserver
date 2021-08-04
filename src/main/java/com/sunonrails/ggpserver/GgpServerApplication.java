package com.sunonrails.ggpserver;

import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.repositories.OrdemPedidoRepository;
import com.sunonrails.ggpserver.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class GgpServerApplication implements CommandLineRunner {

	@Autowired
	private ProdutoService produtoService;

	public static void main(String[] args) {
		SpringApplication.run(GgpServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		Produto prod1 = new Produto(null, "Veja Multiuso");
		Produto prod3 = new Produto(null, "Sabao em Po OMO");
		Produto prod2 = new Produto(null, "Salgadinho Doritos");

		produtoService.insert(prod1);
		produtoService.insert(prod2);
		produtoService.insert(prod3);

	}
}
