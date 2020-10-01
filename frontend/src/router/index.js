import Vue from 'vue'
import VueRouter from 'vue-router'
import Add from '../views/Add.vue'
import List from '../views/List.vue'
import Delete from '../views/Delete.vue'
import View from '../views/View.vue'
import Edit from '../views/Edit.vue'

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
  {
    path: '/View',
    name: 'View',
    component: View
  },
  {
    path: '/Edit',
    name: 'Edit',
    component: Edit
  },
]

const router = new VueRouter({ routes })

export default router
