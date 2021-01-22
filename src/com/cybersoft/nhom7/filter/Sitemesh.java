package com.cybersoft.nhom7.filter;

import javax.servlet.annotation.WebFilter;

import com.cybersoft.nhom7.util.Path;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(filterName = "sitemesh", urlPatterns = Path.ROOT)
public class Sitemesh extends SiteMeshFilter {

}
