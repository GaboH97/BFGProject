/*
 * object to contain all items accessable to all control functions
 */
var attributes = {};

/*
 * choosing difficulty level (onclick span.level) behavior and control
 * when a level is clicked, it becomes highlighted and the "ai.level" variable
 * is set to the chosen level
 */
$(".gameModeInfo").each(function() {
  var $this = $(this);
  $this.click(function() {
    $('.selected').toggleClass('not-selected');
    $('.selected').toggleClass('selected');
    $this.toggleClass('not-selected');
    $this.toggleClass('selected');
  });
});

/* if an empty cell is clicked when the game is running and its the human player's trun
 * get the indecies of the clickd cell, craete the next game state, upadet the UI, and
 * advance the game to the new created state
 */
$(".cell").each(function() {
  var $this = $(this);
  $this.click(function() {
    //insert
    if (attributes.ticTacToe.isPlaying == true && !$this.hasClass('occupied')) {
      var indx = parseInt($this.data("indx"));
      var currTurn = attributes.ticTacToe.currentTurn;
      attributes.ticTacToe.board[indx] = currTurn;
      attributes.gui.insertAt(indx, currTurn);
      console.log(indx);
      //verifica si hay algun ganador y muestra el resultado
      if (attributes.ticTacToe.isWinningMove()) {
        attributes.result.showResult(currTurn + ' wins');
        attributes.ticTacToe.stop();
      }
      //cambio de turno
      attributes.ticTacToe.advanceTurn();
      if (attributes.ticTacToe.gameModeAuto == true) {
        //verifica si hay una posible perdida en todas las filas del tablero
        for (var i = 1; i <= 3; i++) {
          attributes.ticTacToe.checkRow(i);
          if (attributes.ticTacToe.location !== -1) {
            if (attributes.ticTacToe.board[attributes.ticTacToe.location] === attributes.ticTacToe.emptyChar) {
              attributes.ticTacToe.board[attributes.ticTacToe.location] = 'O';
              attributes.gui.insertAt(attributes.ticTacToe.location, 'O');
              attributes.ticTacToe.location = -1//despues de que haga el movimiento en el lugar indicado reinicia el valor location para que no se vuelva a usar
              attributes.ticTacToe.advanceTurn();
              if (attributes.ticTacToe.isWinningMove()) {
                attributes.result.showResult('O wins');
                attributes.ticTacToe.stop();
              }
              return;
            }
          }
        }
        //verifica si hay una posible perdida en todas las columnas del tablero
        for (var i = 0; i < 3; i++) {
          attributes.ticTacToe.checkCol(i);
          if (attributes.ticTacToe.location !== -1) {
            if (attributes.ticTacToe.board[attributes.ticTacToe.location] === attributes.ticTacToe.emptyChar) {
              attributes.ticTacToe.board[attributes.ticTacToe.location] = 'O';
              attributes.gui.insertAt(attributes.ticTacToe.location, 'O');
              attributes.ticTacToe.location = -1//despues de que haga el movimiento en el lugar indicado reinicia el valor location para que no se vuelva a usar
              attributes.ticTacToe.advanceTurn();
              if (attributes.ticTacToe.isWinningMove()) {//verifica si hay algun ganador y muestra el resultado
                attributes.result.showResult('O wins');
                attributes.ticTacToe.stop();
              }
              return;
            }
          }
        }
        //verifica si hay una posible perdida en la diagonal de izquierda a derecha
        attributes.ticTacToe.checkDiagonalLeft();
        if (attributes.ticTacToe.location !== -1) {
          if (attributes.ticTacToe.board[attributes.ticTacToe.location] === attributes.ticTacToe.emptyChar) {
            attributes.ticTacToe.board[attributes.ticTacToe.location] = 'O';
            attributes.gui.insertAt(attributes.ticTacToe.location, 'O');
            attributes.ticTacToe.location = -1//despues de que haga el movimiento en el lugar indicado reinicia el valor location para que no se vuelva a usar
            attributes.ticTacToe.advanceTurn();
            if (attributes.ticTacToe.isWinningMove()) {//verifica si hay algun ganador y muestra el resultado
              attributes.result.showResult('O wins');
              attributes.ticTacToe.stop();
            }
            return;
          }
        }
        //verifica si hay una posible perdida en la diagonal de derecha a izquierda
        attributes.ticTacToe.checkDiagonalright();
        if (attributes.ticTacToe.location !== -1) {
          if (attributes.ticTacToe.board[attributes.ticTacToe.location] === attributes.ticTacToe.emptyChar) {
            attributes.ticTacToe.board[attributes.ticTacToe.location] = 'O';
            attributes.gui.insertAt(attributes.ticTacToe.location, 'O');
            attributes.ticTacToe.location = -1//despues de que haga el movimiento en el lugar indicado reinicia el valor location para que no se vuelva a usar
            attributes.ticTacToe.advanceTurn();
            if (attributes.ticTacToe.isWinningMove()) {//verifica si hay algun ganador y muestra el resultado
              attributes.result.showResult('O wins');
              attributes.ticTacToe.stop();
            }
            return;
          }
        }
        //en caso de que no haya una perdida en ningun lado juega en la casilla del centro
        if (attributes.ticTacToe.board[4]=== attributes.ticTacToe.emptyChar) {
          attributes.ticTacToe.board[4] = 'O';
          attributes.gui.insertAt(4, 'O');
          attributes.ticTacToe.advanceTurn();
          if (attributes.ticTacToe.isWinningMove()) {//verifica si hay algun ganador y muestra el resultado
            attributes.result.showResult('O wins');
            attributes.ticTacToe.stop();
          }
          return;
        }
        //en casi de que ya haya jugado en el centro del tablero juega en la primera posicion vacia que encuentre
        for (var i = 0; i < 9; i++) {
          if(attributes.ticTacToe.board[i]=== attributes.ticTacToe.emptyChar){
            attributes.ticTacToe.board[i] = 'O';
            attributes.gui.insertAt(i, 'O');
            attributes.ticTacToe.advanceTurn();
            if (attributes.ticTacToe.isWinningMove()) {//verifica si hay algun ganador y muestra el resultado
              attributes.result.showResult('O wins');
              attributes.ticTacToe.stop();
            }
            return;
          }
        }
        //en caso de que el tablero se llene mostrara un empate
        attributes.result.showResult('tie');
        attributes.ticTacToe.stop();
      }
    }
  })
});

/*
 * start game (onclick div.start) behavior and control
 * when start is clicked and a level is chosen, the game status changes to "running"
 * and UI view to swicthed to indicate that it's human's trun to play
 */
$(".start").click(function() {
  var gameMode = $(".selected").attr("id");
  if (typeof gameMode !== "undefined") {
    attributes.gui = new Gui();
    attributes.ticTacToe = new TicTacToe();
    attributes.result = new Result();
    attributes.ticTacToe.start();
    attributes.gui.start();
    if (gameMode.toString() == "Single") {
      console.log("playing against PC");//aca es la cosa
      attributes.ticTacToe.gameModeAuto = true;
    } else {
      console.log("Playing against player 2.");
    }
  } else {
    alert('Please choose a game mode');
  }
});


$('a').click(function(){
  attributes.ticTacToe.clearBoard();
  attributes.gui.clearBoard();
});
