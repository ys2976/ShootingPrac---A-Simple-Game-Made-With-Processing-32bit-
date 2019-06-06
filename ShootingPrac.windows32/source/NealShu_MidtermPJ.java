import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class NealShu_MidtermPJ extends PApplet {

int currentScreen = 0;

final int startScreenNum = 0;
final int gameScreenNum = 1;
final int endScreenNum = 2;

public void setup(){  
  

  currentScreen = startScreenNum;
}

public void draw(){
  if(currentScreen == startScreenNum){
    startScreen();
  } else if(currentScreen == gameScreenNum){
  gameScreen();
  } else if(currentScreen == endScreenNum){
    endScreen();
  }
    
}

public void keyPressed(){
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

public void mousePressed(){
  if(currentScreen == endScreenNum){
    currentScreen = startScreenNum;
  }
  
  
}
public void endScreen(){
  background(0); 
  fill(255);
  text("CLICK MOUSE TO RESTART", 300, height/2);
  textSize(100);
}
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

public void setupGameScreen(){
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
public void gameScreen(){
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

public void pistol(){
  //rect(pistolPos.x, pistolPos.y, 50, 50);
  image(pistol, pistolPos.x, pistolPos.y, 100, 100);
}

public void target(float x, float y, int c){
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

public boolean bulletsOverTarget(float bulletX, float bulletY){
   if(bulletX > targetPos.x &&
      bulletX < targetPos.x + 45 &&
      bulletY > targetPos.y - 10 && 
      bulletY < targetPos.y + 35){
     return true;
   }
   return false;
}
PImage img;


public void startScreen(){
 //background(255, 255, 255);
 img = loadImage("shooting range.jpg");
 pistol = loadImage("pistol.png");
 bullet = loadImage("bullet.png");
 target = loadImage("target.png");
 //pubg = loadImage("pubg.jpg");
 image(img, 0, 0, width, height);
 fill(255);
 text("PRESS ANY KEY TO START", 350, height/2);
 textSize(100);
 
 
  
}
  public void settings() {  size(1920, 1080); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "NealShu_MidtermPJ" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
