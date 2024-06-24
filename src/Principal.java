import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        Moneda moneda = null;
        Scanner lectura = new Scanner(System.in);
        System.out.println("""
                Bienvenido al conversor de monedas
                En el siguiente menu seleccióna el tipo de conversión que deseas realizar
                """);
        boolean flag = true;
        do {
            System.out.println("""
                    1 Peso Mexicano a Peso Argentino
                    2 Peso Mexicano a Real brasileño
                    3 Peso Mexicano a Dólar estadounidense
                    4 Peso Argentino a Peso Mexicano
                    5 Real brasileño a Peso Mexicano
                    6 Dólar estadounidense a Peso Mexicano
                    7 Salir
                    """);
            var eleccion = lectura.nextInt();
            if(eleccion == 7){
                flag = false;
            }else {
                System.out.print("Introduce la cantidad a convertir: ");
                double cantidad = lectura.nextDouble();
                switch (eleccion) {
                    case 1:
                        moneda = consulta.realizaCambio("MXN", "ARS", cantidad);
                        break;
                    case 2:
                        moneda = consulta.realizaCambio("MXN", "BRL", cantidad);
                        break;
                    case 3:
                        moneda = consulta.realizaCambio("MXN", "USD", cantidad);
                        break;
                    case 4:
                        moneda = consulta.realizaCambio("ARS", "MXN", cantidad);
                        break;
                    case 5:
                        moneda = consulta.realizaCambio("BRL", "MXN", cantidad);
                        break;
                    case 6:
                        moneda = consulta.realizaCambio("USD", "MXN", cantidad);
                        break;
                    default:
                        System.out.println("Opción invalida\n");
                }
                if (moneda != null) {
                    System.out.println("Estas convirtiendo de " + moneda.base_code() + " a " + moneda.target_code());
                    System.out.println(cantidad + " " + moneda.base_code() + " son " + moneda.conversion_result() + " " + moneda.target_code() + "\n\n");
                    moneda = null;
                    System.out.println("Deseas realizar otra conversión?");
                    flag = lectura.next().equalsIgnoreCase("si") ? true : false;
                }
            }
        }while (flag);
        System.out.println("Gracias por usar mi conversor de monedas");
    }
}
