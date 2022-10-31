package com.visualg.animations.waveFuncCollapse.rules;

import com.visualg.util.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visualg.util.Direction.values;
import static java.util.stream.Collectors.toList;


//changes connectors of an element to List of possible elements'
public class Rules {
    private final Map<RuleKey, List<Integer>> rules = new HashMap<>();

    public Rules() {
        ConnectionRules connectionRules = new ConnectionRules();
        List<ConnectionRule> rules = connectionRules.getRules();
        transform(rules);
    }

    private void transform(List<ConnectionRule> connectionRules) {
        initRules(connectionRules);
        addInitElement();
        for (ConnectionRule rule : connectionRules) {
            for (ConnectionRule rule2 : connectionRules) {
                if (rule.direction().equals(rule2.direction().opposite) && rule.connection().equals(rule2.connection())) {
                    addToRules(rule.elementIndex(), rule.direction(), rule2.elementIndex());
                }
            }
        }
    }

    private void initRules(List<ConnectionRule> connectionRules) {
        for (Direction dir : values()) {
            for (ConnectionRule ruleKeyListEntry : connectionRules) {
                addRule(ruleKeyListEntry.elementIndex(), dir, new ArrayList<>());
            }
        }
    }

    private void addInitElement() {
        List<Integer> possibleElements = getInitOptions();
        for (Direction dir : values()) {
            addRule(0, dir, possibleElements);
        }
    }

    private void addRule(int index, Direction direction, List<Integer> options) {
        rules.put(new RuleKey(index, direction), options);
    }

    private void addToRules(int index, Direction direction, int option) {
        rules.get(new RuleKey(index, direction))
                .add(option);
    }

    public List<Integer> getPossibleSolutions(int index, Direction direction) {
        return rules.get(new RuleKey(index, direction));
    }

    public List<Integer> getInitOptions() {
        return rules.keySet().stream()
                .map(RuleKey::index)
                .distinct()
                .collect(toList());
    }
}
