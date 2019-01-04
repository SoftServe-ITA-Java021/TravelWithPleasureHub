import React, {Component} from 'react';
import '../../property-thumbnail.css';
import {Link} from "react-router-dom";

class PropertyThumbnail extends Component {
	constructor(props) {
		super(props);
		this.state = {
			imageLink: null
		};
		this.loadThumbnailImageLink = this.loadThumbnailImageLink.bind(this);
	}

	loadThumbnailImageLink = () => {
		fetch('http://localhost:8080/api/property-image/property/first/' + this.props.id)
			.then(response => response.json())
			.then(responseJSON => this.setState({imageLink: responseJSON.imageLink}))
	};


	componentWillMount() {
		this.loadThumbnailImageLink();
	}


	render() {
		return (
			<Link to={`/properties/` + this.props.id}>
				<div className="thumbnail-container" id="thumbnail-container">
					<div className="thumbnail-info rounded p-2 bg-light text-black" id="thumbnail-info">
						{this.props.title}, ${this.props.price}
					</div>
					<img className="img-fluid mt-3 rounded" src={this.state.imageLink}/>
				</div>
			</Link>

		);
	}
}

export default PropertyThumbnail;