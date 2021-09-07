package com.potoware.recursividad.ejemplo;

import com.potoware.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinente PC Dell");
        Componente poder = new Componente("Fuente Poder 700W");
        Componente placaMadre = new Componente("MainBoard Dell sockets intel ");
        Componente cpu = new Componente("intel i7 8000X");
        Componente ventilador = new Componente("Ventilador 2800RPM");
        Componente discipador = new Componente("Discipador metalico");
        Componente tv = new Componente("Titan RTX 3000 30GB");
        Componente gpu = new Componente("Titan nvidia RTX");
        Componente gpuRam = new Componente("15GB");
        Componente gpuRam2 = new Componente("15GB");
        Componente gpuVentiladores = new Componente("Ventiladores");
        Componente ram = new Componente("Memoria RAM 32GB");
        Componente ssd = new Componente("Disco SSD 2TB");

        cpu.addComponente(ventilador).addComponente(discipador);
        tv.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);

        placaMadre.addComponente(cpu)
                .addComponente(tv)
                .addComponente(ram)
                .addComponente(ssd);

        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));

        metodoRecursivoStream(pc,0).forEach(c-> System.out.println("\t".repeat(c.getNivel()) +c.getNombre()));
    }

    public static Stream<Componente> metodoRecursivoStream(Componente c, int nivel){
        c.setNivel(nivel);
        return Stream.concat(Stream.of(c),
                c.getHijos().stream()
                        .flatMap(hijo-> metodoRecursivoStream(hijo,nivel+1)));

    }
    public static void metodoRecursivo(Componente c, int nivel){
        System.out.println("\t".repeat(nivel) + c.getNombre());
        if(c.tieneHijos()){
            for(Componente hijo: c.getHijos()){
                    metodoRecursivo(hijo, nivel +1);
            }
        }
    }
}
