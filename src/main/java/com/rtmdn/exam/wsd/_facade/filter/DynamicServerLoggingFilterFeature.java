
package com.rtmdn.exam.wsd._facade.filter;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

public class DynamicServerLoggingFilterFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo ri, FeatureContext fc)
    {
        //if ( MyResource.class.isAssignableFrom(ri.getResourceClass()) && ri.getResourceMethod().isAnnotationPresent(GET.class)) {
        fc.register(new ContainerLoggingFilter());
        //}
    }
}
