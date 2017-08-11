import React from 'react';
import ReactDOM from 'react-dom';

class Toggle extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isToggleOn: true};

        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        this.setState(prevState => ({
            isToggleOn: !prevState.isToggleOn
        }));
    }

    render() {
        return (
            <div>
                <button onClick={this.handleClick}>
                    {this.state.isToggleOn ? 'ON' : 'OFF'}
                </button>
                <p>{this.state.isToggleOn? this.props.message : 'Button is OFF'}</p>
            </div>
        );
    }
}

ReactDOM.render(
    <Toggle message={"Button is ON"}/>,
    document.getElementById('restwizard-div')
);