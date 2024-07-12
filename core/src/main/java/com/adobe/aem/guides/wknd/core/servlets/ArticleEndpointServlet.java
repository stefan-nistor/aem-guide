package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.models.impl.ArticleModel;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.models.factory.ModelFactory;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.*;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=" + "Article JSON servlet",
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        SLING_SERVLET_RESOURCE_TYPES + "=" + "wknd/components/pagearticle",
        SLING_SERVLET_SELECTORS + "=" + "articles",
        SLING_SERVLET_EXTENSIONS + "=" + "json"
})
public class ArticleEndpointServlet extends SlingSafeMethodsServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleEndpointServlet.class);
    private static final String RESOURCE_TYPE = "wknd/components/pagearticle";
    @Reference
    private QueryBuilder queryBuilder;

    @Reference
    private ModelFactory modelFactory;

    private static final Gson GSON = new Gson();

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

//        Map<String, String> queryMap = new HashMap<>();
//        // path should be the selected path from the AEM component (in some var)
//        queryMap.put("path", "/content/wknd/us/en/technology");
//        queryMap.put("1_property", "sling:resourceType");
//        queryMap.put("1_property.value", RESOURCE_TYPE);
//        queryMap.put("p.guessTotal", "true");
//        queryMap.put("p.limit", "-1");
//
//
//        Session session = request.getResourceResolver().adaptTo(Session.class);
//        Query query = queryBuilder.createQuery(PredicateGroup.create(queryMap), session);
//        SearchResult searchResult = query.getResult();
//
//        JsonArray jsonArray = new JsonArray();
//
//        searchResult.getResources().forEachRemaining(resource -> {
//            ArticleModel articleModel = resource.adaptTo(ArticleModel.class);
//            if (articleModel != null) {
//                JsonObject jsonObject = new JsonObject();
//                jsonObject.addProperty("title", articleModel.getTitle());
//                jsonObject.addProperty("description", articleModel.getDescription());
//                jsonObject.addProperty("image", articleModel.getImage());
//                jsonObject.addProperty("articlePath", resource.getPath());
//                jsonArray.add(jsonObject);
//            }
//        });

        response.getWriter().write("Started writing json array");
//        response.getWriter().write(GSON.toJson(jsonArray));
        response.getWriter().write("Finished writing json array");
        response.getWriter().flush();
    }
}
