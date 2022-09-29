package com.blithe.medical_search.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 11:34
 * Description:
 */

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[]{SpringConfig.class};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[]{SpringMvcConfig.class};
   }

   @Override
   protected String[] getServletMappings() {
      return new String[]{"/"};
   }
}
