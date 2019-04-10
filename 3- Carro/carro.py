class Carro:
  def __init__ (self):
    self.gas = 0
    self.pess = 0
    self.km = 0
    self.gas_Max = 10
    self.pess_Max = 2

  def __str__(self):
    return "Pessoas: " + str(self.pess) + "/" + str(self.pess_Max) + " " + "Gas: " + str(self.gas) + "/" + str(self.gas_Max)+ " " + "km: " + str(self.km)


  def abastecer (self, gas):
    self.gas += gas
    if (self.gas > self.gas_Max):
      self.gas = self.gas_Max

  def entrar (self):
    if (self.pess < self.pess_Max):
      self.pess += 1
    else:
      print ("Falha:O carro esta lotado")

  def tirar(self):
    if self.pess > 0:
      self.pess -= 1

  def andar (self, distancia):
    if (self.pess == 0):
      print("Falha: Nao ha ninguem no carro")
      return

    gas_andar = distancia / 10
    if (self.gas >= gas_andar):
      self.km += distancia
      self.gas -= gas_andar
    else:
      print("gasolina insuficiente")
      
carro = Carro()
line = ""
print("Digite mostrar, iniciar, entrar, sair, abastecer _gas, andar _dist, sair")
while(line != "sair"):
  ui = input().split(" ")
  if ui[0] == "mostrar":
    print (carro)
  if ui[0] == "sair":
    break

  elif ui[0] == "abastecer":
    carro.abastecer(int(ui[1]))

  elif ui[0] == "entrar":
    carro.entrar() 
    
  elif ui[0] == "andar":
    carro.andar(int(ui[1]))
  else:
    print ("Comando invalido")
    
