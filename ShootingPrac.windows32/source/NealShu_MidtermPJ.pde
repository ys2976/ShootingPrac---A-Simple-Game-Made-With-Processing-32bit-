int currentScreen = 0;

final int startScreenNum = 0;
final int gameScreenNum = 1;
final int endScreenNum = 2;

void setup(){  
  size(1920, 1080);

  currentScreen = startScreenNum;
}

void draw(){
  if(currentScreen == startScreenNum){
    startScreen();
  } else if(currentScreen == gameScreenNum){
  gameScreen();
  } else if(currentScreen == endScreenNum){
    endScreen();
  }
    
}

void keyPressed(){
  if(currentScreen == startScreenNum){
   currentScreen = gameScreenNum; 
   setupGameScreen();
  }
  
  if(currentScreen == gameScreenNum){
     if(key == 'w' || key == 'W'){
    pistolPos.y -= 15;
  }
  
     if(key == 's' || key == 'S'){
    pistolPos.y += 15;
  }
  
     //if(key == 'a'){
    //pistolPos.x -= 10;
  //}
  
     //if(key == 'd'){
    //pistolPos.x += 10;
  //} 
  }
}

void mousePressed(){
  if(currentScreen == endScreenNum){
    currentScreen = startScreenNum;
  }
  
  
}
