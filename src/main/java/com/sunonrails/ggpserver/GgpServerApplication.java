package com.sunonrails.ggpserver;

import com.sunonrails.ggpserver.model.*;
import com.sunonrails.ggpserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
	private UsuarioService usuarioService;

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

		Cliente cli1 = new Cliente(null,"DANIEL","Rua Maria Pereira de Resende, 45",b1,"34997893234","25-03-2021");
		Cliente cli2 = new Cliente(null,"FLORIZA","Rua Nossa Senhora da Abadia",b2,"SEM NUMERO","30-05-2021");
		Cliente cli3 = new Cliente(null,"GUILHERME","Rua das Auracarias",b1,"34988790928","08-12-2020");
		Cliente cli4 = new Cliente(null,"GUSTAVO","Avenida Primeiro de Setembro",b2,"SEM NUMERO","01-08-2021");

		clienteService.insertList(Arrays.asList(cli1, cli2, cli3, cli4));

		//Instanciando Usuario de Teste

		Usuario usr1 = new Usuario(null, "daniel", 1);
		Usuario dev = new Usuario(null, "DEV", 1);

		usuarioService.insert(usr1);

		//Instanciando pedidos de Teste
		Date date;
		Date time;
		SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat fTime = new SimpleDateFormat("HH:mm:ss");

		String sDate = "2021-12-31";
		String sTime = "10:11:33";

		date = fDate.parse(sDate);
		time = fTime.parse(sTime);

		OrdemPedido ped1 = new OrdemPedido(null,cli1,usr1,"William",
				"DINHEIRO",
				"WHATSAPP","DAYANE",1);
		ped1.setEntradaDate(ped1.toDate(sDate));
		ped1.setEntradaHora(ped1.toTime(sTime));
		ped1.setTriagemHora(ped1.toTime(sTime));
		ped1.setCheckoutHora(ped1.toTime(sTime));
		ped1.setFinalizadoHora(ped1.toTime(sTime));
		ped1.setProdutos(Arrays.asList(prod1, prod2,prod3));
		ordemPedidoService.insert(ped1);
	}
}
