package com.fatih.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fatih.frontend.states.GameState;
import com.fatih.frontend.states.GameStateManager;
import com.fatih.frontend.states.PlayingState;

public class MenuState implements GameState {
    private GameStateManager gsm;
    private Stage stage;
    private Skin skin;
    private TextField nameField;
    private TextButton startButton;

    public MenuState(GameStateManager gsm){
        this.gsm = gsm;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        createBasicSkin();
        buildUI();
    }

    public void createBasicSkin(){
        skin = new Skin();
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        Pixmap white = new Pixmap(1,1, Pixmap.Format.RGB888);
        white.setColor(Color.WHITE);
        white.fill();
        skin.add("white", new Texture(white));

        Pixmap gray = new Pixmap(1,1, Pixmap.Format.RGB888);
        gray.setColor(Color.GRAY);
        gray.fill();
        skin.add("gray", new Texture(gray));

        Pixmap darkGray = new Pixmap(1,1, Pixmap.Format.RGB888);
        darkGray.setColor(Color.DARK_GRAY);
        darkGray.fill();
        skin.add("dark_gray", new Texture(darkGray));

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;
        skin.add("default",labelStyle);

        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();

        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.background = skin.getDrawable("dark_gray");
        textFieldStyle.cursor = skin.getDrawable("white");
        textFieldStyle.selection = skin.getDrawable("gray");
        skin.add("default", textFieldStyle);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("gray");
        textButtonStyle.down = skin.getDrawable("white");
        textButtonStyle.over = skin.getDrawable("dark_gray");
        skin.add("default", textButtonStyle);
    }

    public void buildUI(){
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label title = new Label("NETLAB JOYRIDE", skin);
        title.setFontScale(2f);

        Label prompt = new Label("Enter Your Name:", skin);

        nameField = new TextField("", skin);
        nameField.setMessageText("Username...");
        nameField.setAlignment(1);

        startButton = new TextButton("START GAME", skin);

        startButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                String inputName = nameField.getText();
                if(inputName.isEmpty()){
                    inputName = "Guest";
                }
                GameManager.getInstance().registerPlayer(inputName);
                gsm.set(new PlayingState(gsm));
            }

        });

        table.add(title).padBottom(40f).row();
        table.add(prompt).padBottom(10f).row();
        table.add(nameField).width(300f).height(50f).padBottom(20f).row();
        table.add(startButton).width(200f).height(60f);
    }


    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(SpriteBatch batch) {
        Gdx.gl.glClearColor(0.15f,0.15f,0.3f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
