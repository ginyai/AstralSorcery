/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.common.starlight.transmission.registry;

import hellfirepvp.astralsorcery.common.event.StarlightNetworkEvent;
import hellfirepvp.astralsorcery.common.starlight.IIndependentStarlightSource;
import hellfirepvp.astralsorcery.common.starlight.transmission.base.crystal.IndependentCrystalSource;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
* This class is part of the Astral Sorcery Mod
* The complete source code for this mod can be found on github.
* Class: SourceClassRegistry
* Created by HellFirePvP
* Date: 04.08.2016 / 16:33
*/
public class SourceClassRegistry {

    public static final SourceClassRegistry eventInstance = new SourceClassRegistry();

    private SourceClassRegistry() {}

    public void registerProvider(SourceProvider provider) {
        register(provider);
    }

    private static Map<String, SourceProvider> providerMap = new HashMap<>();

    @Nullable
    public static SourceProvider getProvider(String identifier) {
        return providerMap.get(identifier);
    }

    public static void register(SourceProvider provider) {
        if(providerMap.containsKey(provider.getIdentifier())) throw new RuntimeException("Already registered identifier SourceProvider: " + provider.getIdentifier());
        providerMap.put(provider.getIdentifier(), provider);
    }

    public static void setupRegistry() {
        register(new IndependentCrystalSource.Provider());

        MinecraftForge.EVENT_BUS.post(new StarlightNetworkEvent.SourceProviderRegistry(eventInstance));
    }

    public static interface SourceProvider {

        public IIndependentStarlightSource provideEmptySource();

        public String getIdentifier();

    }

}
