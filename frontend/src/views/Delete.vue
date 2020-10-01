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
            <b-button @click="submit">Deletar</b-button>
        </section>
    </div>
</template>

<script>


export default {
  name: 'Add',
  data() {
      return {

          selected: null,
          list: null,
        
      }
  },

    methods: {

        async submit() {

            if (!this.selected) return alert('Usuário não escolhido.')

            const response = await this.axios.delete('http://localhost:8081/?id=' + this.selected)

            if (response) {

                const response = await this.axios.get('http://localhost:8081/index')

                this.list = response.data

                return alert('Deletado com sucesso')

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
