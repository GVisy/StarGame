package ru.gb.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.gb.base.BaseButton;
import ru.gb.math.Rect;

public class ExitButton extends BaseButton {
    private static final float PADDING=0.01f;
    public ExitButton(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
    }

    @Override
    public void action() {
        Gdx.app.exit();

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.18f);
        setBottom(worldBounds.getBottom()+PADDING);
        setRight(worldBounds.getRight()-PADDING);
    }
}
