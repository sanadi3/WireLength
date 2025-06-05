import java.util.*;
import java.lang.*;

public class A3Q3 {


    public static double arduino(double[][] locations) {
        double wire = 0.0;
        int size = locations.length;


        boolean[] visited = new boolean[size];

        double[] distances = new double[size];

        distances[0] = 0.0;
        // initialize all to maX
        for(int d=1; d <size; d++){
            distances[d]=Double.MAX_VALUE;
        }

        int count = 0;
        // need to write how to get out of the loop
        while(count < size){
            // sentinel
            double min = Double.MAX_VALUE;
            // track current smallest distance index
            int k = -1;
            // find nearest unvisited node
            for(int i = 0; i< locations.length; i++){
                // would like to not loop over them anyway
                if(!visited[i] && distances[i] < min){
                min=distances[i];
                k = i;
                }
            }
            // k stores the index of the closest node to the mst
            // distances stores that distance

            // for example, on the first iteration of the loop
            // k = 0, since that distance was set
            // on the second iteration, k would be the next closest node to node 0
        
            
            // know which node to connect
            visited[k] = true;
            wire += Math.sqrt(min);
            count++;

            // in this loop, 
            // update each node's minimum distance to the tree
            // compare each distance to either what it was before
            // or the distance to the newest added node to the mst
            // this ensures that each node's distance to the mst 
            // is minimum through all iterations
            for (int i = 0; i < size; i++) {
                if (!visited[i]) {
                 distances[i] = Math.min(distances[i], distance_check(locations[i], locations[k]));
                }
            }
        }
        return wire;
}

    public static double distance_check(double[] cell1, double[] cell2){
        return Math.pow(cell2[0]-cell1[0], 2) + Math.pow(cell2[1]-cell1[1], 2);
    }
}
