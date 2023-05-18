module.exports = {
  lintOnSave: false,

  devServer:{
    proxy: {
      '/login':{
        target:'http://localhost:8080',
        changOrigin: true
      },
      '/register':{
        target:'http://localhost:8080',
        changOrigin: true
      },
      '/userHome':{
        target:'http://localhost:8080',
        changOrigin: true
      },
      '/manageHome':{
        target:'http://localhost:8080',
        changOrigin: true
      }
    }
  }
}
