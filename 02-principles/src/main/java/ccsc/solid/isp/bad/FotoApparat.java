package ccsc.solid.isp.bad;

public class FotoApparat implements DigitalKamera {
    @Override
    public void videoDrehen() {
        throw new RuntimeException("FotoApparat kann keine Videos aufnehmen");
    }

    @Override
    public void fotoAufnehmen() {
    }
}
