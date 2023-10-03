package com.visualg.animations.waveFuncCollapse;

import com.visualg.animations.waveFuncCollapse.rules.Rules;
import com.visualg.util.Direction;
import com.visualg.util.RandomDecorator;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Cell implements Comparable<Cell> {
    @Getter
    private final int x;
    @Getter
    private final int y;
    private final Rules rules;
    boolean collapsed = false;
    int solution;
    private List<Integer> options;

    Cell(int x, int y, Rules rules) {
        this.x = x;
        this.y = y;
        this.rules = rules;
        options = rules.getInitOptions();
    }

    boolean collapse(int index, Direction direction) {
        List<Integer> collect = options.stream()
                .filter(e -> rules.getPossibleSolutions(index, direction).stream()
                        .anyMatch(f -> e == f))
                .collect(toList());
        if (collect.size() == 1) {
            collapsed(collect.get(0));
            return true;
        }
        if (collect.size() == 0) {
            throw new RuntimeException("no entropy to collapse");
        }
        options = collect;
        return false;
    }

    void collapsed(int solution) {
        options = List.of(solution);
        this.solution = solution;
        collapsed = true;
    }

    public int getEntropy() {
        return options.size();
    }

    @Override
    public int compareTo(Cell o) {
        return Comparator.comparing(Cell::getEntropy)
                .thenComparing(Cell::getX)
                .thenComparing(Cell::getY)
                .compare(this, o);
    }

    public void collapse() {
        collapsed(options.get(RandomDecorator.Random.nextInt(options.size())));
    }

    @Override
    public String toString() {
        return "" + solution;
    }
}
