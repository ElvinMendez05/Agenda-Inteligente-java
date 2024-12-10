import java.util.Scanner;

public class Menu {
    private InputDB inputDB;

    public Menu(InputDB inputDB){
        this.inputDB = inputDB;
    }
    
    private void menuBienvenida(){
        System.out.println("==========Agenda de contactos inteligente==========");
        System.out.println("Sea bienvenido. ¿Qué operación desea realizar?");
    };

    private void menuOpciones(){
        System.out.println("===================================================");
        System.out.println("1. Mostrar contactos...");
        System.out.println("2. Agregar un nuevo contacto...");
        System.out.println("3. Modificar un contacto existente...");
        System.out.println("4. Eliminar un contacto existente...");
        System.out.println("5. Salir.");
        System.out.println("===================================================");
        System.out.println("");
        System.out.println("Seleccione una operacion para continuar:");
    };

    public void menuSeleccion(){
        menuBienvenida();
        @SuppressWarnings("resource")
        Scanner lector = new Scanner(System.in);
        int seleccion = 0;

        do{
            menuOpciones();
        seleccion = lector.nextInt();

        if(seleccion == 1){
            FuncionesGenerales.clearConsole();
            System.out.println("Usted ha decidido mostrar los contactos.");
            inputDB.mostrar();
        }
        else if(seleccion == 2){
            FuncionesGenerales.clearConsole();
            System.out.println("Usted ha decidido agregar un nuevo contacto.");
            inputDB.insercion();
        }
        else if(seleccion == 3){
            FuncionesGenerales.clearConsole();
            System.out.println("Usted ha elegido modificar un contacto existente.");
            inputDB.actualizacion();
        }
        else if(seleccion == 4){
            FuncionesGenerales.clearConsole();
            System.out.println("Usted ha elegido eliminar un contacto existente.");
            inputDB.eliminacion();
        }
        else if(seleccion == 5){
            FuncionesGenerales.clearConsole();
            System.out.println("Usted ha elegido salir.");
            inputDB.cerrado();
            System.out.println("Saliendo...");
            
        }
        else{
            System.out.println("Opcion invalida. Intente nuevamente.");
        }
        }while(seleccion !=5);
    };
}