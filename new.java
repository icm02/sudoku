SUDOKU:

relations
one board has one player
one player can have several boards

tile>>board>>player>>tester

BOARD
relations:
    -one board has many tiles
attributes:
    -dimension
    -level
functionality:
    -check if is finished
    -group tiles by row, column, box
    -setmove

TILE
relations:    
    -part of Board board

attributes
    state: permanent, full, empty
    value: 1-9, 0
    row: 1-9
    column: 1-9
    box: 1-9
    
functionality:
    change state
    change value

Player 
functionality:
    getmove
attributes:

Tester

functionality
play the game

Tile [9][9] board






00 01 02 03 04 05 06 07 08 //the positions in row zero

2  3  4  5  6  7  8  9  1 //the values (answers)



rowcollumn value
00 2 

"00" "2"













