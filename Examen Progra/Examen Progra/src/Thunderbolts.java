public class Thunderbolts {


    private int codigo;
    private String nombre;
    private String poderEspecial;
    private int nivelHabilidad;
    private String misionActiva;

    public Thunderbolts(int codigo, String nombre, String poderEspecial, int nivelHabilidad, String misionActiva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poderEspecial = poderEspecial;
        this.nivelHabilidad = nivelHabilidad;
        this.misionActiva = misionActiva;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoderEspecial() {
        return poderEspecial;
    }

    public void setPoderEspecial(String poderEspecial) {
        this.poderEspecial = poderEspecial;
    }

    public int getNivelHabilidad() {
        return nivelHabilidad;
    }

    public void setNivelHabilidad(int nivelHabilidad) {
        this.nivelHabilidad = nivelHabilidad;
    }

    public String getMisionActiva() {
        return misionActiva;
    }

    public void setMisionActiva(String misionActiva) {
        this.misionActiva = misionActiva;
    }
}

