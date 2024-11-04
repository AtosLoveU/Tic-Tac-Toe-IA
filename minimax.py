# Condition de victoire-défaite / condition de nulle
# algorithme max / mini
# calcul de la plus grande valeur

win_condition = [(1,2,3), (4,5,6), (7,8,9), #lignes
                 (1,4,7), (2,5,8), (3,6,9), #colonnes
                 (1,5,9), (3,5,7) #diagonales
                 ]
def win_draw(tab_TTT):
    for win_liste in win_condition:
        if tab_TTT[win_liste[0]-1] == tab_TTT[win_liste[1]-1] == tab_TTT[win_liste[2]-1] == 'X': #victoire de X
            print("+10")
            break
        if tab_TTT[win_liste[0]-1] == tab_TTT[win_liste[1]-1] == tab_TTT[win_liste[2]-1] == 'O': #victoire de O
            print("-10")
            break
    if sum(element.count('-') for element in tab_TTT) == 0: #condition de nulle
        print("nulle")
            
def minimax():
    null
            
            
def main():
    tab = ["X","O","O",
           "O","X","X",
           "X","O","O"]
    win_draw(tab)
    
main()