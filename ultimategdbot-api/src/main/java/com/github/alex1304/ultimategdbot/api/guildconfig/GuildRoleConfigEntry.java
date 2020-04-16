package com.github.alex1304.ultimategdbot.api.guildconfig;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import discord4j.core.object.entity.Role;
import reactor.core.publisher.Mono;

public class GuildRoleConfigEntry extends AbstractConfigEntry<Role> {

	GuildRoleConfigEntry(GuildConfigurator<?> configurator, String key, String description,
			Function<Object, ? extends Mono<Role>> valueGetter, BiFunction<Object, ? super Role, Object> valueSetter,
			Validator<Role> validator, Consumer<? super Role> valueObserver) {
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
	public static <D extends GuildConfigData<D>> ConfigEntryBuilder<D, Role> builder(String key) {
		return new ConfigEntryBuilder<>(GuildRoleConfigEntry::new, key);
	}
}
