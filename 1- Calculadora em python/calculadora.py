class Calc:
    
    def __init__(self, bateriaMax):
        self.bateria = 0
        self.bateriaMax = bateriaMax
    
    def gastarBateria(self):
        if(self.bateria == 0):
            print("falha: bateria insuficiente")
            return False
        
        self.bateria -= 1
        return True

    def soma(self, a, b):
        if(self.gastarBateria()):
            print(a + b)
    
    def subtracao(self, a, b):
        if(self.gastarBateria()):
          print (a - b)
           

    def multiplicar(self, a, b):
        if(self.gastarBateria()):
          print(a * b)

    def divisao(self, num, den):
        if(self.gastarBateria()):
            print(num /den)
    

    def carregar(self, valor):
        self.bateria += valor
        if(self.bateria > self.bateriaMax):
            self.bateria = self.bateriaMax

    def __str__(self):
        return "bateria = " + str(self.bateria) + "/ " + "bateriaMax = " + str(self.bateriaMax)

calc = Calc(0)

print("mostrar, iniciar _bateriaMax, carregar _valor, somar _a _b, dividir _num _den, multiplicar _a, _b, subtrair _a, _b")
while True:
    ui = input().split(" ")
    if ui[0] == "sair":
        break

    elif ui[0] == "iniciar":
        calc = Calc(int(ui[1]))

    elif ui[0] == "mostrar":
        print(calc)

    elif ui[0] == "somar":
        calc.soma(int(ui[1]), int(ui[2]))

    elif ui[0] == "subtrair":
        calc.subtracao(int(ui[1]), int(ui[2]))

    elif ui[0] == "dividir":
        calc.divisao(int(ui[1]), int(ui[2]))

    elif ui[0] == "carregar":
        calc.carregar(int(ui[1]))
      
    elif ui[0] == "multiplicar":
        calc.multiplicar(int(ui[1]), int(ui[2]))
    else:
        print("comando invalido")