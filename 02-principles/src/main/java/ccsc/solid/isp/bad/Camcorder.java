package ccsc.solid.isp.bad;

public class Camcorder implements DigitalKamera {
    @Override
    public void videoDrehen() {
    }

    @Override
    public void fotoAufnehmen() {
        throw new RuntimeException("Camcorder kann keine Fotos aufnehmen");
    }
}
