<template>
    <div class="home">
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

            const response = await this.axios.post('http://localhost:8081/', this.form)

            console.log(response)

        }      
    },
}
</script>

<style scoped>

.form {

    width: 800px;
    margin-left: auto; 
    margin-right: auto;

}

</style>
