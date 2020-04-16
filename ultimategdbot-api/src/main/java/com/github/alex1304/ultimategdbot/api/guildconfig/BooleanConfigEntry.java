package com.github.alex1304.ultimategdbot.api.guildconfig;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import reactor.core.publisher.Mono;

public class BooleanConfigEntry extends AbstractConfigEntry<Boolean> {

	BooleanConfigEntry(GuildConfigurator<?> configurator, String key, String description,
			Function<Object, ? extends Mono<Boolean>> valueGetter,
			BiFunction<Object, ? super Boolean, Object> valueSetter, Validator<Boolean> validator,
			Consumer<? super Boolean> valueObserver) {
		super(configurator, key, description, valueGetter, valueSetter, validator, valueObserver);
	}

	@Override
	public <R> Mono<R> accept(ConfigEntryVisitor<R> visitor) {
		return visitor.visit(this);
	}
	
	/**
	 * Creates a builder for this ConfigEntry implementation.
	 * 
	 * @param <D> the implementation type of {@link GuildConfigData} this entry
	 *            affects
	 * @param key the unique key identifying the built entry
	 * @return a new builder
	 */
	public static <D extends GuildConfigData<D>> ConfigEntryBuilder<D, Boolean> builder(String key) {
		return new ConfigEntryBuilder<>(BooleanConfigEntry::new, key);
	}
}
