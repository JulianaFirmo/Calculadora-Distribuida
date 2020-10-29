import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Math;

public class JavaServerB {

    public static void main(String[] args) 	{
        try {
            ServerSocket s = new ServerSocket(10000);
            Float num1, num2, result;
            Double res;
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
                    operString = new String(operador).trim();
                    if(!operString.trim().equals("6")){
                        i.read(numero2);
                    }
                    try {
                        num1 = new Float(Float.parseFloat(new String(numero1).trim()));

                        System.out.print("Operação solicitada: " + operString);
                        System.out.println("\nValor 1: " + num1);
                        if (operString.trim().equals("5")) {
                            num2 = new Float(Float.parseFloat(new String(numero2).trim()));
                            System.out.println("Valor 2: " + num2);
                            result = num1*(num2/100);
                            resultString = result.toString();
                            System.out.println("Resultado: " + result);
                            o.write(resultString.getBytes());
                        } else if (operString.trim().equals("6")) {
                            res = Math.pow(num1,(0.5));
                            result = Float.parseFloat(String.valueOf(res));
                            resultString = result.toString();
                            System.out.println("Resultado: " + result);
                            o.write(resultString.getBytes());
                        } else if (operString.trim().equals("7")) {
                            num2 = new Float(Float.parseFloat(new String(numero2).trim()));
                            System.out.println("Valor 2: " + num2);
                            res = Math.pow(num1,num2);
                            result = Float.parseFloat(String.valueOf(res));
                            resultString = result.toString();
                            System.out.println("Resultado: " + result);
                            o.write(resultString.getBytes());
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