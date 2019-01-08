import React, {Component} from 'react';

class ErrorBoundary extends Component {
	constructor(props) {
		super(props);
		this.state = {
			hasError: false,
			error: null
		};
	}

	componentDidCatch(error, info) {
		console.log(error);
		console.log('err');
		this.setState({
			hasError: true,
			error: error
		});
	}

	render() {
		if (this.state.hasError) {
			return <div className="container text-center">
						<h1 className="text-black">Oopsie! Client-side error!</h1>
						<p>This might me helpful!</p>
						<p>{this.state.error}</p>
					</div>;
		}
		return this.props.children;
	}
}

export default ErrorBoundary;