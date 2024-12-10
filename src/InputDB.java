import java.util.Scanner;
import java.util.List;


public class InputDB {
    private Contactos contactos;
    private AdminDB adb;

    public InputDB(Contactos contactos, AdminDB adb){
        this.contactos = contactos;
        this.adb = adb;
    };

    @SuppressWarnings("unused")
    public void mostrar(){

        List<Contactos> lista = adb.mostrar();
        int contador = 0;

        for(Contactos contactos : lista){
            contador++;
        }

        if(contador != 0){
        System.out.println();
        System.out.println("=================Contactos guardados===============");
        for(Contactos contactos : lista) {
            System.out.println();
            System.out.println(contactos.getId()+ " - " + contactos.getNombre() + " " + contactos.getApellido()); 
            System.out.println("Correo: " + contactos.getCorreo()); 
            System.out.println("Telefono: " + contactos.getTelefono());  
            System.out.println("Empresa: " + contactos.getEmpresa());

        }
        System.out.println();
        System.out.println("===================================================");
        System.out.println();
        }
        else{
            System.out.println();
            System.out.println("No hay contactos guardados.");
            System.out.println();
        }
    }

    public void insercion(){
        @SuppressWarnings("resource")
        Scanner lector = new Scanner(System.in);

        String nombre;
        String apellido;
        String correo;
        String telefono;
        String empresa;
        
        System.out.println();
        System.out.println("Introduzca el/los nombres del contacto: ");
        nombre = lector.nextLine();
        contactos.setNombre(nombre);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el/los apellidos del contacto: ");
        apellido = lector.nextLine();
        contactos.setApellido(apellido);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el correo del contacto: ");
        correo = lector.nextLine();
        contactos.setCorreo(correo);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el teléfono del contacto: ");
        telefono = lector.nextLine();
        contactos.setTelefono(telefono);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el nombre de la empresa: ");
        empresa = lector.nextLine();
        contactos.setEmpresa(empresa);

        adb.insertar(contactos);
    }

    public void actualizacion(){
        @SuppressWarnings("resource")
        Scanner lector = new Scanner(System.in);

        int id;
        String nombre;
        String apellido;
        String correo;
        String telefono;
        String empresa;

            System.out.println();
            System.out.println("Introduzca el numero del indice del contacto a actualizar: ");
            id = lector.nextInt();
            contactos.setId(id);
    
        if(adb.comprobarID(id) == false){
                FuncionesGenerales.clearConsole();
                System.out.println("El numero introducido no existe, vuelva a intentarlo.");
                System.out.println();
         }else{
              
       

        
        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el/los nombres del contacto: ");
        nombre = lector.nextLine();
        contactos.setNombre(nombre);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el/los apellidos del contacto: ");
        apellido = lector.nextLine();
        contactos.setApellido(apellido);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el correo del contacto: ");
        correo = lector.nextLine();
        contactos.setCorreo(correo);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el teléfono del contacto: ");
        telefono = lector.nextLine();
        contactos.setTelefono(telefono);

        FuncionesGenerales.clearConsole();
        System.out.println("Introduzca el nombre de la empresa: ");
        empresa = lector.nextLine();
        contactos.setEmpresa(empresa);

        adb.actualizar(contactos);
        }
    }

    public void eliminacion(){
        @SuppressWarnings("resource")
        Scanner lector = new Scanner(System.in);

        int id;

        System.out.println();
        System.out.println("Introduzca el numero del indice del contacto a eliminar: ");
        id = lector.nextInt();
        contactos.setId(id);

        if(adb.comprobarID(id) == false){
            FuncionesGenerales.clearConsole();
            System.out.println("El numero introducido no existe, vuelva a intentarlo.");
            System.out.println();
        }else{
            adb.eliminar(contactos);
        }
    }

    public void cerrado(){
        adb.cerrar();
    }
}   
