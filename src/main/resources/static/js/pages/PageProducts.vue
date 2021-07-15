<template>
<div class="page-products">
  <h1>Список продуктов</h1>
  <div
  v-if="isLoading"
  v-text="'Загрузка...'"
  class="page-products__loading"/>
  <div
  class="page-products__list">
    <product-card
    v-for="product in products"
    :key="product.id"
    :product="product"
    @delete="deleteProduct"/>
  </div>

  <div class="page-products__paginator">
    <div
    v-for="i in totalPages"
    :key="i"
    class="page-products__page"
    :class="{'page-products__page--active': page == i}">
      <a
      href="#"
      @click="changePage(i)"
      v-text="i"/>
    </div>
  </div>
</div>
</template>

<script>
import ProductCard from "components/ProductCard.vue";
import api from "api.js";

export default {
  name: "PageProducts",
  components: { ProductCard },

  data() {
    return {
      products: [],
      page: 1,
      isLoading: false,
      totalPages: 1
    }
  },

  methods: {
    changePage(page) {
      this.page = page;
      this.fetchProducts();
    },

    async fetchProducts() {
      this.isLoading = true;
      const response = await api.get('api/products', { params: { page: this.page } });
      this.isLoading = false;
      this.products = response.data.content;
      this.totalPages = response.data.totalPages
    },

    async deleteProduct(product) {
      this.isLoading = true;
      const response = await api.delete('api/products', { params: { id: product.id } });
      this.isLoading = false;
      this.changePage(this.page);
    }
  },

  mounted() {
    this.changePage(1);
  }
}
</script>

<style lang="scss">
.page-products {

  &__list {
    > * + * {
      margin-top: 10px;
    }
  }

  &__paginator {
    margin-top: 15px;
    display: flex;
    > * + * {
      margin-left: 10px;
    }
  }

  &__page {
    &--active {
      font-weight: bold;
    }
  }
}
</style>