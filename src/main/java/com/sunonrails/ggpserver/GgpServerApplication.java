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

	@Autowired
	private OrderProductService orderProductService;

	@Autowired
	private ListaRupturaService listaRupturaService;

	@Autowired
	private RupturaProdutoService rupturaProdutoService;

	public static void main(String[] args) {
		SpringApplication.run(GgpServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Intanciando Produtos teste

		Produto prod1 = new Produto(null, "VEJA MULTIUSO");
		Produto prod3 = new Produto(null, "SABAO EM PO OMO");
		Produto prod2 = new Produto(null, "SALGADINHO DORITOS");




		/*
		PedidoProduto pedprod1 = new PedidoProduto(null, "Veja Multiuso");
		PedidoProduto pedprod3 = new PedidoProduto(null, "Sabao em Po OMO");
		PedidoProduto pedprod2 = new PedidoProduto(null, "Salgadinho Doritos");


		 */
		produtoService.insert(prod1);
		produtoService.insert(prod2);
		produtoService.insert(prod3);

		/*
		pedidoProdutoService.insert(pedprod1);
		pedidoProdutoService.insert(pedprod2);
		pedidoProdutoService.insert(pedprod3);


		 */

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
		Date date = new Date();
		Date time = new Date();
		SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		SimpleDateFormat fTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		String sDate = "2021-12-31";
		String sTime = "10:11:33";

		//date = fDate.parse(sDate);
		//time = fTime.parse(sTime);

		OrdemPedido ped1 = new OrdemPedido(null,cli1,usr1,"William",
				"DINHEIRO",
				"WHATSAPP","DAYANE",1);

		OrdemPedido ped2 = new OrdemPedido(null,cli2,usr1,"William",
				"DINHEIRO",
				"WHATSAPP","DAYANE",2);

		OrdemPedido ped3 = new OrdemPedido(null,cli3,usr1,"William",
				"DINHEIRO",
				"WHATSAPP","DAYANE",3);

		OrdemPedido ped4 = new OrdemPedido(null,cli4,usr1,"William",
				"DINHEIRO",
				"WHATSAPP","DAYANE",3);

		OrdemPedido ped5 = new OrdemPedido(null,cli2,usr1,"William",
				"DINHEIRO",
				"WHATSAPP","DAYANE",4);

		OrdemPedido ped6 = new OrdemPedido(null,cli1,usr1,"William",
				"DINHEIRO",
				"WHATSAPP","DAYANE",5);

		OrderProduct list1 = new OrderProduct(ped1, prod1, 3);
		OrderProduct list2 = new OrderProduct(ped1, prod2, 1);
		OrderProduct list3 = new OrderProduct(ped1, prod3, 4);

		ped1.setEntradaDate(sDate);
		ped1.setEntradaHora(time);
		ped1.setTriagemHora(time);
		ped1.setCheckoutHora(time);
		ped1.setEnviadoHora(time);
		ped1.setFinalizadoHora(time);
		ped1.setOrderProducts(Arrays.asList(list1, list2,list3));

		ped2.setEntradaDate(sDate);
		ped2.setEntradaHora(time);
		ped2.setTriagemHora(time);
		ped2.setCheckoutHora(time);
		ped2.setEnviadoHora(time);
		ped2.setFinalizadoHora(time);

		ped3.setEntradaDate(sDate);
		ped3.setEntradaHora(time);
		ped3.setTriagemHora(time);
		ped3.setCheckoutHora(time);
		ped3.setEnviadoHora(time);
		ped3.setFinalizadoHora(time);

		ped4.setEntradaDate(sDate);
		ped4.setEntradaHora(time);
		ped4.setTriagemHora(time);
		ped4.setCheckoutHora(time);
		ped4.setEnviadoHora(time);
		ped4.setFinalizadoHora(time);

		ped5.setEntradaDate(sDate);
		ped5.setEntradaHora(time);
		ped5.setTriagemHora(time);
		ped5.setCheckoutHora(time);
		ped5.setEnviadoHora(time);
		ped5.setFinalizadoHora(time);

		ped6.setEntradaDate(sDate);
		ped6.setEntradaHora(time);
		ped6.setTriagemHora(time);
		ped6.setCheckoutHora(time);
		ped6.setEnviadoHora(time);
		ped6.setFinalizadoHora(time);


		ordemPedidoService.insert(ped1);
		ordemPedidoService.insert(ped2);
		ordemPedidoService.insert(ped3);
		ordemPedidoService.insert(ped4);
		ordemPedidoService.insert(ped5);
		ordemPedidoService.insert(ped6);


		orderProductService.insert(list1);
		orderProductService.insert(list2);
		orderProductService.insert(list3);




		//Teste Lista-Ruptura
		ListaRuptura lista= new ListaRuptura(null, "Produtos de Teste");
		listaRupturaService.insert(lista);
		RupturaProduto rprod1 = new RupturaProduto(null, prod2, lista);
		RupturaProduto rprod2 = new RupturaProduto(null, prod3, lista);
		rupturaProdutoService.insert(rprod1);
		rupturaProdutoService.insert(rprod2);


	}

}
