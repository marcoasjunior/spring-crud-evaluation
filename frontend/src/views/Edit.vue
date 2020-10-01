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
            <b-button @click="find">Selecionar</b-button>
        </section>
        <section class="columns form">
            <div class="column">
                <b-field label="Nome">
                    <b-input v-model="form.name" ></b-input>
                </b-field>
    
                <b-field label="Email">
                    <b-input v-model="form.email" type="email" maxlength="30">
                    </b-input>
                </b-field>
       
                <b-field label="Senha" type="is-warning">
                    <b-input v-model="form.password" type="password" maxlength="30"></b-input>
                </b-field>
                <div class="buttons">
                    <b-button @click="submit" type="is-primary" expanded>Enviar</b-button>
                </div>
            </div>
        </section>

    </div>
</template>

<script>

export default {
  name: 'Add',
  data() {
      return {
          selected:  null,
          list: null,
          user: null,
          form: {

            email: null,
            password: null,
            name: null

          }

      }
  },

    methods: {

        async submit() {

            if (!this.form.name || !this.form.password || !this.form.email) return alert('Faltam dados serem preenchidos.')

            this.form.id = this.selected

            try {

                await this.axios.put('http://localhost:8081/', this.form)

                const response = await this.axios.get('http://localhost:8081/index')    
                
                this.list = response.data

                alert('Salvo com sucesso.')
                
            } catch (error) {

                alert(error)
                
            }

        },

        async find() {

            if (!this.selected) return alert('Usuário não escolhido.')

            const { data } = await this.axios.get('http://localhost:8081/find?id=' + this.selected)

            this.form.email = data.email
            this.form.name = data.name
            this.form.password = data.password

            if (!data) return alert('Erro ao deletar.')

        },
        

    },

    async beforeCreate() {

        const response = await this.axios.get('http://localhost:8081/index')

        return this.list = response.data

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
