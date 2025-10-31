package com.fatih.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private Player player;
    private Ground ground;
    private GameManager gameManager;

    private OrthographicCamera camera;
    private float cameraOffset = 0.2f;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();

        gameManager = GameManager.getInstance();

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.setToOrtho(false);

        player = new Player(new Vector2(100, Gdx.graphics.getHeight() / 2f));

        ground = new Ground();

        gameManager.startGame();
    }


    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        update(delta);

        ScreenUtils.clear(0.6f, 0.6f, 0.7f, 1f);

        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        ground.renderShape(shapeRenderer);

        player.renderShape(shapeRenderer);

        shapeRenderer.end();
    }

    private void update(float delta) {
        boolean isFlying = Gdx.input.isKeyPressed(Input.Keys.SPACE);

        updateCamera(delta);

        player.update(delta, isFlying);

        ground.update(camera.position.x);

        player.checkBoundaries(ground, Gdx.graphics.getHeight());

        int tempScore = (int) player.getDistanceTraveled();

        if (tempScore != gameManager.getScore()){
            gameManager.setScore(tempScore);
        }
    }

    private void updateCamera(float delta) {
        float cameraFocus = player.getPosition().x + player.getWidth() * cameraOffset;

        camera.position.x = cameraFocus;

        camera.update();
    }



    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

}
