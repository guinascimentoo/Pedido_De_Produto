package entities;

import java.util.Date;
import entities.enums.StatusDoPedido;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    private Date moment;
    private StatusDoPedido status;   
    private Cliente client;
    
    private List<ItemDePedido> items = new ArrayList<>();

    public Pedido(Date moment, StatusDoPedido status, Cliente client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
    
    public List<ItemDePedido> getItems(){
        return items;
    }
    
    public void addItem(ItemDePedido item){
        items.add(item);
    }
    
    public void removeItem(ItemDePedido item){
        items.remove(item);
    }
    
    public double total(){
        double sum = 0.0;
        
        for(ItemDePedido item : items){
            sum += item.subTotal();
        }   
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(client + "\n");
        sb.append("Item do pedido: \n");
        
        for (ItemDePedido item: items){
            sb.append(item + "\n");
        }
        
        sb.append("Preço total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
        
    }  
}