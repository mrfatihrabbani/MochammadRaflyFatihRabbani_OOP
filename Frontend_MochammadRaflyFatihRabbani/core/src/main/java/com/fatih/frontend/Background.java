package com.fatih.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
    private Texture backgroundTexture;
    private TextureRegion backgroundRegion;
    private float width, height;
    private float currentCameraX = 0f;

    public Background(){

        this.width = 2688f;
        this.height = 1536f;
    }

    public void update(float cameraX){
        currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch){
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        float scale = height / 

    }

    public void dispose(){
        if(backgroundTexture != null){
            backgroundTexture.dispose();
        }
    }
}
