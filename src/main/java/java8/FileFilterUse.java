package java8;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class FileFilterUse {


    public static void main(String[] args) {


        File [] files=new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });

        files=new File(".").listFiles(File::canExecute);


        List<Apple> appleList=new ArrayList<>();

        //appleList.stream().filter(x->x.color.equals("green")).map()
    }


    class Apple{

        String color;
    }
}
