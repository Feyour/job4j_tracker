package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    void whenMultipleValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"2", "3", "5", "7"}
        );
        ValidateInput input = new ValidateInput(output, in);

        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);

        int selectedThree = input.askInt("Enter menu:");
        assertThat(selectedThree).isEqualTo(3);

        int selectedFive = input.askInt("Enter menu:");
        assertThat(selectedFive).isEqualTo(5);

        int selectedSeven = input.askInt("Enter menu:");
        assertThat(selectedSeven).isEqualTo(7);
    }

    @Test
    void whenNegativeValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-2);
    }

}