package com.liang;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/5/3 22:26
 * @content
 */

public class Translattion {

    /**
     * translation : ["静态"]
     * basic : {"us-phonetic":"ˈstætɪk","phonetic":"ˈstætɪk","uk-phonetic":"ˈstætɪk","explains":["n. 静电；静电干扰","adj. 静态的；静电的；静力的"]}
     * query : static
     * errorCode : 0
     * web : [{"value":["静力学","静态的","静态"],"key":"static"},{"value":["静密封","衬垫","静态密封"],"key":"static seal"},{"value":["静电","静位觉","静电学"],"key":"static electricity"}]
     */

    private BasicBean basic;
    private String query;
    private int errorCode;
    private List<String> translation;
    private List<WebBean> web;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }

    public static class BasicBean {
        /**
         * us-phonetic : ˈstætɪk
         * phonetic : ˈstætɪk
         * uk-phonetic : ˈstætɪk
         * explains : ["n. 静电；静电干扰","adj. 静态的；静电的；静力的"]
         */

        @SerializedName("us-phonetic")
        private String usphonetic;
        private String phonetic;
        @SerializedName("uk-phonetic")
        private String ukphonetic;
        private List<String> explains;

        public String getUsphonetic() {
            return usphonetic;
        }

        public void setUsphonetic(String usphonetic) {
            this.usphonetic = usphonetic;
        }

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public String getUkphonetic() {
            return ukphonetic;
        }

        public void setUkphonetic(String ukphonetic) {
            this.ukphonetic = ukphonetic;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }
    }

    public static class WebBean {
        /**
         * value : ["静力学","静态的","静态"]
         * key : static
         */

        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return "Translattion{" +
                "basic=" + basic +
                ", query='" + query + '\'' +
                ", errorCode=" + errorCode +
                ", translation=" + translation +
                ", web=" + web +
                '}';
    }
}
