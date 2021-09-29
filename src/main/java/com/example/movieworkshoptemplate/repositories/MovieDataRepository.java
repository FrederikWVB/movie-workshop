package com.example.movieworkshoptemplate.repositories;

import com.example.movieworkshoptemplate.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDataRepository {


    public static ArrayList<Movie> readResources () {

        ArrayList<Movie> movieArrayList = new ArrayList<>();

        try {
        File movieData = new File("resources/imdb-data.csv");

        Scanner fileScanner = new Scanner(movieData);
        fileScanner.nextLine();

            while (fileScanner.hasNext()) {
                String currentLine = fileScanner.nextLine();
                String[] lineAsArray = currentLine.split(";");

                int year = Integer.parseInt(lineAsArray[0].strip());
                int length = Integer.parseInt(lineAsArray[1].strip());
                String title = lineAsArray[2].strip();
                String subject = lineAsArray[3].strip();
                int popularity = Integer.parseInt(lineAsArray[4].strip());
                boolean awards = true;
                if (lineAsArray[5].strip().equals("No")){
                    awards = false;
                }

                Movie tmp = new Movie(year, length, title, subject, popularity, awards);
                movieArrayList.add(tmp);
            }
        }
        catch (FileNotFoundException err){
            System.out.println("fejl: " + err);
        }

        return movieArrayList;
    }

}
