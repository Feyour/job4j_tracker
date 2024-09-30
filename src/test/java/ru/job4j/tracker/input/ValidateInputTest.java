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
        int[] values = {2, 3, 5, 7};
        for (int i = 0; i < values.length; i++) {
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(values[i]);
        }
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