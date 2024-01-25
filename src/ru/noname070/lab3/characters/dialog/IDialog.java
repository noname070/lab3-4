package ru.noname070.lab3.characters.dialog;

import ru.noname070.lab3.characters.ICharacter;

public interface IDialog {
    void say(String form, ICharacter target);

    void hear(String form, ICharacter from);
}
