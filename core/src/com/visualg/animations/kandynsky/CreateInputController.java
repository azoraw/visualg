package com.visualg.animations.kandynsky;

import com.badlogic.gdx.Input;
import com.visualg.global.Config;
import com.visualg.ui.simplifiedComponents.DefaultInputProcessor;

class CreateInputController implements DefaultInputProcessor {
    private final Settings settings = Settings.INSTANCE;
    private final KandynskyAlg alg;
    private final Table table;

    public CreateInputController(KandynskyAlg alg, Table table) {
        this.alg = alg;
        this.table = table;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT) {
            return false;
        }
        switch (settings.getEditMode()) {
            case CREATE -> alg.createElement(screenX, Config.HEIGHT - screenY);
            case MOVE -> alg.moveElement(screenX, Config.HEIGHT - screenY);
            case SELECT -> {
                alg.selectElement(screenX, Config.HEIGHT - screenY);
                table.addSelectedElement(alg.getSelectedElement());
            }
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if (Settings.INSTANCE.getEditMode() == EditMode.MOVE || Settings.INSTANCE.getEditMode() == EditMode.SELECT) {
            table.updateFields();
        }
        return false;
    }
}
