# Condition de victoire-défaite / condition de nulle
# algorithme max / mini
# calcul de la plus grande valeur

import sys


win_condition = [(1,2,3), (4,5,6), (7,8,9), #lignes
                 (1,4,7), (2,5,8), (3,6,9), #colonnes
                 (1,5,9), (3,5,7) #diagonales
                 ]
def win_draw(tab_TTT):
    for win_liste in win_condition:
        if tab_TTT[win_liste[0]-1] == tab_TTT[win_liste[1]-1] == tab_TTT[win_liste[2]-1] == 'X': #victoire de X
            return 1
        if tab_TTT[win_liste[0]-1] == tab_TTT[win_liste[1]-1] == tab_TTT[win_liste[2]-1] == 'O': #victoire de O
            return -1
    if '-' not in tab_TTT:  # condition de nulle
        return 0
    return None       

def minimax(tab_TTT, joueur):
    result = win_draw(tab_TTT)
    if result is not None:
        return result, None
    else:
        if joueur == 1:
            meilleur_score = -float('inf')
            meilleur_case = None
            for chaque_case in range(len(tab_TTT)):
                if tab_TTT[chaque_case] == '-':
                    tab_TTT[chaque_case] = 'X'
                    score, _ = minimax(tab_TTT, 0)
                    tab_TTT[chaque_case] = '-'
                    if score > meilleur_score:
                        meilleur_score = score
                        meilleur_case = chaque_case
            return meilleur_score, meilleur_case
        else:
            meilleur_score = float('inf')
            for chaque_case in range(len(tab_TTT)):
                if tab_TTT[chaque_case] == '-':
                    tab_TTT[chaque_case] = 'O'
                    score, _ = minimax(tab_TTT, 1)
                    tab_TTT[chaque_case] = '-'
                    if score < meilleur_score:
                        meilleur_score = score
                        meilleur_case = chaque_case
            return meilleur_score, meilleur_case
        
if __name__ == '__main__':
    board = sys.argv[1]
    
    board_list = list(board)
    
    _, best_move = minimax(board_list, 0)

    if best_move is None:
        print(-1)
    else:
        print(best_move)