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
    fichier.close() # on ferme le gestionnaire de fichier
    return L,L2


def creation(T)
    L=[]
    for i in range (len(T)):
        L.append(T[i][0])
        L.append(T[i][1])
        L=list(set(L))
    L1=['']
    for i in L:
        L1.append(i)
    S=(len(L)+1)*[L1]
    for i in range (1,(len(L)+1)):
        S[i]=(len(L)+1)*[L[i-1]]
    return S
        
