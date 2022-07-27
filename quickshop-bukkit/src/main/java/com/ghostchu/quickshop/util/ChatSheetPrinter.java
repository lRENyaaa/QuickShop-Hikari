package com.ghostchu.quickshop.util;

import com.ghostchu.quickshop.QuickShop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


@AllArgsConstructor
@Getter
@Setter
/*
 A utils for print sheet on chat.
*/
public class ChatSheetPrinter {
    private final CommandSender p;

    public void printCenterLine(@NotNull Component text) {
        if (Util.isEmptyComponent(text)) {
            return;
        }

        MsgUtil.sendDirectMessage(p,
                QuickShop.getInstance().text().of(p, "tableformat.left_half_line").forLocale()
                        .append(text)
                        .append(QuickShop.getInstance().text().of(p, "tableformat.right_half_line").forLocale()));
    }

    private void printFullLine() {
        MsgUtil.sendDirectMessage(p, QuickShop.getInstance().text().of(p, "tableformat.full_line").forLocale());
    }

    public void printFooter() {
        printFullLine();
    }

    public void printHeader() {
        printFullLine();
    }

    public void printLine(@NotNull Component component) {
        if (Util.isEmptyComponent(component)) {
            return;
        }
        MsgUtil.sendDirectMessage(p, QuickShop.getInstance().text().of(p, "tableformat.left_begin").forLocale()
                .append(component));
    }
}
