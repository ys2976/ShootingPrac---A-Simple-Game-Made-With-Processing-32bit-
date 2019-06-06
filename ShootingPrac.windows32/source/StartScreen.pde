PImage img;


void startScreen(){
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
