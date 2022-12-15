enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val id: Int, val nome: String)

data class Contact(var id: Int, var aluno : String?, var email: String?){
    constructor() : this(0, "", "")
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
}
  

fun matricular(usuario: Usuario, formacao: Formacao) {
       println("Aluno " + usuario.nome + " matriculado com sucesso no curso de: " + formacao.nome + " Nível "+ formacao.nivel)
     }


fun main() {
    
    
//---------------------------------USUARIOS    
val user1 = Usuario(1,"Claudius")
val user2 = Usuario(2,"Walber")
val user3 = Usuario(3,"Nobrega")
val user4 = Usuario(4,"Claudio")
val user5 = Usuario(5,"Joaquim")
val user6 = Usuario(6,"Adria")
// 1ª Maneira de carregar a lista de inscritos
val inscritos = mutableListOf<Usuario>(user1,user2,user3)

// função para carregar Usuários
fun addInscritosUser(newUser: Usuario) {                                 
    inscritos.add(newUser) }
// 2ª maneira de carregar a lista de inscritos	
    addInscritosUser(user4)
	addInscritosUser(user5)
	addInscritosUser(user6)
//cópia da listagem de Inscritos
val insc: List<Usuario> = inscritos 					

//Usando a cópia para fazer a leitura   
fun getInscritosUser(): List<Usuario> {                                 
  		 return insc }									
//Função para saber se um usuário está na listagem de inscrição    
fun estaInscrito(user : Usuario): Boolean{
    	val result = user  in insc
   		return (result) }
   
println("---------- INSCRITOS ----------")
//Para imprimir a Listagem de Inscritos
    insc.forEach {
    println(it.nome + " id: " + it.id)
}  
    
//Para imprimir os dados de determinado usuario 
with(user1){  
    println("$id) $nome")
}
// Criação de um usuario que não está na listagem de inscritos
val user_x  =  Usuario(7,"Araujo")

println("Verifica se determinado Usuário está inscrito  " +  estaInscrito(user_x))


//TODO("se usuario estiver na listagem de inscritos, então matricular")

println("---------- -------- ----------")  


// Carregando dados de Contato de um determinado usuario
val contato1 = Contact() 
// 1ª Maneira de carregar os Contatos de um determinado usuario
val contatoDetalhes = contato1.apply {                   
    id = user1.id
    aluno = user1.nome
    email = "cds1510@gmail.com"
}.toString()  
// 2ª Maneira de carregar os Contatos de um determinado usuario
val contato2 = Contact(user2.id, user2.nome, "pda@paisdeautistas.com.br")  

//associação de variáveis com a class Enum
val nivelBegin = Nivel.BASICO
val nivelMiddle = Nivel.INTERMEDIARIO
val nivelAdvanced = Nivel.AVANCADO

// Criando Conteúdos Educacionais    
val conteudoPHP1 = ConteudoEducacional("Introdução ao PHP", 1)
val conteudoPHP2 = ConteudoEducacional("Commandos Básicos", 2)
val conteudoPHP3 = ConteudoEducacional("Estruturas de Repetição", 1)
val conteudoJAVA1 = ConteudoEducacional("Introdução ao JAVA", 2)
val conteudoJAVA2 = ConteudoEducacional("Commandos Básicos", 2)
val conteudoJAVA3 = ConteudoEducacional("Estruturas de Repetição", 2)
 
// Imprime os dados de Contato de um determinado usuario  
println(contatoDetalhes)
println(contato2)
// imprime os dados de um determinado Conteúdo Educacional  
println(conteudoPHP1) 

// Carregando dados para determinada formação    
 var formacaoPHP = Formacao(nome = "PHP",listOf(conteudoPHP1,conteudoPHP2,conteudoPHP3), nivelBegin)
 var formacaoJAVA = Formacao(nome = "JAVA",listOf(conteudoJAVA1,conteudoJAVA2,conteudoJAVA3), nivelMiddle)
// imprime os dados de uma determinada Formação
      println(formacaoPHP)
// Realizar Matricula se Usuário estiver na listagem de inscritos      
val usuarioAMatricular = user2 
if (estaInscrito(usuarioAMatricular)){
  // matricular(usuarioAMatricular, formacaoPHP)
   matricular(usuarioAMatricular, formacaoJAVA)
}
else println("Não foi possível realizar a Matricula. O Usuário não está na Lista de Inscrição!")
}
