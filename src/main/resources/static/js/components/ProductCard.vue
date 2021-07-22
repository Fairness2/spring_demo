<template>
<div class="product-card">
  <div class="product-card__attribute">
    <span
    v-text="'ID: '"
    class="product-card__attribute-name"/>
    {{product.id}}
  </div>
  <div class="product-card__attribute">
    <span
        v-text="'Название: '"
        class="product-card__attribute-name"/>
    {{product.title}}
  </div>
  <div class="product-card__attribute">
    <span
        v-text="'Стоимость: '"
        class="product-card__attribute-name"/>
    {{product.cost}}
  </div>
  <div class="product-card__attribute">
    <span
        v-text="'Категория: '"
        class="product-card__attribute-name"/>
    {{product.category.name}}
  </div>
  <div class="product-card__actions">
    <a
    href="#"
    @click="$emit('delete', product)"
    v-text="'Удалить'"/>
  </div>
</div>
</template>

<script>
export default {
  name: "ProductCard",
  props: {
    product: { type: Object, required: true }
  }
}
</script>

<style lang="scss">
  .product-card {
    &__attribute-name {
      font-weight: bold;
    }
}
</style>