import java.util.ArrayList;
import java.util.Scanner;


class Passageiro{
    String id;
    int idade;   
    
    public Passageiro(String id,int idade){
        this.id = id;
        this.idade = idade;
    }
    
    
    public String toString (){
        return ""+ this.id + ":" +  this.idade; 
    }
    public boolean preferencial(){
        return idade >= 60; 
        
    }
}

class Topic{
    ArrayList <Passageiro> assento;
    int cadeira_Pref;
    int capacidade;
   
    public Topic(int capacidade,int cadeira_Pref){
        assento = new ArrayList <Passageiro>();
        for (int i = 0; i < capacidade; i++){
            assento.add(null); 
        }
        this.cadeira_Pref = cadeira_Pref;
     
    }
     
    @Override
    public String toString() {
        String saida = "[ ";
        for( int i = 0; i <assento.size();i++){
            if(i < this.cadeira_Pref){
                saida+= "@ ";
                        
            }else{
                saida += "= ";
                        
            }  
        }
            return saida + " ]";
    }
    public boolean inserir(int inicio, int fim, Passageiro pass){
        for(int i = inicio; i < fim; i++){
            if (assento.get(i) == null){
                assento.set(i, pass);
                return true;
            }
            
        }return false;
                
    }
    public void inserir(Passageiro pass){
        if (pass.preferencial()) {
            inserir(0, this.assento.size(), pass);
        }else {
            if(!inserir(this.cadeira_Pref, this.assento.size(), pass)){
                inserir(0, this.cadeira_Pref, pass);
            }
        }
    }
    public boolean remover(String id){
        for(int i = 0; i < assento.size(); i++){
            if(assento.get(i) != null){
                if(assento.get(i).id.equals(id)){
                    assento.set(i, null);
                    return true;
                }
            }
        }
        return false;
    } 
}

                    
public class Controller {
    public static void main(String[] args) {
        Topic topic = new Topic(0,0);
        Scanner scanner = new Scanner(System.in);
       
        while(true){
            String line = scanner.nextLine();
            String[]ui = line.split(" ");
        
            if (ui[0].equals ("iniciar")){
                topic = new Topic(Integer.parseInt(ui[1]),
                                  Integer.parseInt(ui[2]));
            }
                                   
            
            else if (ui[0].equals ("mostrar")){ 
                System.out.println(topic);
            } 
            
            
            else if (ui[0].equals ("inserir")){ 
               topic.inserir(new Passageiro(ui[1], Integer.parseInt(ui[2])));
               
            } else if(ui[0].equals("remover")){
                topic.remover((ui[1]));

            }else {
                System.out.println("falha: comando invalido");
            }
        
        }   
         
        
    } 
}   
            
       
            
    
            

