import Vue from 'vue';
import VueRouter from "vue-router";
import PageProducts from "pages/PageProducts.vue";
import PageMain from "pages/PageMain.vue";
Vue.use(VueRouter);
const routes = [
    {
        name: 'pageMain',
        path: '',
        component: PageMain
    },
    {
        name: 'pageProducts',
        path: '/products',
        component: PageProducts
    }

]

const router = new VueRouter({
    mode: 'history',
    routes,
})

export default router;