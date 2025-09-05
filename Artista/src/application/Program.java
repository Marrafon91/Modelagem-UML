package application;

import java.util.Locale;

import entities.Album;
import entities.Artista;
import entities.Musica;


public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Artista a1 = new Artista(1, "Michael Jackson", "USA");
        Artista a2 = new Artista(2, "Ray Charles", "USA");

        Album alb1 = new Album(1, "Bad", 1987);
        Album alb2 = new Album(2, "Thriller", 1982);
        Album alb3 = new Album(3, "We are the World", 1985);

        Musica m1 = new Musica(1, "Smooth Criminal", 250);
        Musica m2 = new Musica(2, "Billy Jean", 300);
        Musica m3 = new Musica(3, "Beat it", 240);
        Musica m4 = new Musica(4, "We are the World", 390);

        // Relacionando álbuns com músicas
        alb1.adicionarMusica(m1);
        alb2.adicionarMusica(m2);
        alb2.adicionarMusica(m3);
        alb3.adicionarMusica(m4);

        // Relacionando artistas com álbuns
        a1.adicionarAlbum(alb1);
        a1.adicionarAlbum(alb2);
        a1.adicionarAlbum(alb3);
        a2.adicionarAlbum(alb3);

        // Exibindo informações
        System.out.println("Artista: " + a1);
        for (Album album : a1.getAlbuns()) {
            System.out.println("Album: " + album);
            for (Musica musica : album.getMusicas()) {
                System.out.println("Musica: " + musica);
            }
        }

        System.out.println();
        System.out.println("Artista: " + a2);
        for (Album album : a2.getAlbuns()) {
            System.out.println("Album: " + album);
            for (Musica musica : album.getMusicas()) {
                System.out.println("Musica: " + musica);
            }
        }
    }
}
