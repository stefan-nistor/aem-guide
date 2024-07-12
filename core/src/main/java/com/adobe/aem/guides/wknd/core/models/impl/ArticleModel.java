package com.adobe.aem.guides.wknd.core.models.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;


@Model(adaptables = Resource.class)
public class ArticleModel {

    @ValueMapValue
    @Named("jcr:title")
    @Required
    private String title;

    @Inject
    private String description;

    @ChildResource(name="image/fileReference")
    private String image;

    private String path;

    public ArticleModel(Resource resource) {
        path = resource.getPath();
        Resource imgRes = resource.getChild("root/image");
        assert imgRes != null;
        image = imgRes.getValueMap().get("fileReference", String.class);
    }

    @PostConstruct
    public void init() {
        path = path.replace("/jcr:content", "");
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

}
