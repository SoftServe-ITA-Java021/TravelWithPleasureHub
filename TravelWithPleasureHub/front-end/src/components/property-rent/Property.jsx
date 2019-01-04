import React, {Component} from 'react';

class Property extends Component {
	constructor(props) {
		super(props);
		this.state = {
			title : null,
			description: null,
			address: null,
			price : null,
			imageLinkObjects: []
		};
		this.loadPropertyData = this.loadPropertyData.bind(this);
		this.loadImages = this.loadImages.bind(this);
	}

	loadPropertyData = () => {
		fetch(`http://localhost:8080/api/properties/${this.props.match.params.id}`)
			.then(response => response.json())
			.then(response => this.setState(response))
	};

	loadImages = () => {
		fetch(`http://localhost:8080/api/property-image/property/${this.props.match.params.id}`)
			.then(response => response.json())
			// .then(response => console.log(response))
			.then(responseJSON => this.setState({imageLinkObjects: responseJSON}))
	};

	componentWillMount() {
		this.loadPropertyData();
		this.loadImages();
	}


	render() {
		return (
			<div className="container">
				<div id="carouselExampleIndicators" className="carousel slide" data-interval="false"
				     data-ride="carousel">
					<ol className="carousel-indicators">
						{
							this.state.imageLinkObjects.map((_, index) =>
								index === 0 ?
									<li data-target="#carouselExampleIndicators" data-slide-to={index} className="active"/>
									:
									<li data-target="#carouselExampleIndicators" data-slide-to={index}/>
							)
						}
					</ol>
					<div className="carousel-inner">
						{
							this.state.imageLinkObjects.map((imageLinkObject, index) =>

								index === 0 ?
									<div className="carousel-item active">
										<img className="d-block w-100" src={imageLinkObject.imageLink}/>
									</div>
									:
									<div className="carousel-item"> :
										<img className="d-block w-100" src={imageLinkObject.imageLink}/>
									</div>

							)
						}
					</div>
					<a className="carousel-control-prev" href="#carouselExampleIndicators" role="button"
					   data-slide="prev">
						<span className="carousel-control-prev-icon" aria-hidden="true"/>
						<span className="sr-only">Previous</span>
					</a>
					<a className="carousel-control-next" href="#carouselExampleIndicators" role="button"
					   data-slide="next">
						<span className="carousel-control-next-icon" aria-hidden="true"/>
						<span className="sr-only">Next</span>
					</a>
				</div>
				<div className="row mt-3 justify-content-around">
					<div className="col-11  text-black">
						<h1>{this.state.title}</h1>
					</div>
					<p className="col-11">{this.state.address}</p>
				</div>

				<div className="row mt-4 justify-content-around">
					<div className="col-6 text-black">
						<p>{this.state.description}</p>
					</div>
					<div className="col-4 text-black">
						<div className="col">
							<img className="col mt-2 w-25 rounded-circle" src={require('../../2.jpg')} alt="Smiley face" />
							<span className="col">Author kekek</span>
						</div>

					</div>
				</div>
			</div>
		);
	}
}

export default Property;