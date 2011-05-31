package com.qcadoo.view.internal.ribbon.templates.module;

import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.qcadoo.plugin.api.ModuleFactory;
import com.qcadoo.view.internal.ribbon.templates.RibbonTemplatesService;
import com.qcadoo.view.internal.xml.ViewDefinitionParser;

public class RibbonTemplateExtensionModuleFactory extends ModuleFactory<RibbonTemplateExtensionModule> {

    @Autowired
    private ViewDefinitionParser viewDefinitionParser;

    @Autowired
    private RibbonTemplatesService ribbonTemplatesService;

    @Override
    protected RibbonTemplateExtensionModule parseElement(String pluginIdentifier, Element element) {
        String resource = getRequiredAttribute(element, "resource");

        return new RibbonTemplateExtensionModule(pluginIdentifier, new ClassPathResource(pluginIdentifier + "/" + resource),
                viewDefinitionParser, ribbonTemplatesService);
    }

    @Override
    public String getIdentifier() {
        return "view-ribbon-template-extension";
    }

}