import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Cliente{
    String id;
    String nome;
    float saldo;
    
    public Cliente(String id, String nome, float saldo){
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        
    }
        
    @Override
        public String toString() {
                return this.id + ":" + this.nome + ":" + this.saldo;
                
        }

    private void add(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");  
    
class Sistema{
    int valor;
    ArrayList <Cliente> clientes;
    
    
    public Sistema(int valor){
        this.valor = valor;
        this.clientes = new ArrayList <Cliente>();
        
    }
    @Override
    public String toString() {
        String saida = "";
        for(Cliente cliente : clientes)
            saida += cliente + "\n";
        saida += "saldo:" + this.valor;
        return saida;
    }
    
     Cliente encontrarCli(String id){
        for(Cliente cli : clientes) {
            if (cli.id.equals(id))
                return cli;
        }
        return null;
 
     }
    
    void cadastrar(Cliente cliente){
        if (this.encontrarCli(cliente.id)!= null){
            System.out.println("Falha: id ja existe");
            return;
            
        }
        cliente.add(cliente);
    }   
  
    public void emprestar(String id, float valor){
       Cliente cli = encontrarCli(id);
            if(cli == null){
                System.out.println("falha: cliente nao existe");
                return;
        
            }
            this.valor -= valor;
            cli.saldo += valor;
   }
    public void transacoes
   public void devolver (String id, float valor) {
       if (encontrarCli(id)) {
           
       } else{
           System.out.println("falha: Cliente não existe");
       }
         
   }
}

class Controller{
    Sistema sistema = new Sistema(0);
    Scanner scanner = new Scanner(System.in);
    while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
        switch (ui[0]) {
            case "sair":
                break;
            case "iniciar":
                sistema = new Sistema((int) Float.parseFloat(ui[1]));
                break;
            case "mostrar":
                System.out.println(sistema);
                break;
            case "emprestar":
                sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
                break;
            case "cadastrar":
                String id = ui[1];
                break;
        }
            String[] subarray =  Arrays. copyOfRange(ui, 2, ui.length);
                String nome = String.join(" ", subarray);
                sistema.cadastrar(new Cliente( id, nome));

            }else{
                System.out.println("falha: comando invalido");
            }

        }
     }
   }
