package com.visualg.animations.fractals.multibrot;


import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MultibrotSetInputProcessor implements InputProcessor {

    private final MultibrotSetController multibrotSetController;

    private boolean ctrlPressed = false;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                if (ctrlPressed) {
                    this.multibrotSetController.moveSet(Direction.LEFT);
                } else {
                    this.multibrotSetController.moveCamera(Direction.LEFT);
                }
                break;
            case Input.Keys.RIGHT:
                if (ctrlPressed) {
                    this.multibrotSetController.moveSet(Direction.RIGHT);
                } else {
                    this.multibrotSetController.moveCamera(Direction.RIGHT);
                }
                break;
            case Input.Keys.UP:
                if (ctrlPressed) {
                } else {
                    this.multibrotSetController.moveCamera(Direction.UP);
                }
                break;
            case Input.Keys.DOWN:
                if (ctrlPressed) {
                } else {
                    this.multibrotSetController.moveCamera(Direction.DOWN);
                }
                break;
            case Input.Keys.CONTROL_LEFT:
            case Input.Keys.CONTROL_RIGHT:
                ctrlPressed = true;
            default:
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.CONTROL_LEFT || keycode == Input.Keys.CONTROL_RIGHT) {
            ctrlPressed = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            this.multibrotSetController.moveCameraAndZoom(screenX, screenY, Zoom.IN);
        } else if (button == Input.Buttons.RIGHT) {
            this.multibrotSetController.moveCameraAndZoom(screenX, screenY, Zoom.OUT);
        } else if (button == Input.Buttons.MIDDLE) {
            this.multibrotSetController.moveCamera(screenX, screenY);
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        this.multibrotSetController.zoom(amountY < 0 ? Zoom.IN : Zoom.OUT);
        return false;
    }
}