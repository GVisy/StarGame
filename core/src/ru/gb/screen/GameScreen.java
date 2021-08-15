package ru.gb.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;
import ru.gb.math.Rect;
import ru.gb.sprite.Background;
import ru.gb.sprite.MainShip;
import ru.gb.sprite.Star;

public class GameScreen extends BaseScreen {
    private static final int STAR_COUNT=64;
    private Texture bg;
    private Background background;
    private TextureAtlas atlas;
    private Star[] stars;
    private MainShip mainShip;

    @Override
    public void show() {
        bg = new Texture("textures/2bg.jpg");
        background=new Background(bg);
        atlas=new TextureAtlas("textures/menuAtlas.tpack");
        stars=new Star[STAR_COUNT];
        for (int i=0;i<stars.length;i++){
            stars[i]=new Star(atlas);
        }
        mainShip =new MainShip(atlas);

    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (Star star:stars){
            star.resize(worldBounds);
        }
        mainShip.resize(worldBounds);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        mainShip.touchDown(touch, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        mainShip.touchUp(touch, pointer, button);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        mainShip.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        mainShip.keyUp(keycode);
        return false;
    }

    private void update(float delta){
        for (Star star:stars){
            star.update(delta);
        }
        mainShip.update(delta);
    }
    private void draw(){
        batch.begin();
        background.draw(batch);
        for (Star star:stars){
            star.draw(batch);
        }
        mainShip.draw(batch);
        batch.end();
    }
}