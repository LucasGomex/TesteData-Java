import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        digitarData();
    }

    public Data(int d, int m, int a) {
        if (dataValida(d, m, a)) {
            dia = d;
            mes = m;
            ano = a;
        } else {
            System.out.println("Data inválida! Utilizando a data atual.");
            dataAtual();
        }
    }

    public void entraDia() {
        boolean diaValido = false;
        while (!diaValido) {
            System.out.print("Digite o dia: ");
            int d = lerInteiro();
            if (d >= 1 && d <= diasNoMes(mes, ano)) {
                dia = d;
                diaValido = true;
            } else {
                System.out.println("Dia inválido! Redigite.");
            }
        }
    }
    

    public void entraMes() {
        boolean mesValido = false;
        while (!mesValido) {
            System.out.print("Digite o mês: ");
            int m = lerInteiro();
            if (dataValida(dia, m, ano)) {
                mes = m;
                mesValido = true;
            } else {
                System.out.println("Mês inválido! Redigite.");
            }
        }
    }

    public void entraAno() {
        boolean anoValido = false;
        while (!anoValido) {
            System.out.print("Digite o ano: ");
            int a = lerInteiro();
            if (dataValida(dia, mes, a)) {
                ano = a;
                anoValido = true;
            } else {
                System.out.println("Ano inválido! Redigite.");
            }
        }
    }

    public int retDia() {
        return dia;
    }

    public int retMes() {
        return mes;
    }

    public int retAno() {
        return ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String mostra2() {
        String nomeMes = obterNomeMes(mes);
        return String.format("%02d/%s/%04d", dia, nomeMes, ano);
    }

    public boolean bissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
    }

    public int diasTranscorridos() {
        int totalDias = 0;

        for (int i = 1; i < mes; i++) {
            totalDias += diasNoMes(i, ano);
        }

        totalDias += dia;

        return totalDias;
    }

    public void apresentaDataAtual() {
        DateFormat formatoData = DateFormat.getDateInstance(DateFormat.FULL);
        Date dataAtual = new Date();
        String dataFormatada = formatoData.format(dataAtual);
        System.out.println("Data atual: " + dataFormatada);
    }

    private void digitarData() {
        entraDia();
        entraMes();
        entraAno();
    }

    private boolean dataValida(int d, int m, int a) {
        if (a < 0) {
            return false;
        }

        if (m < 1 || m > 12) {
            return false;
        }

        if (d < 1 || d > diasNoMes(m, a)) {
            return false;
        }

        return true;
    }

    private int diasNoMes(int m, int a) {
        if (m == 2) {
            return bissexto() ? 29 : 28;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private String obterNomeMes(int m) {
        String[] nomesMeses = {"", "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto",
                "setembro", "outubro", "novembro", "dezembro"};
        return nomesMeses[m];
    }
    
    private void dataAtual() {
        Date dataAtual = new Date();
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoData.format(dataAtual);
        String[] partesData = dataFormatada.split("/");
        dia = Integer.parseInt(partesData[0]);
        mes = Integer.parseInt(partesData[1]);
        ano = Integer.parseInt(partesData[2]);
    }

    private int lerInteiro() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
