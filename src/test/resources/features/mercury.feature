#language: pt
#Author: Amanda Nascimento
@ReservarVoo
Funcionalidade: teste basico no Newtours
  Como um usuario 
  eu quero acessar o sistema
  para realizar reserva de voo

  Contexto: Realiza login no sistema
    Dado que acesso o link "http://www.newtours.demoaut.com/"
    Quando digito o valor de usuario e senha
    Entao clico em Sign-in

  Esquema do Cenario: ct01_ReservarVoo
    Dado que estou na tela flight finder
    Quando preencho os campos <Tipo>, <QtdPassageiros>, <Saida>, <MesSaida>, <DataSaida>, <Destino>, <MesChegada>,<DataChegada>, <ServiceClass> e <Airline>
    E clico em continue flight finder
    E que estou na tela Select Flight
    E seleciono o voo de ida <Ida>
    E seleciono o voo de volta <Volta>
    E clico em continue select flight
    E que estou na tela Book a Flight
    E valido Ida <Ida> e Volta <Volta>
    E preencho os campos Nome <FirstName>, Sobrenome <LastName> e Numero <Number>
    E clico em Secure Purchase
    Quando estou na tela Flight Confirmation
    Entao valido numero de confirmacao de reserva

    Exemplos: 
      | Tipo         | QtdPassageiros | Saida    | MesSaida | DataSaida | Destino    | MesChegada | DataChegada | ServiceClass  | Airline               | Ida                       | Volta                     | FirstName | LastName | Number         |
      | "Round Trip" | "1"            | "London" | "12"     | "20"      | "Acapulco" | "10"       | "21"        | "First class" | "Blue Skies Airlines" | "Blue Skies Airlines 361" | "Blue Skies Airlines 631" | "Teste"   | "Nextel" | "118989038904" |
