int counter;
PVector targetPos;
int score;
int time;
PVector pistolPos;
PVector bullets[];
PVector bulletSpeed[];
PImage pistol;
PImage bullet;
PImage target;
//PImage pubg;

void setupGameScreen(){
  println("Go to gamescreen");
  
  counter = 2400;
  score = 0;
  time = counter/60;
  
  targetPos = new PVector(random(100, width-40), random(40, height-40));
  pistolPos = new PVector(0, 100);
  bullets = new PVector[100];
  bulletSpeed = new PVector[bullets.length];
  
  for(int i = 0; i < bullets.length; i++){
    bullets[i] = new PVector(pistolPos.x+100, pistolPos.y+20);
    bulletSpeed[i] = new PVector(30, 0);
  }
}
//1000 bullets were shot at one frame 
void gameScreen(){
  background(100, 150, 255);
  fill(255, 0, 0);
  rect(120,0,5,height);
  //image(pubg, 0, 0, width, height);
  fill(255);
  text("Current Score Is: "+score, width-300, 30);
  textSize(25);
  text("Time Left: "+ time, width-500, 30);
  textSize(25);
  
  if(counter%60 == 0){
    time = counter/60;
  }
  
  pistol();
  
  for(int i = 0; i < bullets.length; i++){
    fill(255, 255, 0);
    //circle(bullets[i].x, bullets[i].y, 20);
    image(bullet, bullets[i].x, bullets[i].y, 20, 20);
    bullets[i].add(bulletSpeed[i]);
    
    if(bullets[i].x > width){
      bullets[i] = new PVector(pistolPos.x+100, pistolPos.y+20);
    }
  }
  
  
  
  target(targetPos.x, targetPos.y, color(100, 100, 100));
  counter--;
  
  if(counter == 0){
    currentScreen = endScreenNum;
  } 
}

void pistol(){
  //rect(pistolPos.x, pistolPos.y, 50, 50);
  image(pistol, pistolPos.x, pistolPos.y, 100, 100);
}

void target(float x, float y, color c){
  //fill(0, 0, 0);
  //circle(x + 5,  y+12, 5);
  //circle(x + 15, y+12, 5);
  for(int i = 0; i < bullets.length; i++){
    if(bulletsOverTarget(bullets[i].x,bullets[i].y)){
      targetPos.set(random(100, width-40), random(40, height-40));
      score++;
      println("score: " + score);
    } 
  }
  //rect(x,y,20,10);
  image(target, x, y, 45, 45);
}

boolean bulletsOverTarget(float bulletX, float bulletY){
   if(bulletX > targetPos.x &&
      bulletX < targetPos.x + 45 &&
      bulletY > targetPos.y - 10 && 
      bulletY < targetPos.y + 35){
     return true;
   }
   return false;
}
