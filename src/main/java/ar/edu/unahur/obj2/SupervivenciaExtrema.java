package ar.edu.unahur.obj2;

public class SupervivenciaExtrema extends Entrenamiento {

    public SupervivenciaExtrema(Alma alma) {
        super(alma);
        getAlma().setFriolenta(false);
    }

    @Override
    public void setFriolenta(boolean friolenta) {
        getAlma().setFriolenta(false);
    }




}
