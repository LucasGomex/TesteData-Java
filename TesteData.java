public class TesteData {
    public static void main(String[] args) {
        // Criando uma instância de Data usando o construtor vazio
        Data data1 = new Data();

        // Exibindo a data no formato dd/mm/aaaa
        System.out.println("Data 1: " + data1.mostra1());

        // Exibindo a data no formato 5dd/mesPorExtenso/ano
        System.out.println("Data 2: " + data1.mostra2());

        // Verificando se o ano é bissexto
        System.out.println("Ano bissexto? " + data1.bissexto());

        // Obtendo a quantidade de dias transcorridos
        System.out.println("Dias transcorridos: " + data1.diasTranscorridos());
    
        data1.apresentaDataAtual();
    }
}
