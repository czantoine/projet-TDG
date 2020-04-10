def lecturefichier(texte):
    fichier = open(text,"r")
    L = []
    L2 = []
    for ligne in fichier:
        L.append(ligne)
    for i in range(0,len(L)):
        L[i] = L[i].replace('\n','')
        L[i] = L[i].split(" ")
        for j in range(0,len(L[i])):
        L[i][j] = int(L[i][j])
    for i in range(0,len(L)):
        if i i == 0 or i == 1:
            L2.append(int(L[0][0]))
            del L[0]
    fichier.close()
    return L,L2
