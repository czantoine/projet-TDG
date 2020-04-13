
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


