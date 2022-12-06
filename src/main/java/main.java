import java.lang.reflect.Array;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        int wall_arr[] = {4, 3, 1, 5, 7, 3, 4, 5, 7};


        Arrays.stream(wall_arr).forEach(System.out::print);
        System.out.println();
        Arrays.stream(water_filling(wall_arr)).forEach(System.out::print);


    }

    public static int[] water_filling(int[] wall) {
        int count = 0;
        for (int i = 1; i < wall.length-1; i++){
            int l_value = left_wall(wall, i);
            int r_value = right_wall(wall, i);
            if (( r_value != 0) && (l_value > r_value)) {
                wall[i] = r_value;
                count++;
            }
            else if (( l_value != 0) && (l_value <= r_value)) {
                wall[i] = l_value;
                count++;
            }
        }
        if (count != 0) water_filling(wall);
        return wall;
    }
    public static int left_wall(int[] wall, int n){
        int tmp = 0;
        for (int i = n-1; i > 0; i-- ){
            if (wall[i] > wall[n]) {
                tmp = wall[i];
                break;
            }
        }
        return tmp;
    }
    public static int right_wall(int[] wall, int n){
        int tmp = 0;
        for (int i = n+1; i < wall.length; i++ ){
            if (wall[i] > wall[n]) {
                tmp = wall[i];
                break;
            }
        }
        return tmp;
    }
}
