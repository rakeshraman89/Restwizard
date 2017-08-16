import React from 'react';
import ReactDOM from 'react-dom';

class Toggle extends React.Component {
    constructor(props) {
        super(props);
        //this.state = {isToggleOn: true};

        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        /*this.setState(prevState => ({
            isToggleOn: !prevState.isToggleOn
        }));*/
        return fetch("http://localhost:8080/employees")
            .then(function(success) {
                console.log("the fetch was successful" + success);
            }, function(error) {
                console.log("fetch was unsuccessful" + error);
            });
    }

    render() {
        return (
            <div>
                <button onClick={this.handleClick}>
                    FETCH
                </button>
            </div>
        );
    }
}

ReactDOM.render(
    //<Toggle message={"Button is ON"}/>,
    <Toggle />,
    document.getElementById('restwizard-div')
);