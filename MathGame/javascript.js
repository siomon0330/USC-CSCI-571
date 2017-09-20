var playing = false;
var score;
var action;
var timeremaining;
var correctAnswer;

//if we click on the start/reset button
document.getElementById("startreset").onclick = function () {
    "use strict";
    
    //if we are playing
    if (playing === true) {
        location.reload();//reload page
    } else {  //if we are not playing
        playing = true;
        score = 0;//set score to 0 
        document.getElementById("scorevalue").innerHTML = score;
        document.getElementById("timeremaining").style.display = "block";
        timeremaining = 60;
        document.getElementById("timeremainingvalue").innerHTML = timeremaining;
        
        hide("gameOver");
        document.getElementById("startreset").innerHTML = "Reset game";
        
        //start countdown
        startCountDown();
        
        //generate new questions and multiple answers
        generateQA();
        
    }
    
};


for(i = 1; i < 5; i++){
    //click answer box
document.getElementById("box"+i).onclick = function(){
    //check if we playing
    if(playing == true){
        if(this.innerHTML == correctAnswer){
              //correct
              score++;
              document.getElementById("scorevalue").innerHTML = score;
              //hide wrong box and show correct
              hide("wrong");
              show("correct");
              setTimeout(function(){
                  hide("correct");
                  
              }, 1000);
             //generate new QA
             generateQA();
            
           }else{
               //wrong answer
               hide("correct");
              show("wrong");
              setTimeout(function(){
                  hide("wrong");
                  
              }, 1000);
               
           }
        
    }
    
    
}
}


  //if we are playing
    //reload page
  //if we are not playing
   //show the countdown box, set score to 0
   //reduce time by 1sec in loops
       //timeleft?
          //yes-contunue
          //no-game over
       //change button to reset
       //generate new Question

//if we click on ansewer box
   //if we are playing
      //correct?
        //yes-increase score by 1, show correct box for 1 sec, generate new Q&A
     //wrong-show try again box for 1 sec

//functions

//start counter
function startCountDown(){
    action = setInterval(function(){
        timeremaining --;
        document.getElementById("timeremainingvalue").innerHTML = timeremaining;
        if(timeremaining == 0){
            //game over
            clearInterval(action);
            show("gameOver");
            document.getElementById("gameOver").innerHTML = "<p>game over</p><p>YOur score is "+ score +"</p>";
            hide("timeremaining");
            hide("correct");
            hide("wrong");
            playing = false;
            document.getElementById("startreset").innerHTML = "Start Game";
            
        }
    }, 1000);
}

//hide element
function hide(Id){
    document.getElementById(Id).style.display = "none";
}
        
//show element
function show(Id){
    document.getElementById(Id).style.display = "block";
}
        
////generate QA
function generateQA(){
    var x = Math.round(9 * Math.random()) + 1;
    var y = Math.round(9 * Math.random()) + 1;
    correctAnswer = x * y;
    document.getElementById("question").innerHTML = x + "X" + y;
    var correctPosition = Math.round(3 * Math.random()) + 1;
    document.getElementById("box"+correctPosition).innerHTML = correctAnswer;
    var answers = [correctAnswer];
    for(i = 1; i < 5; i++){
        if(i != correctPosition){
            var wrongAnswer;
            wrongAnswer = (Math.round(9 * Math.random()) + 1) * (Math.round(9 * Math.random()) + 1);
            while( answers.indexOf(wrongAnswer) > -1){
                wrongAnswer = (Math.round(9 * Math.random()) + 1) * (Math.round(9 * Math.random()) + 1);
            }
            document.getElementById("box"+i).innerHTML = wrongAnswer;
            answers.push(wrongAnswer);
        }
        
    }
    
    
    
    
}
   
        

        