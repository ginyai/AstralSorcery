/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2017
 *
 * This project is licensed under GNU GENERAL PUBLIC LICENSE Version 3.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.core;

import org.objectweb.asm.tree.ClassNode;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: SubClassTransformer
 * Created by HellFirePvP
 * Date: 05.12.2016 / 16:50
 */
public interface SubClassTransformer {

    public void transformClassNode(ClassNode cn, String transformedClassName, String obfName);

    public String getIdentifier();

    public void addErrorInformation();

    public boolean isTransformRequired(String transformedClassName);

}
