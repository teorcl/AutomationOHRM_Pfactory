package co.com.sofka.model.orangerecruitmentvacancies;

import co.com.sofka.util.Grade;

public class OrangeRecruitmentVacanciesModel {
    //Esta clase solo sirve para las modificaciones
    private String nombreVacante;
    private String gerenteDeContratacion;
    private String numeroVacantes;
    private String descripcion;
    private String comentario;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getNombreVacante() {
        return nombreVacante;
    }

    public void setNombreVacante(String nombreVacante) {
        this.nombreVacante = nombreVacante;
    }

    public String getGerenteDeContratacion() {
        return gerenteDeContratacion;
    }

    public void setGerenteDeContratacion(String gerenteDeContratacion) {
        this.gerenteDeContratacion = gerenteDeContratacion;
    }

    public String getNumeroVacantes() {
        return numeroVacantes;
    }

    public void setNumeroVacantes(String numeroVacantes) {
        this.numeroVacantes = numeroVacantes;
    }
}
