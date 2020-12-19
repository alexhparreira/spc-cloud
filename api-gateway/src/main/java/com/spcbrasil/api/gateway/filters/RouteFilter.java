package com.spcbrasil.api.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpStatus;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.FORWARD_TO_KEY;

public class RouteFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "route";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {

    RequestContext context = RequestContext.getCurrentContext();
    String token = context.getRequest().getHeader("Authorization");
    context.getRequest().getParameterMap().put("api", new String[]{"api"});
    context.getResponse().setHeader("api", token);
    context.addZuulResponseHeader("api", "api");
    context.addZuulRequestHeader("api", "api");
    context.setSendZuulResponse(false);

    return null;
  }

}