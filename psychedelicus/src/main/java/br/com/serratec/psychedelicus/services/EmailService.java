package br.com.serratec.psychedelicus.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.serratec.psychedelicus.domain.Cliente;
import br.com.serratec.psychedelicus.domain.Pedido;
import br.com.serratec.psychedelicus.domain.Produto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	private String Username = "carlos.e.oliveira16@aluno.senai.br";
	private String Password = "fnrybwsodaysiqpd";
	
	@Autowired
	JavaMailSender emailSender;
	
	@Bean
	private JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties properties = new Properties();
		emailSender.setHost("smtp.gmail.com");
		emailSender.setPort(587);
		emailSender.setUsername(Username);
		emailSender.setPassword(Password);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		emailSender.setJavaMailProperties(properties);
		return emailSender;
	}
	
	public void confirmacaoCadastroProduto(String email, Produto produto) throws MessagingException {
		this.emailSender = javaMailSender();
		MimeMessage messageProduto = emailSender.createMimeMessage();
		MimeMessageHelper helperProduto = new MimeMessageHelper(messageProduto, true);
		try {
			helperProduto.setFrom("carlos.e.oliveira16@aluno.senai.br");
			helperProduto.setTo(email);
			helperProduto.setSubject(email);
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("   <head>\r\n");
			sBuilder.append("     <style>\r\n");
			sBuilder.append("       body {\r\n");
			sBuilder.append("         background-color: #000000;\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("         font-family: Arial, sans-serif;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       h1 {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       p {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .container {\r\n");
			sBuilder.append("         background-color: #gggggg;\r\n");
			sBuilder.append("         padding: 20px;\r\n");
			sBuilder.append("         text-align: center;\r\n");
			sBuilder.append("         margin: 0 auto;\r\n");
			sBuilder.append("         width: 80%;\r\n");
			sBuilder.append("         max-width: 1000px;\r\n");
			sBuilder.append("         border-radius: 10px;\r\n");
			sBuilder.append("         border: 3px solid #000000;\r\n");
			sBuilder.append("         box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .logo {\r\n");
			sBuilder.append("         display: block;\r\n");
			sBuilder.append("         margin: 0 auto;\r\n");
			sBuilder.append("         width: 200px;\r\n");
			sBuilder.append("         box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .thank-you {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("         font-size: 20px;\r\n");
			sBuilder.append("         margin-top: 20px;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("     </style>\r\n");
			sBuilder.append("   </head>\r\n");
			sBuilder.append("   <body>\r\n");
			sBuilder.append("     <div class=\"container\">\r\n");
			sBuilder.append("       <img class=\"logo\" src=\"https://source.unsplash.com/featured/?business&h=200&w=600\" alt=\"Imagem de capivara\">\r\n");
			sBuilder.append("       <h1>Cadastro de Produto</h1>\r\n");
			sBuilder.append("       <p>O medicamento " + produto.getNome() + " foi cadastrado com sucesso!</p>\r\n");
			sBuilder.append("       <p>Obrigado pela preferência!</p>\r\n");
			sBuilder.append("     </div>\r\n");
			sBuilder.append("   </body>\r\n");
			helperProduto.setText(sBuilder.toString(), true);
			emailSender.send(messageProduto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirmacaoCadastroCliente(String email, Cliente cliente) throws MessagingException {
		this.emailSender = javaMailSender();
		MimeMessage messageCliente = emailSender.createMimeMessage();
		MimeMessageHelper helperCliente = new MimeMessageHelper(messageCliente, true);
		try {
			helperCliente.setFrom("carlos.e.oliveira16@aluno.senai.br");
			helperCliente.setTo(email);
			helperCliente.setSubject(email);
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("   <head>\r\n");
			sBuilder.append("     <style>\r\n");
			sBuilder.append("       body {\r\n");
			sBuilder.append("         background-color: #000000;\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("         font-family: Arial, sans-serif;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       h1 {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       p {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .container {\r\n");
			sBuilder.append("         background-color: #gggggg;\r\n");
			sBuilder.append("         padding: 20px;\r\n");
			sBuilder.append("         text-align: center;\r\n");
			sBuilder.append("         margin: 0 auto;\r\n");
			sBuilder.append("         width: 80%;\r\n");
			sBuilder.append("         max-width: 1000px;\r\n");
			sBuilder.append("         border-radius: 10px;\r\n");
			sBuilder.append("         border: 3px solid #000000;\r\n");
			sBuilder.append("         box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .logo {\r\n");
			sBuilder.append("         display: block;\r\n");
			sBuilder.append("         margin: 0 auto;\r\n");
			sBuilder.append("         width: 200px;\r\n");
			sBuilder.append("         box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .thank-you {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("         font-size: 20px;\r\n");
			sBuilder.append("         margin-top: 20px;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("     </style>\r\n");
			sBuilder.append("   </head>\r\n");
			sBuilder.append("   <body>\r\n");
			sBuilder.append("     <div class=\"container\">\r\n");
			sBuilder.append("       <img class=\"logo\" src=\"https://source.unsplash.com/featured/?business&h=200&w=600\" alt=\"Imagem de capivara\">\r\n");
			sBuilder.append("       <h1>Cadastro de Usuário</h1>\r\n");
			sBuilder.append("       <p>O usuário " + cliente.getNome() + " foi cadastrado com sucesso!</p>\r\n");
			sBuilder.append("       <p>Obrigado pela preferência!</p>\r\n");
			sBuilder.append("     </div>\r\n");
			sBuilder.append("   </body>\r\n");
			helperCliente.setText(sBuilder.toString(), true);
			emailSender.send(messageCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirmacaoCadastroPedido(String email, Pedido pedido) throws MessagingException {
		this.emailSender = javaMailSender();
		MimeMessage messagePedido = emailSender.createMimeMessage();
		MimeMessageHelper helperPedido = new MimeMessageHelper(messagePedido, true);
		try {
			helperPedido.setFrom("carlos.e.oliveira16@aluno.senai.br");
			helperPedido.setTo(email);
			helperPedido.setSubject(email);
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("   <head>\r\n");
			sBuilder.append("     <style>\r\n");
			sBuilder.append("       body {\r\n");
			sBuilder.append("         background-color: #000000;\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("         font-family: Arial, sans-serif;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       h1 {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       p {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .container {\r\n");
			sBuilder.append("         background-color: #gggggg;\r\n");
			sBuilder.append("         padding: 20px;\r\n");
			sBuilder.append("         text-align: center;\r\n");
			sBuilder.append("         margin: 0 auto;\r\n");
			sBuilder.append("         width: 80%;\r\n");
			sBuilder.append("         max-width: 1000px;\r\n");
			sBuilder.append("         border-radius: 10px;\r\n");
			sBuilder.append("         border: 3px solid #000000;\r\n");
			sBuilder.append("         box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .logo {\r\n");
			sBuilder.append("         display: block;\r\n");
			sBuilder.append("         margin: 0 auto;\r\n");
			sBuilder.append("         width: 200px;\r\n");
			sBuilder.append("         box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("       .thank-you {\r\n");
			sBuilder.append("         color: #000000;\r\n");
			sBuilder.append("         font-size: 20px;\r\n");
			sBuilder.append("         margin-top: 20px;\r\n");
			sBuilder.append("       }\r\n");
			sBuilder.append("     </style>\r\n");
			sBuilder.append("   </head>\r\n");
			sBuilder.append("   <body>\r\n");
			sBuilder.append("     <div class=\"container\">\r\n");
			sBuilder.append("       <img class=\"logo\" src=\"https://source.unsplash.com/featured/?business&h=200&w=600\" alt=\"Imagem de capivara\">\r\n");
			sBuilder.append("       <h1>Confirmação de Pedido</h1>\r\n");
			sBuilder.append("       <p>Seu pedido foi realizado com sucesso às " + pedido.getDtHrPedido() + ".</p>\r\n");
			sBuilder.append("       <p>Obrigado pela preferência!</p>\r\n");
			sBuilder.append("     </div>\r\n");
			sBuilder.append("   </body>\r\n");
			helperPedido.setText(sBuilder.toString(), true);
			emailSender.send(messagePedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
