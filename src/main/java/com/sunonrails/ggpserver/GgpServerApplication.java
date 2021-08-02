package com.sunonrails.ggpserver;

import com.sunonrails.ggpserver.repositories.OrdemPedidoRepository;
import com.sunonrails.ggpserver.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class GgpServerApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private OrdemPedidoRepository ordemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GgpServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
