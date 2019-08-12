package tests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class UsernamePasswordArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("seleniumtests@tut.by", "123456789zxcvbn"),
                Arguments.of("seleniumtests2@tut.by", "123456789zxcvbn")
        );
    }
}
