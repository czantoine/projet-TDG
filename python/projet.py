
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
            
def calcul_rang(Ta,Lf=[]):
    Lpe = []
    v = 1
    Li = Ta[0]
    Tar =  [Ta[0]]
    if len(Ta) == 1:
        return Lf
    else :
        for j in range (1,len(Ta[0])):
            for i in range (1,len(Ta)):
                if Ta[i][j] == 'F':
                    Val = False
                else :
                    Val = True
                    break
                if Val == False :
                    Lpe.append(Ta[v][0])
                else :
                    Tar = Tar+[Ta[j]]
                v+=1

def pointdentree(L2):
    LC = list(L2)
    Listefinale = []
    n = len(L2)
    for k in range (n):
        for j in range (n):
            if L2[k][0] == L2[j][1]:
                LC[k] = 0
    for p in range (0,n):
        if LC[p]!=0:
            Listefinale.append(LC[p][0])
    Listefinale = list(set(Listefinale))
    
    a= len (Listefinale)
    if a != 1 :
        print("Il y a plusieurs points d'entrées",Listefinale[0])
        return False
    if a == 1 :
        print("Il n'y a qu'un seul point d'entrée", Listefinale[0])
        return Listefinale[0]
    
def pointdesortie(L2):
    LC = list(L2)
    Listefinale = []
    n = len(L2)
    for k in range (n):
        for j in range (n):
            if L2[k][1] == L2[j][0]:
                LC[k] = 0
    for p in range (0,n):
        if LC[p]!=0:
            Listefinale.append(LC[p][1])
    Listefinale = list(set(Listefinale))
    
    a= len (Listefinale)
    if a != 1 :
        print("Il y a plusieurs points de sorties",Listefinale[0])
        return False
    if a == 1 :
        print("Il n'y a qu'un seul point de sorite", Listefinale[0])
        return Listefinale[0]
    
    
def arcnegatif(L2):
    a = 0
    n = len (L2)
    for k in range (n):
        if L2[k[2]]<0:
            print("L'arc",L2[k],"est de valeur négative")
            a = 1
    if a == 0 :
        return ("Il n'y a pas d'arc négatif")
    else :
        print("Il y a des arcs à valeurs négatives")
        return False
        
def valeursIdentiques(L2):
    n = len (L2)
    for k in range (n):
        for j in range (n):
            if L2[k][0] == L2[j][0]:
                if L2[k][0] != L2[j][0]:
                    print("Tous les arcs incidents vers l'extérieurs ne sont pas à valeurs identiques ")
                    return False
    print("valeurs identiques pour tous les arcs incidents vers l’extérieur à un sommet,")
    return True
                
    
def arcentreevaleurnulle(L2):
    pe = pointdentree(L2)
    n = len(L2)
    for i in range(n):
        if L2[i][0] == pe :
            if L2[i][2] != 0:
                print("Les valeurs des arcs ne sont pas égales à 0")
                return False
    print("Les valeurs des arcs sont égales à 0")
    return True

def ordonnancement(Listearc):
    Listordo = []
    pe = pointdentree(Listearc)
    Listordo.append(pe)
    ps = pointdesortie(Listearc)
    Listordo.append(ps)
    arcneg = arcnegatif(Listearc)
    Listordo.append(arcneg)
    valid = valeursIdentiques(Listearc)
    Listordo.append(valid)
    arcentreenul = arcentreevaleurnulle(Listearc)
    Listordo.append(arcentreenul)

    for i in range (0,len(Listordo)):
        if Listordo[0] == 0 :
            Listordo[0] = 1
        if Listordo[i] == False :
            print("Ce n'est pas un graphe d'ordonnecement")
            return False
    print(Listordo)
    print("Ce graphe est un graphe d'ordonnecement ")
    return True


def plutot(L2,Lrang):
    Ld = []
    
    for i in range (0,len(Lrang)):
        for p in range(0,len(Lrang[i])):
            Ld.append([Lrang[i][p]])
        for i in range(len(Ld)):
            Ld[i].append(-1)
        Ld[0][1] = 0
    for i in range(1,len(Lrang)):
        for p in range(0,len(Lrang[i])):
            L=[]
            for j in range(0,len(Lrang[i])):
                if Lrang[i][p] == L2 [j][1]:
                    for u in range (len(L2)):
                        if L2[j][0] == Ld[u][0]:
                            res = L2[j][2]+Ld[u][1]
                            L.append(res)
            for y in range(len(Ld)):
                if Lrang[i][p] == Ld[y][0]:
                    Ld[y][1] = max(L)
                    
    return Ld
                   
def plutard(L2,Lrang,Ld):
    LP = list(Ld)
    LP.reverse()
    Lrang.reverse()
    for i in range (1,len(Lrang)):
        for p in range (0,len(Lrang[i])):
            L = []
            for j in range (0,len(L2)):
                if Lrang[i][p]== L2[j][0]:
                    for u in range (len(LP)):
                        if L2[j][1] == LP[u][0]:
                            res = LP[u][1]- L2 [j][2]
                            L.append(res)
            for y in range (len,LP):
                if Lrang[i][p] == LP[y][0]:
                    LP[y][1] = min(L)
                    
    LP.reverse()
    return LP
         
def margetotale(Lplutard, Lplutot):
    Lc = list(Lplutard)
    margetot = 0
    for i in range (len(Lplutard)):
        margetot = Lplutard[i][1] - Lplutot[i][1]
        Lc[i][1] = margetot
    return Lc
                               
            
    

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
            print("Calendrier au plus tot :")
            print("")
            print(dateplutot)
            dateplutot = plutard(Listearc,rangs,dateplutot)
            print("")
            print("Calendrier au plus tard")
            print("")
            print(dateplutard)
            
        
   
   
    
    return "ah sht here we go again"
    

projet()


