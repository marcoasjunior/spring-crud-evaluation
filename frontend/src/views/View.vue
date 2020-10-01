<template>
    <div class="home">
        <section class="form">
            <b-field label="Usuário">
                <b-select v-model="selected" placeholder="Selecione">
                    <option v-for="option in list" :value="option.id" :key="option.id">
                        {{ option.name }}
                    </option>
                </b-select>
            </b-field>
            <b-button @click="submit">Visualizar</b-button>
        </section>
        <section class="form">
            <b-table v-if="user" :data="user" :columns="columns"></b-table>
        </section>
    </div>
</template>

<script>


export default {
  name: 'View',
  data() {
      return {

          selected: null,
          list: null,
          user: null,
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

        async submit() {

            if (!this.selected) return alert('Usuário não escolhido.')

            const response = await this.axios.get('http://localhost:8081/find?id=' + this.selected)

            this.user = [response.data]

            if (response) {

                const response = await this.axios.get('http://localhost:8081/index')    
                
                this.list = response.data

                return alert('Usuário encontrado')

            }

            return alert('Erro ao deletar.')

        }   
   
    },

    async beforeCreate() {

        const response = await this.axios.get('http://localhost:8081/index')

        this.list = response.data

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
