package Scratch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import Objects.Button;
import Objects.Hero;
import Objects.Rock;
import Screens.GdxGame;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.util.Random;

public class ScrRockRdmScratch implements Screen {

    GdxGame game;   
    SpriteBatch batch;
    boolean Hit;
    
    OrthographicCamera oc;
    Hero Hero1;
    Rock Rock;
    Random rand = new Random();    
    float fRockx;
    int nRstart = rand.nextInt(500) + 700;
    float fFallSpeed = 0;

    public ScrRockRdmScratch(GdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        oc = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        oc.update();
        batch = new SpriteBatch();
        Rock = new Rock(Gdx.graphics.getWidth() / 4 + 500f, Gdx.graphics.getHeight() / 2 + 100, 100f, 100f);
        Hero1 = new Hero(Gdx.graphics.getWidth() / 4 - 50f, Gdx.graphics.getHeight() / 2 + 100, 100f, 100f);
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(oc.combined);
        Hero1.draw(batch);
        Rock.draw(batch);        
        batch.end();
        KeyPressed();

        if (Hero1.getY() >= Gdx.graphics.getHeight() / 2 + 100) {
            fFallSpeed = 0;
        }
        if (Hero1.getY() < Gdx.graphics.getHeight() / 2 + 100) {
            fFallSpeed = fFallSpeed + 0.35f;
            Hero1.setY(Hero1.getY() + fFallSpeed);
        }
               
            Rock.setX(Rock.getX() - 6);
            fRockx = Rock.getX();
            System.out.println(fRockx);
        if (fRockx <= -200) {
            Random rand = new Random();    
            nRstart = rand.nextInt(500) + 700;
            Rock.setX(nRstart);
        }

        }
    

    public void KeyPressed() {
        if (Hero1.getY() >= Gdx.graphics.getHeight() / 2 + 100) {
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                fFallSpeed = -10;
                Hero1.setY(Hero1.getY() + fFallSpeed);
            }
        }
    }
    

    @Override
    public void resize(int i, int i1) {
        return;
    }

    @Override
    public void pause() {
        return;
    }

    @Override
    public void resume() {
        return;
    }

    @Override
    public void hide() {
        return;
    }

    @Override
    public void dispose() {
        return;
    }
}