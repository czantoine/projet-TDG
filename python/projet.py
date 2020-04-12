
import numpy as np

def lecturefichier(texte):
    fichier = open(texte,"r") # ouverture en lecture (Read)
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
        if i == 0 or i == 1:
            L2.append(int(L[0][0]))
            del L[0]
    fichier.close() # on ferme le gestionnaire de fichier
    return L,L2


def creation(T):
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
    
    
def adjacence(T):
    S=creation(T)
    for k in range (len(T)):
        for i in range (1,len(S)):
            for l in range (1,len(S[0])):
            
                if T[k][0]==S[i][0] and T[k][1]==S[0][l]:
                    S[i][l]= 'V'
                 
    for i in range (1,len(S)):
        for l in range (1,len(S[0])):
            if S[i][l]!= 'V':
                S[i][l]='F'
                        
    return S

def valarc(T):
    S=adjacence(T)
    for i in range (1,len(S)):
        for l in range (1,len(S[0])):
            if S[i][l]== 'F':
                S[i][l]='*'
    for k in range (len(T)):
        for i in range (1,len(S)):
            for l in range (1,len(S[0])):
            
                if T[k][0]==S[i][0] and T[k][1]==S[0][l]:
                    S[i][l]= T[k][2]
    return S

def detcir(L2):
    n = len(L2)
    Lc = list(L2)
    Lf = list(Lc)
    Lr = list(Lc)
    stop = 0
    while stop == 0:
        n = len(Lc)
        for k in range (0,n):
            succ = 0
            prede = 0
            for j in range(0,n):
                if Lc[k][0] == Lc[j][1]:
                    prede = prede + 1
                if Lc[k][1] == Lc[j][0]:
                    succ = succ + 1
            if prede == 0 or succ == 0:
                Lf[k] = 0
        Lc = []
        nb = len(Lf)
        for p in range (0,nb):
            if Lf[p]!=0:
                Lc.apprend(Lf[p])
                if len(Lc) <= 1 or Lr==Lc:
                    stop = 1
                    Lf = list(Lc)
                    Lr = list(Lc)
                    if len(Lc) >=2:
                        print("")
                        print("Il y a au moins un circuit", Lc)
                        return True
                    else :
                        print("")
                        print("Il n'y a pas de circuit")
                        return False
            
    
 
def projet():


    Listearc, Listesomarc = lecturefichier(input("Nom du fichier:"))
    print("")
    print("La matrice d'ajacence de ce graphe est :")
    print("")
    matriceadj = np.asarray(adjacence(Listearc))
    print(matriceadj)
    print("")
    print("La matrice de la valeur des arcs est :")
    print("")
    matricevaleur = np.asarray(valarc(Listearc))
    print("")
    print(matricevaleur)
    circuit = detcir(Listearc)
    if circuit == False :
        print("")
        rangs = calcul_rang(adjacence(Listearc))
        print("")
        for i in range(len(rangs)):
            print("Sommets de ranges:",i)
            print(rangs[i])
        print("")
        ordo = ordonnancement(Listearc)
        if ordo == True :
            print("")
            dateplutot = plutot(Listearc,rangs)
            print("")
        
            
        
   
   
    
    return "ah sht here we go again"
    

projet()


