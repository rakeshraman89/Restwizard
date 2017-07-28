
var Greeting = React.createClass({
    render: function() {
        return (
        <p>Hello, Restwizard</p>
        )
    }
});
ReactDOM.render(
<Greeting />, document.getElementById("restwizard-div")
);