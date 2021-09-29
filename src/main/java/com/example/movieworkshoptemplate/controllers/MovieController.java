package com.example.movieworkshoptemplate.controllers;

import com.example.movieworkshoptemplate.models.Movie;
import com.example.movieworkshoptemplate.repositories.MovieDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MovieController {
    //Controller methods
    @GetMapping("/")
    public String index(){

        String one = " <a href=\"/getfirst\">getFirst</a> <br>";
        String two = " <a href=\"/getrandom\">getRandom</a> <br>";
        String three = " <a href=\"/gettensortbypopularirty\">getTenSortByPopularity</a> <br>";
        String four = " <a href=\"/howmanywonanaward\">howManyWonAnAward</a> <br>";
        String five = " <a href=\"/filter?first=x&second=1\">/filter?first=x&second=1</a> <br>";
        String six = " <a href=\"/getfirst\">getFirst</a> <br>";


        return "<h2>Hello World welcome to my application</h2><br>" +
                one + two + three + four + five;
    }

    @GetMapping("/getfirst")
    public String getFirst(){

        ArrayList<Movie> movieList = MovieDataRepository.readResources();

        String firstMovie = movieList.get(0).toString();

        return "<b>Første film:" + firstMovie + "</b>";
    }

    @GetMapping("/getrandom")
    public String getRandom(){
        int rand = Movie.randInt(1, 1500);

        ArrayList<Movie> movieList = MovieDataRepository.readResources();

        String randMovie = movieList.get(rand).toString();

        return "<b>Tilfældig film: " + randMovie + "</b>";
    }

    @GetMapping("/gettensortbypopularirty")
    public String getTenSortByPopularity(){
        ArrayList<Movie> movieList = MovieDataRepository.readResources();
        ArrayList<Movie> tenList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            int rand = Movie.randInt(1, movieList.size());
            Movie tmp = movieList.get(rand);

            boolean isBetter = true;
            int j = 0;
            while (isBetter && j < tenList.size()){
                if (tmp.getPopularity() >= tenList.get(j).getPopularity()){
                    tenList.add(j, tmp);
                    isBetter = false;
                }
                j++;
            }
            if (isBetter) tenList.add(tmp);
        }

        return "<h1>10 bedste tilfældige film:</h1> <br>" + tenList.toString();
    }

    @GetMapping("/howmanywonanaward")
    public String howManyWonAnAward(){

        ArrayList<Movie> movieList = MovieDataRepository.readResources();
        int awardSum = 0;

        for (int i = 0; i < movieList.size(); i++){
            if(movieList.get(i).isAwards()){
                awardSum++;
            }
        }

        return "<h2>Så mange film har vundet en pris:</h2><br>" + awardSum;
    }

    @GetMapping("/filter")
    public String filter (@RequestParam String first, String second){
        ArrayList<Movie> movieList = MovieDataRepository.readResources();
        StringBuilder charMovieList = new StringBuilder();

        System.out.println(first + second);

        char x = first.charAt(0);
        int n = Integer.parseInt(second);

        for (int i = 0; i < movieList.size(); i++){
            String currMovie = movieList.get(i).getTitle();
            int count =0;

            if(currMovie.indexOf(x) != -1){

                for(int j=0; j < currMovie.length(); j++){
                    if(currMovie.charAt(j) == x){
                        count++;
                    }
                }
            }

            if (count == n){
                charMovieList.append(movieList.get(i).getTitle()).append(" <br> ");
            }
        }

        return "<h2>Film indeholdende \"" + first + "\", \"" + second + "\" gange:</h2> <br>" + charMovieList;
    }

}
