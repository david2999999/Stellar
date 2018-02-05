var utility = utilities();
var idGenerator = utility.idGen(0)
var idGenerator2 = utility.idGen(0)

var User = Backbone.Model.extend({
    defaults: {
        id: 0,
        fullName: "",
        role: "Member",
        authenticate: false,
        taskNumber: -1,
        taskTitle: "",
        taskDescription: "",
        taskAssignDate: new Date(),
        taskDueDate: ""
    }
});

var Users = Backbone.Collection.extend({});

var Task = Backbone.Model.extend({
   id: 0,
    taskTitle: "",
   taskDesc: "",
   dueDate: new Date()
});

var Tasks = Backbone.Collection.extend({});

var user1 = new User({
    id: idGenerator() ,
    fullName: "David T.",
    role: "Front-End Developer",
    authenticate: true,
    taskTitle: "MongoDB",
    taskNumber: 4,
    taskDescription: "MongoDB developers who use the program regularly should have an idea of how to do specific commands. There are some of more common ones that they should be able to talk about, including collection commands.",
    taskAssignDate: utility.formatDate(new Date()),
    taskDueDate: "2/22/2018"
});
var user2 = new User({
    id: idGenerator() ,
    fullName: "Joshua Q.",
    role: "Back-End Developer",
    taskTitle: "Javascript",
    authenticate: true,
    taskNumber: 4,
    taskDescription: "Create,Read,Update,Delete users and tasks.",
    taskAssignDate: utility.formatDate(new Date()),
    taskDueDate: "4/22/2018"
});
var user3 = new User({
    id: idGenerator() ,
    fullName: "David T.",
    role: "Front-End Developer",
    authenticate: true,
    taskTitle: "MongoDB",
    taskNumber: 4,
    taskDescription: "MongoDB developers who use the program regularly should have an idea of how to do specific commands. There are some of more common ones that they should be able to talk about, including collection commands.",
    taskAssignDate: utility.formatDate(new Date()),
    taskDueDate: "2/22/2018"
});
var user4 = new User({
    id: idGenerator() ,
    fullName: "Joshua Q.",
    role: "Back-End Developer",
    taskTitle: "Javascript",
    authenticate: true,
    taskNumber: 4,
    taskDescription: "Create,Read,Update,Delete users and tasks.",
    taskAssignDate: utility.formatDate(new Date()),
    taskDueDate: "4/22/2018"
});
var users = new Users([user1, user2, user3, user4]);


var task1 = new Task({
    id: idGenerator2(),
    taskTitle: "HTML/CSS",
    taskDesc: "Create Front page of Website, deciding on User interfaces such as color theme and layout",
    dueDate: "Due Date: 2/21/2018"
});

var task2 = new Task({
    id: idGenerator2(),
    taskTitle: "BACKBONEJS",
    taskDesc: "Using the models, create a view using the template and then inject the views with attributes of the models.",
    dueDate: "Due Date: 2/30/2018"
});

var task3 = new Task({
    id: idGenerator2(),
    taskTitle: "java",
    taskDesc: "Connect the website to the database, which will be used to persist data of models and users",
    dueDate: "Due Date: 2/29/2018"
});

var task4 = new Task({
    id: idGenerator2(),
    taskTitle: "javascript",
    taskDesc: "Create,Read,Update,Delete users and tasks",
    dueDate: "Due Date: 2/22/2018"
});

var tasks = new Tasks([task1, task2, task3, task4]);
// =================================================================

var UserView = Backbone.View.extend({
    model: new User(),
    className: "col-lg-4 col-md-6 col-sm-12 form-group",

    events: {
        'click .delete-user' : 'delete'
    },

    delete: function () {
        users.remove(this.model);
    },

    initialize: function () {
        this.template = _.template($('.user-list-template').html());
    },

    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});

var UserViews = Backbone.View.extend({
    model: users,
    el: $('.user-list'),

    initialize: function () {
        // var self = this;

        this.model.on('remove', this.render, this);
    },

    render: function () {
        var self = this;

        this.$el.html('');
        _.each(this.model.toArray(), function (user) {
            self.$el.append((new UserView({model : user})).render().$el);
        });
    }

});


var TaskView = Backbone.View.extend({
    model: new Task(),
    className: "col-lg-3 col-md-6 col-sm-12 form-group",

    events: {
        'click .delete-task' : 'delete',

    },

    delete: function () {
      tasks.remove(this.model);
    },

    initialize: function () {
        this.template = _.template($('.task-list-template').html());
    },

    render: function () {
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    }
});

var TaskViews = Backbone.View.extend({
    model: tasks,
    el: $('.task-list'),

    initialize: function () {
        this.model.on('remove', this.render, this);
    },

    render: function () {
        var self = this;

        this.$el.html('');
        _.each(this.model.toArray(), function (task) {
            self.$el.append((new TaskView({model: task})).render().$el)
        })
    }
});


var userViews = new UserViews();
 // userViews.render();

var taskViews = new TaskViews();
// taskViews.render();



function utilities() {
    return{
        formatDate : function (date) {
            var monthNames = [
                "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October",
                "November", "December"
            ];

            var day = date.getDate();
            var monthIndex = date.getMonth();
            var year = date.getFullYear();

            return monthNames[monthIndex] + ' ' + day + ' ' + year;
        },


        idGen: function (start) {
            var id = start;
            return function() {
                return id++;
            }
        }
    }
}


