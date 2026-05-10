package name.asleep.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;


public class RylanRageItem extends Item {
    public RylanRageItem(Settings settings){
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();


        if (user.getWorld().isClient) {
            return ActionResult.PASS;
        }

        user.sendMessage(Text.literal("RRRRRAAAAAAAAAAAHHHHHHHHHH"), false);

        BlockPos frontOfUser = user.getBlockPos().offset(user.getHorizontalFacing(), 10);
        Vec3d lookDir = user.getRotationVec(1.0F);
        Vec3d spawnPos = user.getEyePos().add(lookDir.multiply(7));

        LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, user.getWorld());
        lightningBolt.refreshPositionAfterTeleport(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
        user.getWorld().spawnEntity(lightningBolt);

        // Damage the item after using it (durability goes down)
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

}