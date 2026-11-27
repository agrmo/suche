package suche.tiefe.elter;

import graph.Graph;
import graph.gewicht.Gewichtgraph;
import java.util.Arrays;

public class Main {
    
    public static void beispieleins() {
        //
        //           4       3
        //            \     /
        //             1   2
        //              \ /
        //          12-6-0-5-11
        //              / \
        //             7   8
        //            /     \
        //           9      10
        //

        // Soll etwas sinnvolles geben.
        int[][] paare = {{0,1},{0,2},{0,5},{0,6},{0,7},{0,8},
                         {1,4},{2,3},{5,11},{8,10},{7,9},{6,12}};
	
        int groesse = 13;
        Graph g = new Graph(paare, groesse);

        int[] elter = Tiefensucheelter.suche(g, 0);
        System.out.println(Arrays.toString(elter));
    }

    public static void beispielzwei() {
        // 
        //   2   5      1
        // 1 - 7 - 3 ------4   
        //     \   |        \
        //     4\  |2        \3 
        //       \ | 1     3  \   3
        //        0-----8------2------5
        //         \   /        \
        //         9\ /1         \2
        //           10           \
        //                         6
        //                          \
        //                           \3
        //                            \
        //                             9
        //                             

        int n = 11;
        int[][] kanten = {{1,7,2},{7,3,5},{3,4,1},
                          {7,0,4},{3,0,2},{4,2,3},
                          {0,8,1},{8,2,3},{2,5,3},
                          {0,10,9},{8,10,1},{2,6,2},
                          {6,9,3}};
	
        Gewichtgraph g = new Gewichtgraph(n, kanten);

        int[] elter = Tiefensucheelter.suche(g, 1);
        System.out.println(Arrays.toString(elter));
    }
    
    public static void main(String[] args) {
        beispielzwei();
    }
}
