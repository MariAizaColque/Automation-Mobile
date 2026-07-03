package TodoPasaje.Common;

/**
 * Created by Maribel on 12/21/2020.
 *
 */
public class TestMath {

    public static String generateUser() {
        String[] nombres = {"Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
                "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
                "Caritina", "Carlota", "Baltazar"};
        String[] apellidos = {"Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
                "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
                "Grigalva"};
        String login="";
        for (int i = 0; i < 1; i++) {
            String name = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))];
            String lastname = apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
            login = name + lastname + "@yopmail.com";
            System.out.println("login >"+login);
        }
        return login;
    }

}
