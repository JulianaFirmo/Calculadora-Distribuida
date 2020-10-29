import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleJavaClient {

    public static void main(String[] args) 	{
        try {
            Socket s = new Socket("localhost", 9999);
            Socket d = new Socket("localhost", 10000);
            InputStream iServerA = s.getInputStream();
            OutputStream oServerA = s.getOutputStream();
            InputStream iServerB = d.getInputStream();
            OutputStream oServerB = d.getOutputStream();
            String operString, resultString;
            do {
                byte[] oper = new byte[100];
                byte[] num2 = new byte[100];
                byte[] num1 = new byte[100];
                byte[] result = new byte[100];
                System.out.println("Escolha uma opção: " + "\n1-Soma\n2-Subtração\n3-Multiplicação\n4-Divisão\n5-Porcentagem\n6-Raiz quadrada\n7-Potenciação\n0-Sair");
                System.in.read(oper);
                operString = new String(oper).trim().toLowerCase();
                if ((operString.equals("1")) || (operString.equals("2")) || (operString.equals("3")) || (operString.equals("4"))) {
                    System.out.println("\nConectado ao servidor A, Port:9999");
                    System.out.println("\nInforme o primeiro numero: ");
                    System.in.read(num1);
                    System.out.println("\nInforme o segundo numero: ");
                    System.in.read(num2);
                    oServerA.write(oper);
                    oServerA.write(num1);
                    oServerA.write(num2);
                    iServerA.read(result);
                    resultString = new String(result);
                    System.out.println("\nResultado: " + resultString);
                } else if((operString.equals("5"))){
                    System.out.println("\nConectado ao servidor B, Port:10000");
                    System.out.println("\nInforme o numero: ");
                    System.in.read(num1);
                    System.out.println("\nInforme a porcentagem a ser calculada: ");
                    System.in.read(num2);
                    oServerB.write(oper);
                    oServerB.write(num1);
                    oServerB.write(num2);
                    iServerB.read(result);
                    resultString = new String(result);
                    System.out.println("\nResultado: " + resultString);
                }else if((operString.equals("6"))){
                    System.out.println("\nConectado ao servidor B, Port:10000");
                    System.out.println("\nInforme o numero: ");
                    System.in.read(num1);
                    oServerB.write(oper);
                    oServerB.write(num1);
                    iServerB.read(result);
                    resultString = new String(result);
                    System.out.println("\nResultado: " + resultString);
                }else if((operString.equals("7"))){
                    System.out.println("\nConectado ao servidor B, Port:10000");
                    System.out.println("\nInforme o numero: ");
                    System.in.read(num1);
                    System.out.println("\nInforme a potencia: ");
                    System.in.read(num2);
                    oServerB.write(oper);
                    oServerB.write(num1);
                    oServerB.write(num2);
                    iServerB.read(result);
                    resultString = new String(result);
                    System.out.println("\nResultado: " + resultString);
                }
            } while (!operString.trim().equals("0"));
            s.close();
            d.close();
        } catch (Exception err) {
            System.err.println(err);
        }
    }
}
