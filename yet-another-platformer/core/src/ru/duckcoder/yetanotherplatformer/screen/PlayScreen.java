package ru.duckcoder.yetanotherplatformer.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import ru.duckcoder.yetanotherplatformer.Application;
import ru.duckcoder.yetanotherplatformer.scene.Hud;

public class PlayScreen implements Screen {
    private final Application app;

    private final OrthographicCamera cam;

    private final Viewport viewport;

    private final Texture texture;

    private Hud hud;

    public PlayScreen(Application app) {
        this.app = app;
        this.cam = new OrthographicCamera();
        this.viewport = new FitViewport(Application.V_WIDTH, Application.V_HEIGHT, cam);

        this.texture = new Texture("shrek.png");
        this.hud = new Hud(app.getSpriteBatch());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.75f, 0.75f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        float tR = (float) this.texture.getWidth() / (float) this.texture.getHeight();
        float tW = 200f;
        float tH = tW / tR;
        float tX = /*Gdx.graphics.getWidth() / 2f*/ 0f - tW / 2f;
        float tY = /*Gdx.graphics.getHeight() / 2f*/ 0f - tH / 2f;

        this.app.getSpriteBatch().setProjectionMatrix(cam.combined);
        this.app.getSpriteBatch().begin();
        this.app.getSpriteBatch().draw(this.texture, tX, tY, tW, tH);
        this.app.getSpriteBatch().end();

        this.app.getSpriteBatch().setProjectionMatrix(hud.getStage().getCamera().combined);
        hud.getStage().draw();
    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
