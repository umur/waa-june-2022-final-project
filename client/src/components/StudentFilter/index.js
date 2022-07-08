
import './index.css'

function StudentFilter() {
    return (<div className="card filter-form">

        <form>
            <div class="row">

                <div className="mb-3 col-3">
                    <label for="name" className="form-label">Name</label>
                    <input type="text" className="form-control" id="name" />
                </div>

                <div className="mb-3 col-3">
                    <label for="state" className="form-label">State</label>
                    <select className="form-select" id="state">
                        <option selected>Select</option>
                        <option value="1">Iowa</option>
                        <option value="2">New York</option>
                        <option value="3">Berlinton</option>
                    </select>
                </div>

                <div className="mb-3 col-3">
                    <label for="city" className="form-label">City</label>
                    <select className="form-select" id="city">
                        <option selected>Select</option>
                        <option value="1">Fairfield</option>
                        <option value="2">De Moinse</option>
                        <option value="3">Berlinton</option>
                    </select>
                </div>

                <div className="mb-3 col-3">
                    <label for="major" className="form-label">Major</label>
                    <select className="form-select" id="major">
                        <option selected>Select</option>
                        <option value="1">Compro</option>
                        <option value="2">MSD</option>
                        <option value="3">MBA</option>
                    </select>
                </div>




            </div>
        </form>

    </div>);
}

export default StudentFilter;