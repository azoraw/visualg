package com.visualg.animations.bezier;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.visualg.util.Pair;

record Line(Vector2 pos1, Vector2 pos2, Pair<Color, Color> colorPair) {}
