import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleJavaServer {

    public static void main(String[] args) 	{
        try {
            ServerSocket s = new ServerSocket(9999);
            Float num1, num2, result;
            String operString, resultString;
            while (true) {
                Socket c = s.accept();
                InputStream i = c.getInputStream();
                OutputStream o = c.getOutputStream();
                do {
                    System.out.println("\nO cliente se conectou ao servidor\n");
                    byte[] numero1 = new byte[100];
                    byte[] numero2 = new byte[100];
                    byte[] operador = new byte[100];
                    i.read(operador);
                    i.read(numero1);
                    i.read(numero2);
                    operString = new String(operador).trim();
                    try {
                        num1 = new Float(Float.parseFloat(new String(numero1).trim()));
                        num2 = new Float(Float.parseFloat(new String(numero2).trim()));
                        System.out.print("Operação solicitada: " + operString);
                        System.out.println("\nValor 1: " + num1);
                        System.out.println("Valor 2: " + num2);
                        if (operString.trim().equals("1")) {
                            result = num1 + num2;
                            resultString = result.toString();
                            System.out.println("Resultado: " + result);
                            o.write(resultString.getBytes());
                        } else if (operString.trim().equals("2")) {
                            result = num1 - num2;
                            resultString = result.toString();
                            System.out.println("Resultado: " + result);
                            o.write(resultString.getBytes());
                        } else if (operString.trim().equals("3")) {
                            result = num1 * num2;
                            resultString = result.toString();
                            System.out.println("Resultado: " + result);
                            o.write(resultString.getBytes());
                        } else if (operString.trim().equals("4")) {
                            try {
                                result = num1 / num2;
                                resultString = result.toString();
                                System.out.println("Resultado: " + resultString);
                                o.write(resultString.getBytes());
                            } catch (ArithmeticException e) {
                                resultString = "Erro! Divisão por 0";
                                System.out.println("Resultado: " + resultString);
                                o.write(resultString.getBytes());
                            }
                        }
                    } catch (NumberFormatException e) {
                        resultString = "Erro! Caracter invalido!!!\n" + "Digite somente numeros.\n";
                        System.out.println(e);
                        o.write(resultString.getBytes());
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                } while (!operString.trim().equals("0"));
                c.close();
            }
        } catch (Exception err) {
            System.err.println(err);
        }
    }
}