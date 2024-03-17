package com.cognizant.Wishlist.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cognizant.Wishlist.Filter.JwtTokenFilter;
@Configuration
public class FilterConfig {
	@Bean
    public FilterRegistrationBean jwtFavouriteFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new JwtTokenFilter());
        filter.addUrlPatterns("/wishlist/*");
        return filter;
    }
}
