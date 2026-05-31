package top.qwertycxz.loadabledialog.mixin;

import static top.qwertycxz.loadabledialog.RegistryInfoLookupImpl.loadDialog;

import net.minecraft.server.WorldLoader;
import net.minecraft.server.WorldLoader.DataLoadOutput;
import net.minecraft.server.WorldLoader.WorldDataSupplier;
import org.jspecify.annotations.NullMarked;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldLoader.class)
@NullMarked
public abstract class WorldLoaderMixin {
	@ModifyVariable(argsOnly = true, at = @At("HEAD"), method = "load")
	private static <T> WorldDataSupplier<T> initialDialog(WorldDataSupplier<T> supplier) {
		return context -> {
			var output = supplier.get(context);
			return new DataLoadOutput<>(output.cookie(), loadDialog(output.finalDimensions(), context.datapackWorldgen(), context.resources()));
		};
	}
}
