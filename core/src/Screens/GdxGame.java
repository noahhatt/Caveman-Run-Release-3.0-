package Screens;

import Scratch.ScrRockRdmScratch;
import com.badlogic.gdx.Game;

public class GdxGame extends Game {

    ScrMenu scrMenu;
    ScrPlay scrPlay;
    ScrContr scrContr;
    ScrRockRdmScratch scrRockRdmScratch;
    int nScreen;

   //Thanks Kieran
    
    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        if ( nScreen == 0) {
            setScreen(scrMenu);
        } else if (nScreen == 1) {
            setScreen(scrPlay);
        } else if (nScreen == 2) {
            setScreen(scrContr);
        } else if (nScreen == 3) {
            setScreen(scrRockRdmScratch);
        }
        
        
    }
    
    @Override
    public void create() {
        nScreen = 0;        
        scrMenu = new ScrMenu(this);
        scrPlay = new ScrPlay(this);
        scrContr = new ScrContr(this); 
        scrRockRdmScratch = new ScrRockRdmScratch(this);
        updateState(0);
        
        
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
