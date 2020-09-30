import Vue from 'vue'
import VueRouter from 'vue-router'
import Add from '../views/Add.vue'
import List from '../views/List.vue'
import Delete from '../views/Delete.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Add',
    component: Add
  },
  {
    path: '/List',
    name: 'List',
    component: List
  },
  {
    path: '/Delete',
    name: 'Delete',
    component: Delete
  },
]

const router = new VueRouter({
  routes
})

export default router
