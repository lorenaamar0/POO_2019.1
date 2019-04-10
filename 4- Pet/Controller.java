import java.util.Scanner;

class Pet{
    String nome;

    public int getEnergia() {
        return energia;
    }


    public void setEnergia(int energia) {
        if(energia >= this.energia_Max)
            this.energia = energia_Max;
        else if(energia <= 0) {
            this.energia = 0;
            this.vivo = false;
        }else
            this.energia = energia;
    }

    public int getSaciedade() {
        return saciedade;
    }

    public void setSaciedade(int saciedade) {
        if(saciedade >= this.saciedade_Max)
            this.saciedade = saciedade_Max;
        else if(saciedade < 0) {
            this.saciedade = 0;
            this.vivo = false;
        }else
            this.saciedade = saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza){
        if(limpeza > this.limpeza_Max){
            this.limpeza = this.limpeza_Max;
        }else if(limpeza < 0){
            this.limpeza = 0;
            this.vivo = false;
        }else{
            this.limpeza = limpeza;
        }
    }

    public boolean Vivo(){
        if(this.vivo)
            return true;
        System.out.println("falha: O pet morreu");
        return false;
    }

    public void Jogar(){
        if(!this.Vivo())
            return;
        this.setEnergia(this.getEnergia() - 2);
        this.setSaciedade(this.getSaciedade() - 1);
        this.setLimpeza(this.getLimpeza() - 3);

        this.diamantes += 1;
        this.idade += 1;
    }

    public void Comer(){
        if(!this.Vivo())
            return;
        this.setEnergia(this.getEnergia() - 1);
        this.setSaciedade(this.getSaciedade() + 4);
        this.setLimpeza(this.getLimpeza() - 2);

        this.idade += 1;
    }

    public void Dormir(){
        if(!this.Vivo())
            return;
        if(this.energia_Max - this.energia < 5){
            System.out.println("falha: O pet nao esta com sono");
            return;
        }
        this.idade += this.energia_Max - this.energia;
        this.setEnergia(this.getEnergia_Max());
    }

    private boolean vivo;
    private int energia;
    private int saciedade;
    private int limpeza;
    private int energia_Max;
    private int saciedade_Max;
    private int limpeza_Max;
    private int idade;

    public int getEnergia_Max() {
        return energia_Max;
    }

    public int getSaciedade_Max() {
        return saciedade_Max;
    }

    public int getLimpeza_Max() {
        return limpeza_Max;
    }

    public int getIdade() {
        return idade;
    }

    public int getDiamantes() {
        return diamantes;
    }

    private int diamantes;

    public Pet(String nome, int energia, int saciedade, int limpeza){
        this.nome = nome;
        this.energia = energia;
        this.energia_Max = energia;
        this.limpeza = limpeza;
        this.limpeza_Max = limpeza;
        this.saciedade = saciedade;
        this.saciedade_Max = saciedade;
        this.idade = 0;
        this.diamantes = 0;
        this.vivo = true;
    }

    @Override
    public String toString() {
        return "[" + this.nome + "] " +
                "E: " + this.energia + "/" + this.energia_Max + " " +
                "S: " + this.saciedade + "/" + this.saciedade_Max + " " +
                "L: " + this.limpeza + "/" + this.limpeza_Max + " " +
                "I: " + this.idade + " D:" + this.diamantes;
    }
 
}
public class Controller {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet("", 0, 0, 0);

        OUTER:
        System.out.println("iniciar _nome _E_S _L, sair, mostra");
        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            switch (ui[0]) {
                case "sair":
                    break;
                case "iniciar":
                    pet = new Pet(ui[1], Integer.parseInt(ui[2]),
                                         Integer.parseInt(ui[3]),
                                         Integer.parseInt(ui[4]));
                    break;
                case "mostrar":
                    System.out.println(pet);
                    break;
                case "comer":
                    pet.Comer();
                    break;
                case "jogar":
                    pet.Jogar();
                    break;
                case "dormir":
                    pet.Dormir();
                    break;
                default:
                    System.out.println("comando invalido");
                    break;
            }
        }
    }

}
