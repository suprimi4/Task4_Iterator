package com.example.task4;

import javafx.scene.image.Image;

public class ImageCollection  implements Aggregate{
    private  String filetopic;
    private Image bi;
    public ImageCollection(String filetopic){

        this.filetopic = filetopic;


    }
    private class ImageIterator implements Iterator {

        private int current=0;
        @Override
        public boolean hasNext(){


            String filename = filetopic+(current+1)+".jpg";
         
            bi = new Image(filename);
            System.out.println(filename);
            return true;
        }

        public boolean hasPrevious(){
            String filename = filetopic+(current-1)+".jpg";
            try {
                bi = new Image(filename);
                System.out.println(filename);
                return true;
            } catch (Exception ex){
                current = 5;
                System.err.println("Не удалось загрузить картинку!" +filename);
                ex.printStackTrace();
                return false;
            }

        }

        @Override
        public Object next() {
            if(this.hasNext()){
                current++;
                return bi;
            }
            return null;

        }

        @Override
        public Object preview() {
            if(this.hasPrevious()){
                current--;
                return bi;
            }
            return null;
        }
    }
    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
}
