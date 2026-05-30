package top.qwertycxz.loadabledialog.mixin;

import static com.mojang.serialization.JsonOps.INSTANCE;
import static com.mojang.serialization.Lifecycle.experimental;
import static java.util.Objects.requireNonNull;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.toConcurrentMap;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.ofNullable;
import static net.minecraft.core.registries.Registries.DIALOG;
import static net.minecraft.resources.RegistryOps.RegistryInfo.fromRegistryLookup;
import static net.minecraft.server.dialog.Dialog.DIRECT_CODEC;
import static net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener.scanDirectory;
import static net.minecraft.tags.TagLoader.loadTagsForRegistry;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.Lifecycle;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.stream.Stream;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.RegistryOps.RegistryInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.ReloadableServerRegistries;
import net.minecraft.server.dialog.Dialog;
import net.minecraft.server.packs.resources.ResourceManager;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import top.qwertycxz.loadabledialog.RegistryInfoLookupImpl;

@Mixin(ReloadableServerRegistries.class)
@NullMarked
public abstract class ReloadableServerRegistriesMixin {
	@Final
	@Shadow
	@SuppressWarnings("null")
	private static RegistrationInfo DEFAULT_REGISTRATION_INFO;
	@Unique
	private static final Lifecycle LIFECYCLE = requireNonNull(experimental());
	@Unique
	private static final JsonOps OPERATIONS = requireNonNull(INSTANCE);

	@ModifyExpressionValue(at = @At(target = "map", value = "INVOKE"), method = "reload")
	private static Stream<? extends CompletableFuture<? extends WritableRegistry<?>>> loadDialog(
		Stream<? extends CompletableFuture<? extends WritableRegistry<?>>> registries, @Local(argsOnly = true) Executor executor, @Local(argsOnly = true) ResourceManager manager, @Share("lookups") LocalRef<List<@NonNull RegistryLookup<?>>> lookups
	) {
		return requireNonNull(concat(registries, ofNullable(supplyAsync(() -> {
			ConcurrentMap<@NonNull ResourceKey<? extends Registry<?>>, @NonNull RegistryInfo<?>> info = lookups.get().parallelStream().collect(toConcurrentMap(RegistryLookup::key, lookup -> fromRegistryLookup(lookup)));
			var mapped = new MappedRegistry<>(DIALOG, LIFECYCLE);
			info.put(DIALOG, new RegistryInfo<>(mapped, mapped.createRegistrationLookup(), LIFECYCLE));
			var dialogs = new ConcurrentHashMap<Identifier, Dialog>();
			scanDirectory(manager, DIALOG, RegistryOps.create(OPERATIONS, new RegistryInfoLookupImpl(info)), DIRECT_CODEC, dialogs);
			for (var dialog : dialogs.entrySet()) {
				mapped.register(ResourceKey.create(DIALOG, requireNonNull(dialog.getKey())), requireNonNull(dialog.getValue()), DEFAULT_REGISTRATION_INFO);
			}
			loadTagsForRegistry(manager, mapped);
			return mapped;
		}, executor))));
	}

	@ModifyExpressionValue(at = @At(target = "buildUpdatedLookups", value = "INVOKE"), method = "reload")
	private static <T, U extends RegistryLookup<T>, V extends List<U>> V shareLookups(V value, @Share("lookups") LocalRef<V> reference) {
		reference.set(value);
		return value;
	}
}
