package cn.hello.boot.domain;

import java.io.Serializable;

public class Menu  implements Serializable  {


        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * 主键
         */
        private Long id;

        /**
         * 菜单名称
         */
        private String text;

        /**
         * 菜单URI
         */
        private String uri;

        /**
         * 资源名称
         */
        private String resource;

        /**
         * 商家菜单ID
         */
        private Long pid;

        /**
         * 菜单图标
         */
        private String icon;

        /**
         * 排序
         */
        private Integer sort;

        /**
         * 深度,级数
         */
        private Integer deep;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }
}
