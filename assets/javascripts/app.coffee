window.MyApp = Ember.Application.create()

DS.RESTAdapter.reopen({
  namespace: 'be'
})

MyApp.Router.map(->
  this.resource('index', { path: '/' })
  )
  
# MyApp.ApplicationAdapter = DS.FixtureAdapter.extend()
  
MyApp.Person = DS.Model.extend({
  firstName: DS.attr('string')
  lastName: DS.attr('string')
})

MyApp.Person.FIXTURES = [{
  id: 1
  firstName: 'hanh'
  lastName: 'huynh'
  }
  {
  id: 2
  firstName: 'carolyn'
  lastName: 'ng'
  }]
  
MyApp.IndexRoute = Ember.Route.extend({
  model: ->
    this.store.find('person')
  })
  
MyApp.IndexController = Ember.ArrayController.extend({
})

MyApp.DataTableView = Ember.View.extend({
  templateName: 'table'
  didInsertElement: ->
    this.$("table").dataTable()
})