/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.client.util.mappings;

import hellfirepvp.astralsorcery.client.util.resource.AssetLibrary;
import hellfirepvp.astralsorcery.client.util.resource.AssetLoader;
import hellfirepvp.astralsorcery.client.util.resource.BindableResource;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: ClientJournalMapping
 * Created by HellFirePvP
 * Date: 13.08.2016 / 11:13
 */
@SideOnly(Side.CLIENT)
public class ClientJournalMapping {

    private static Map<ResearchProgression, JournalCluster> map = new HashMap<>();

    public static void init() {
        BindableResource cloudDsc = AssetLibrary.loadTexture(AssetLoader.TextureLocation.GUI, "cloud5");
        map.put(ResearchProgression.DISCOVERY, new JournalCluster(cloudDsc, cloudDsc, -2, -2, 0, 0));

        BindableResource cloudCraft = AssetLibrary.loadTexture(AssetLoader.TextureLocation.GUI, "cloud2");
        map.put(ResearchProgression.BASIC_CRAFT, new JournalCluster(cloudCraft, cloudCraft, 1, 1, 4, 3));

        BindableResource cloudAtt = AssetLibrary.loadTexture(AssetLoader.TextureLocation.GUI, "cloud4");
        map.put(ResearchProgression.ATTUNEMENT, new JournalCluster(cloudAtt, cloudAtt, 3, -2, 5, 0));

        BindableResource cloudCst = AssetLibrary.loadTexture(AssetLoader.TextureLocation.GUI, "cloud1");
        map.put(ResearchProgression.CONSTELLATION, new JournalCluster(cloudCst, cloudCst, 5, 0, 8, 2));
    }

    public static JournalCluster getClusterMapping(ResearchProgression progression) {
        return map.get(progression);
    }

    public static class JournalCluster {

        public final BindableResource cloudTexture, clusterBackgroundTexture;
        public final Point boundary1, boundary2;
        public final int leftMost, rightMost, upperMost, lowerMost;

        /** Keep in mind: negative coords are left upper side of the GUI
         *
         *  uppermost = most negative Y, lowermost = most positive Y
         *  leftmost =  most negative X, rightmost = most positive X
         *
         *  A wrong definition doesn't affect size calculation, but rendering.
         */
        public JournalCluster(BindableResource cloudTexture, BindableResource clusterBackgroundTexture, int leftMost, int upperMost, int rightMost, int lowerMost) {
            this.cloudTexture = cloudTexture;
            this.clusterBackgroundTexture = clusterBackgroundTexture;
            this.leftMost = leftMost;
            this.upperMost = upperMost;
            this.rightMost = rightMost;
            this.lowerMost = lowerMost;
            this.boundary1 = new Point(leftMost, upperMost);
            this.boundary2 = new Point(rightMost, lowerMost);
        }

    }
}
