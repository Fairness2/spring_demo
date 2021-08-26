import Vue from 'vue';
import App from 'pages/App.vue';
import router from './router';
require("babel-core/register");
require("babel-polyfill");

const app = new Vue ({
    el: '#app',
    router,
    render: a => a(App),
    //components: { App }
})