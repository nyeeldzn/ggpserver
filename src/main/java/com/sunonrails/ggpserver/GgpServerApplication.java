package com.sunonrails.ggpserver;

import com.sunonrails.ggpserver.model.Bairro;
import com.sunonrails.ggpserver.model.Cliente;
import com.sunonrails.ggpserver.model.OrdemPedido;
import com.sunonrails.ggpserver.model.Produto;
import com.sunonrails.ggpserver.service.BairroService;
import com.sunonrails.ggpserver.service.ClienteService;
import com.sunonrails.ggpserver.service.OrdemPedidoService;
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

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private BairroService bairroService;

	@Autowired
	private OrdemPedidoService ordemPedidoService;

	public static void main(String[] args) {
		SpringApplication.run(GgpServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Intanciando Produtos teste

		Produto prod1 = new Produto(null, "Veja Multiuso");
		Produto prod3 = new Produto(null, "Sabao em Po OMO");
		Produto prod2 = new Produto(null, "Salgadinho Doritos");

		produtoService.insert(prod1);
		produtoService.insert(prod2);
		produtoService.insert(prod3);

		//Instanciando Bairros de Teste

		Bairro b1 = new Bairro(null, "Sao Vicente");
		Bairro b2 = new Bairro(null, "Alto Bela Vista");

		bairroService.insert(b1);
		bairroService.insert(b2);

		//Instanciando Clientes de teste

		Cliente cli1 = new Cliente(null,"Daniel","Rua Maria Pereira de Resende, 45",b1,"34997893234");
		Cliente cli2 = new Cliente(null,"Floriza","Rua Nossa Senhora da Abadia",b2,"SEM NUMERO");
		Cliente cli3 = new Cliente(null,"Guilherme","Rua das Auracarias",b1,"34988790928");
		Cliente cli4 = new Cliente(null,"Gustavo","Avenida Primeiro de Setembro",b2,"SEM NUMERO");

		clienteService.insertList(Arrays.asList(cli1, cli2, cli3, cli4));

		//Instanciando pedidos de Teste

		OrdemPedido ped1 = new OrdemPedido(null,cli1,1,1,
				"DINHEIRO","03-08-2021","18:00",
				"18:05","18:10","18:15",
				"WHATSAPP","DAYANE",1,Arrays.asList(prod1, prod2,prod3));
		ordemPedidoService.insert(ped1);
	}
}
