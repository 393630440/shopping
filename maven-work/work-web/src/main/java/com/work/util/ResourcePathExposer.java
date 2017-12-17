package com.work.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class ResourcePathExposer implements ServletContextAware {
	
    private ServletContext application;
    private String staticRoot;
    
    public void init() {
    	if("/".equals(getServletContext().getContextPath())){
            getServletContext().setAttribute("contextPath", getServletContext().getContextPath());
            getServletContext().setAttribute("staticRoot", staticRoot);
    	}else {
            getServletContext().setAttribute("staticRoot", staticRoot);
		}
        
    }

    public void setServletContext(ServletContext servletContext) {
        application = servletContext;

    }

    public ServletContext getServletContext() {
        return this.application;
    }

	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	public String getStaticRoot() {
		return staticRoot;
	}

	public void setStaticRoot(String staticRoot) {
		this.staticRoot = staticRoot;
	}
    
}
