 /**
* Fonction permettant de déterminer si le graph possède des arêtes négatives
* @return True si le graphe possède des arrètes négative, false sinon
*/
 public boolean arc_negative() {
    for (int i = 0; i < x.length; i++)
    {
        for (int j = 0; j < x[0].length; j++)
        {
            if (x[i][j] < 0)
                return (true);
        }
    }
    return (false);
}