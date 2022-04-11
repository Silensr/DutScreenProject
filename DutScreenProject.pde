import processing.serial.*;

Serial port; //initialisation des variables
String Sensval;
int val;

void setup()
{
  fullScreen(); //plein écran
  port = new Serial(this, "COM3", 9600); //Ouverture de la connexion en port série
  for(int j = 0; j<Serial.list().size(); j++ )
  print(Serial.list()[j]);
}

void draw()
{
  if(port.available() > 0)
  {
    background(0,0,0);
    
    Sensval = port.readStringUntil('\n');
  
    try
    {
      val = Integer.valueOf(Sensval.trim());
    }
    catch(Exception e){;}
    
    for(int i = 0; i <= map(val,0,1023,0,width); i++)
    {
      
      stroke(color(map(i,0,width,0,255),0,map(i,0,width,255,0)));
      line(i,0,i,height);
      println(map(i,0,width,0,255));
    }
    
    
    //println(val);
    
  }
}