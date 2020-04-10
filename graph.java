import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class graph{
    private int a_map[][];
    private int v_map[][];
    private int nb_summit;
    private int graphNumber;
    private static final int NO_NEXT = -2;
    private static final int PROCESS_FINISH = -1;

    public L3_A7_Graph(String input_file_path) {
        file_to_graph(input_file_path);
    }
    
    public L3_A7_Graph(String input_file_path, int graphNumber) {
        file_to_graph(input_file_path);
        this.graphNumber = graphNumber;
    }

    /**
     * Fonction permettant de mettre en mémoire un graph passer en parametres
     * @param input_file_path Chemin amenant au fichier
     */
    private void file_to_graph(String input_file_path) {
        try {
            String[] splited;
            // Stockage de toutes les lignes du fichier dans une liste de String
            List<String> allLines = Files.readAllLines(Paths.get(input_file_path));
            System.out.println("Voici sa structure au sein du fichier :");
            // Affichage du graph dans sa forme texte
            for (String s : allLines)
                System.out.println(s);
            // Récupération du nombre de sommets
            System.out.println(allLines.get(0));
            nb_summit = Integer.parseInt(allLines.get(0));
            // Allocation des matrices d'adjacences et de valeurs en fonction du nombre de sommets
            a_map = new int[nb_summit][nb_summit];
            v_map = new int[nb_summit][nb_summit];
            // Pour des soucis de simplicité, on enlève la premiere ligne du fichier qui comporte le nombre de sommets
            allLines.remove(0);
            // Pour chacunes des lignes du fichiers
            for (String s : allLines) {
                splited = s.split(" "); // On sépare les élements selont les espaces et on remplit les matrices
                a_map[Integer.parseInt(splited[0])][Integer.parseInt(splited[2])] = 1;
                v_map[Integer.parseInt(splited[0])][Integer.parseInt(splited[2])] = Integer.parseInt(splited[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print_a()
    {
        print_array(a_map);
    }

    public void print_v()
    {
        print_array(v_map);
    }

    private void print_array(int[][] map) {
        System.out.print("\t\t ");
        for (int k = 0; k < nb_summit; k++)
        {
            System.out.printf("%5d", k);
        }
        System.out.println();
        for (int l = 0; l < nb_summit; l++)
        {
            if (l > 2)
                System.out.print("============");
            else
                System.out.print("\t");
        }
        System.out.println();
        for (int i = 0; i < nb_summit; i++)
        {
            System.out.printf("%5d\t|", i);
            for (int j = 0; j < nb_summit; j++)
            {
                if (map[i][j] != 0)
                    System.out.printf("%5d", map[i][j]);
                else
                    System.out.printf("%5c", '.');
            }
            System.out.println();
        }
    }