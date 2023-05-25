public class TesteData {
    public static void main(String[] args) {
        Data data1 = new Data();
        System.out.println("Data 1: " + data1.mostra1());
        System.out.println("Data 2: " + data1.mostra2());
        System.out.println("Ano bissexto? " + data1.bissexto());
        System.out.println("Dias transcorridos: " + data1.diasTranscorridos());
        data1.apresentaDataAtual();
    }
}
