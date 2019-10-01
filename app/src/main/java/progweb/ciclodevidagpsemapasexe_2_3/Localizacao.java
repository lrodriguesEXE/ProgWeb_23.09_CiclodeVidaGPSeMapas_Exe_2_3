package progweb.ciclodevidagpsemapasexe_2_3;

public class Localizacao {

    private static double lat;
    private static double lon;

    public Localizacao(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }

    public static double getLat() {
        return lat;
    }

    public static double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "Latitude: " + lat + " Longitude: " + lon + "";
    }


}
