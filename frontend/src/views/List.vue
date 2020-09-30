<template>
    <div class="home">
        <section class="form">
            <b-table v-if="tableData" :data="tableData" :columns="columns"></b-table>
        </section>

    </div>
</template>

<script>


export default {
  name: 'Add',
  data() {
      return {

          tableData: null,
          columns: [
                {
                    field: 'id',
                    label: 'ID',
                    width: '40',
                    numeric: true,
                    centered: true
                },
                {
                    field: 'name',
                    label: 'Nome',
                    centered: true
                },
                {
                    field: 'email',
                    label: 'E-mail',
                    centered: true
                },
                {
                    field: 'password',
                    label: 'Senha',
                    centered: true
                },
            ]
      }
  },

    methods: {
   
    },

    async beforeCreate() {

        const response = await this.axios.get('http://localhost:8081/index')

        this.tableData = response.data

        console.log(response.data)


    }
}
</script>

<style scoped>

.form {

    width: 800px;
    margin-left: auto; 
    margin-right: auto;

}

</style>
