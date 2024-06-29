<script setup>
import { computed, ref, watch } from 'vue'
import useSearch from '@/store/search'
import formatNumber from '@/utils/character/formatNumber'

const search = useSearch()

const totalCharAct = ref(0)

const content = computed(() => search.content)
</script>

<template>
  <div class="total-translate">
    <el-link href="https://www.xiaojingge.com" target="_blank" class="tips-by"
      >Powered by： xiaojingge</el-link
    >
  </div>
</template>

<style scoped>
.tips-total {
  width: 165px;
  font-size: 13px;
  color: #606266;
}

.tips-by {
  margin-left: 40px;
  font-size: 14px;
  font-weight: normal;
}
</style>
