package ejercicio.alumno.curso;

public class Curso {

    private Integer id;
    private String nombreCurso;

    public Curso(){
    }

    public Curso(Integer id, String nombreCurso) {
        this.id = id;
        this.nombreCurso = nombreCurso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombreCurso='" + nombreCurso + '\'' +
                '}';
    }
}
