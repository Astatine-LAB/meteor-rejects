package anticope.rejects.mixin.meteor;

import anticope.rejects.utils.accounts.CustomYggdrasilAccount;
import meteordevelopment.meteorclient.systems.accounts.Account;
import meteordevelopment.meteorclient.systems.accounts.Accounts;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Accounts.class)
public class AccountsMixin {
    @Inject(method = "lambda$fromTag$1", at = @At("HEAD"), cancellable = true)
    private static void onFromTag(Tag tag1, CallbackInfoReturnable<Account<?>> cir) {
        if (tag1 instanceof CompoundTag t && t.getStringOr("type", "").equals("Yggdrasil")) {
            Account<CustomYggdrasilAccount> account = new CustomYggdrasilAccount(null, null, null).fromTag(t);
            cir.setReturnValue(account.fetchInfo() ? account : null);
        }
    }
}
