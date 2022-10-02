import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.border.LineBorder;

public class Main{

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

                
        Album album = new Album("First Album", "Weekend");

        album.addSong("Blinding Lights", 3.5);
        album.addSong("save tears", 4.9);
        album.addSong("earned it", 4.3);
        albums.add(album);

        album = new Album("Second Album", "Eminem");

        album.addSong("I'm not afraid", 3.5);
        album.addSong("rap god", 4.5);
        albums.add(album);

        LinkedList<Song> playList1 = new LinkedList<>();
        albums.get(0).addToPlayList("Blinding Lights", playList1);
        albums.get(0).addToPlayList("save tears", playList1);
        albums.get(0).addToPlayList("earned it", playList1);

        albums.get(1).addToPlayList("I'm not afraid", playList1);
        albums.get(1).addToPlayList("rap god", playList1);

        play(playList1);


    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0)
        System.out.println("This playlist has no songs");

        else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0 : 
                   System.out.println("Playlist complete");
                   quit = true;
                   break;
                case 1 :
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                        
                    }   
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }
                    else{
                        System.out.println("No song available");
                        forward = false;
                    }
                    break;
                case 2 :    
                     if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                     }

                     if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                     }

                     else{
                        System.out.println("We are at the first song");
                        forward = false;
                     }
                     break;
                case 3 :
                      if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                          }
                          else{
                            System.out.println("We are at the start of the playlist");
                          }
                      }
                      else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("We have reached the end of list");
                        }
                      }
                      break;
                case 4 :  
                    printList(playList); 
                    break;
                case 5 : 
                    printMenu();
                    break;
                case 6 :
                     if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = true;
                        }

                        else{
                            if(listIterator.hasPrevious())
                            System.out.println("now playing " + listIterator.previous().toString());
                        }
                     } 

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
         "1 - to play next song\n" +
         "2 - to play previous song\n" +
         "3 - replay current song\n" + 
         "4 - list of all songs\n" + 
         "5 - print all available options\n" + 
         "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();

        System.out.println("---------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------------------");
    }
}