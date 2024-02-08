package ru.duckcoder.yetanotherplatformer.scene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import lombok.Getter;
import ru.duckcoder.yetanotherplatformer.util.Timer;

public class Hud {
    @Getter
    private Stage stage;
    private OrthographicCamera cam;
    private Viewport viewport;
    private int score;
    private Timer worldTimer;
    private Timer playerTime;
    private String levelName;

    private Label scoreLabel;
    private Label timeLabel;
    private Label levelLabel;

    public Hud(SpriteBatch sb) {
        this.score = 0;
        this.worldTimer = Timer.fromMillis(150000L);
        this.playerTime = Timer.fromMillis(0L);
        this.levelName = "Test level";

        this.cam = new OrthographicCamera();
        this.viewport = new FitViewport(1280f, 720f, this.cam);
        this.stage = new Stage(this.viewport, sb);

        LabelStyle defaultStyle = new LabelStyle(new BitmapFont(), Color.WHITE);
        this.scoreLabel = new Label(String.format("Score: %d", this.score), defaultStyle);
        this.timeLabel = new Label(playerTime.toSimplifyString(), defaultStyle);
        this.levelLabel = new Label(levelName, defaultStyle);

        Table table = new Table();
        table.top();
        table.setFillParent(true);
        table.add(levelLabel).expandX().padTop(10f);
        table.add(timeLabel).expandX().padTop(10f);
        table.add(scoreLabel).expandX().padTop(10f);

        stage.addActor(table);
    }
}
