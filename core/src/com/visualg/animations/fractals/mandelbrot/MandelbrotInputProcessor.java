package com.visualg.animations.fractals.mandelbrot;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.visualg.util.Direction;
import com.visualg.util.Zoom;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class MandelbrotInputProcessor implements InputProcessor {

    private final MandelbrotController mandelbrotController;

    private boolean ctrlPressed = false;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                if (!ctrlPressed) {
                    mandelbrotController.moveCamera(Direction.LEFT);
                }
                break;
            case Input.Keys.RIGHT:
                if (!ctrlPressed) {
                    mandelbrotController.moveCamera(Direction.RIGHT);
                }
                break;
            case Input.Keys.UP:
                if (!ctrlPressed) {
                    mandelbrotController.moveCamera(Direction.UP);
                }
                break;
            case Input.Keys.DOWN:
                if (!ctrlPressed) {
                    mandelbrotController.moveCamera(Direction.DOWN);
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
            mandelbrotController.moveCameraAndZoom(screenX, screenY, Zoom.IN);
        } else if (button == Input.Buttons.RIGHT) {
            mandelbrotController.moveCameraAndZoom(screenX, screenY, Zoom.OUT);
        } else if (button == Input.Buttons.MIDDLE) {
            mandelbrotController.moveCamera(screenX, screenY);
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
        mandelbrotController.zoom(amountY < 0 ? Zoom.IN : Zoom.OUT);
        return false;
    }

}
