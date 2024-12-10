public class App {
    public static void main(String[] args) throws Exception {
        Contactos contactos = new Contactos();
        ConexionDB conexionDB = new ConexionDB();

        AdminDB adminDB = new AdminDB(conexionDB);
        InputDB inputDB = new InputDB(contactos, adminDB);

        Menu menu = new Menu(inputDB);
         

        menu.menuSeleccion();
        }
}
