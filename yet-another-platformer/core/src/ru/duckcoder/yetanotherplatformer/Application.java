package ru.duckcoder.yetanotherplatformer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import lombok.Getter;
import ru.duckcoder.yetanotherplatformer.screen.PlayScreen;

public class Application extends Game {
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;

	@Getter
	private SpriteBatch spriteBatch;
	
	@Override
	public void create () {
		this.spriteBatch = new SpriteBatch();
		this.setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		this.spriteBatch.dispose();
	}
}
