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
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        backgroundRegion = new TextureRegion(backgroundTexture);
        this.width = 2688f;
        this.height = 1536f;
    }

    public void update(float cameraX){
        currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float scale = screenHeight / height;

        float scaledWidth = width * scale;
        float scaledHeight = height * scale;

        float initialPosBG = currentCameraX - screenWidth / 2;

        int countTile = (int) (screenWidth / scaledWidth) + 2;

        for(int i = 0; i <= countTile; i++){
            int initialTile = (int)(initialPosBG / scaledWidth) + i;
            float tileUpdate = initialTile * scaledWidth;
            batch.draw(backgroundRegion, tileUpdate, 0, scaledWidth, scaledHeight);
        }

    }

    public void dispose(){
        if(backgroundTexture != null){
            backgroundTexture.dispose();
        }
    }
}
