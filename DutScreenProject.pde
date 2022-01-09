void setup(){
    size(400,200); //Ces tailles seront ammennées à être changées dans le futur.
    textSize(100); //Cette fonction permet de changer la taille du texte
    frameRate(30); //J'ai défini un framerate à 30 images par secondes.
}

int i=0; // Cette variable correspond à la transparence du texte. Elle sera modifié par la hauteur sonore mesurée.
boolean evo = true;
void draw(){
    background(0,0,0); //On crée un fond de couleur noir.
    // Normalement, on la place dans set-up, mais comme à chaque que l'on utilise text(), processing superpose directement, ça permet d'effacer le contenu.
    fill(255, 255, 255, i); //Cette fonction permet de régler la couleur et la transparence du texte.
    text("Hello !!", 0, 120); //Et celle là affiche la chaîne qui est placée en premier argument, aux coordonnées 


    //Cette partie du code sert à modifier la montée et la descente de la transparence du texte.
    if(evo){
        i++;
    }
    else{
        i--;
    }
    //La variable evo sert à faire alterner la transparence.
    if(i==255) evo = false;
    else if(i==0) evo = true;
}
