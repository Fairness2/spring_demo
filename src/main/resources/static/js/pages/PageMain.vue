<template>
<div>
  <h1>Это главная</h1>
  <ul>
    <li>
      <router-link
      :to="{name: 'pageProducts'}"
      v-text="'Продукты'"/>
    </li>
  </ul>
</div>
</template>

<script>
export default {
  name: "PageMain"
}
</script>

<style lang="scss">

</style>