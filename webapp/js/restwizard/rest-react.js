var greeter = require('./greeter');

var greeting = greeter.greet();

if (typeof document !== 'undefined') {
    var el = document.createElement('h1');
    el.innerHTML = greeting;
    document.body.appendChild(el);
} else {
    console.log(greeting);
}

/*var ClickButton = React.createClass({
    render: function() {
        return (
            <button type="button" name="Click" onClick={() => (alert('Button Clicked!!'))}></button>
        );
    }
});
ReactDOM.render(
<ClickButton />, document.getElementById("restwizard-div")
);*/