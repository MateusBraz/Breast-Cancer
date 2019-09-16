import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import TelaInformacoes from '@/components/TelaInformacoes'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'TelaInformacoes',
      component: TelaInformacoes
    }
  ]
})
