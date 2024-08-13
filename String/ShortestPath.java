package String;

public class ShortestPath {
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        int x=0,y=0;
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i) == 'W'){
                x -= 1;
            }else if(path.charAt(i) == 'E'){
                x += 1;
            }else if(path.charAt(i) == 'S'){
                y -= 1;
            }else{
                y += 1;
            }
        }
        double distane = 0;
        distane = Math.sqrt(x*x + y*y);

        String result = "";
        for(int i=0; i<Math.abs(x); i++){
            if(x<0){
                result += 'W';
            }else{
                result += 'E';
            }
        }
        for(int i=0; i<Math.abs(y); i++){
            if(y<0){
                result += 'S';
            }else{
                result += 'N';
            }
        }
        System.out.println("The Shortest Path is '" + result + "' and it's distance from origin is "+distane);
    }
}
