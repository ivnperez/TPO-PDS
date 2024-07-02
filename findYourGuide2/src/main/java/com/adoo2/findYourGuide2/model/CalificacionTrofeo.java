package com.adoo2.findYourGuide2.model;
import java.util.ArrayList;
import java.util.List;
public class CalificacionTrofeo {
    public List<Trofeo> listaTrofeo = new ArrayList<>();
    public Calificacion calificacion;

    public void setTrofeo(Trofeo trofeo){
        this.listaTrofeo.add(trofeo);
    }
    public void setCalificacion(Calificacion calificacion){
        this.calificacion = calificacion;
    }

    public List<Trofeo> getTrofeo(){
        return this.listaTrofeo;
    }
    public Calificacion getCalificacion(){
        return this.calificacion;
    }
    public boolean isTrofeoNull(Trofeo trofeo){
        return trofeo==null;
    }
    
}
