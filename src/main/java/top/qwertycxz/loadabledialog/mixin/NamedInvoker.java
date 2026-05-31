package top.qwertycxz.loadabledialog.mixin;

import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet.Named;
import org.jspecify.annotations.NullMarked;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Named.class)
@NullMarked
public interface NamedInvoker<T> {
	@Invoker("bind")
	void invokeBind(List<Holder<T>> holders);
}
