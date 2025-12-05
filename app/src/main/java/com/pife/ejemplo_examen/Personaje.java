package com.pife.ejemplo_examen;


// parametros en el contructor: nombre, valoracion, imagen, favorito, actorOriginal, imagenActor, pelicula
public class Personaje {
      String nombre, actorOriginal, pelicula, descripcion;
      float valoracion;
      int imagen, imagenActor;
      boolean favorito;

      public Personaje(String nombre, float valoracion,  int imagen, boolean favorito, String actorOriginal, int imagenActor, String pelicula) {
            this.nombre = nombre;
            this.actorOriginal = actorOriginal;
            this.pelicula = pelicula;
            this.descripcion = descripcion;
            this.valoracion = valoracion;
            this.imagen = imagen;
            this.imagenActor = imagenActor;
            this.favorito = favorito;
      }

      public String getNombre() {
            return nombre;
      }

      public void setNombre(String nombre) {
            this.nombre = nombre;
      }

      public String getActorOriginal() {
            return actorOriginal;
      }

      public void setActorOriginal(String actorOriginal) {
            this.actorOriginal = actorOriginal;
      }

      public String getPelicula() {
            return pelicula;
      }

      public void setPelicula(String pelicula) {
            this.pelicula = pelicula;
      }

      public String getDescripcion() {
            return descripcion;
      }

      public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
      }

      public float getValoracion() {
            return valoracion;
      }

      public void setValoracion(float valoracion) {
            this.valoracion = valoracion;
      }

      public int getImagen() {
            return imagen;
      }

      public void setImagen(int imagen) {
            this.imagen = imagen;
      }

      public int getImagenActor() {
            return imagenActor;
      }

      public void setImagenActor(int imagenActor) {
            this.imagenActor = imagenActor;
      }

      public boolean isFavorito() {
            return favorito;
      }

      public void setFavorito(boolean favorito) {
            this.favorito = favorito;
      }
}
