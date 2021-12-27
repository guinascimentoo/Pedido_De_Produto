package PedidoDeProduto;

import entities.Cliente;
import entities.Pedido;
import entities.ItemDePedido;
import entities.Produto;
import entities.enums.StatusDoPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class PedidoDeProduto {

    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Digite os dados do cliente: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de nascimento (DD/MM/YYYY) ");
        Date birthDate = sdf.parse(sc.next());
        
        Cliente client = new Cliente (name, email, birthDate);
        
        System.out.println("Digite o status do pedido");
        System.out.print("Status do pedido: ");
        StatusDoPedido status = StatusDoPedido.valueOf(sc.next());
        
        Pedido order = new Pedido(new Date(), status, client);
        
        System.out.println("Quantos itens serão adicionados? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            
            System.out.println("Digite os dados do item número #" + i);
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Preço do produto: ");
            Double productPrice = sc.nextDouble();
            
            Produto product = new Produto(productName, productPrice);
            
            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();
            
            ItemDePedido orderItem = new ItemDePedido(quantity, productPrice, product);
            
            order.addItem(orderItem);
            
        }
        
        System.out.println();
        System.out.println("SUMÁRIO DO PEDIDO:");
        System.out.println(order);
        
    }
}