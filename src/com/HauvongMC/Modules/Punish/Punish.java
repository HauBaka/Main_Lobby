package com.HauvongMC.Modules.Punish;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Punish {
    private Player target, checker;
    private List<String> reasons;
    public Punish(Player p, Player target) {
        this.checker = p;
        this.target = target;
        reasons = new ArrayList<>();
    }


    public List<String> getReasons() {
        return this.reasons;
    }

    public void addReason(String reason) {
        this.reasons.add(reason);
    }

}
