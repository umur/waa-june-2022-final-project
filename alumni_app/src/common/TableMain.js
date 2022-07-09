import * as React from 'react';
import PropTypes from 'prop-types';
import { useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableFooter from '@mui/material/TableFooter';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import IconButton from '@mui/material/IconButton';
import FirstPageIcon from '@mui/icons-material/FirstPage';
import KeyboardArrowLeft from '@mui/icons-material/KeyboardArrowLeft';
import KeyboardArrowRight from '@mui/icons-material/KeyboardArrowRight';
import LastPageIcon from '@mui/icons-material/LastPage';
import { TableHead } from '@material-ui/core';
import { getRequest } from '../setup/fetch-manager/FetchGateway';
import { Button } from '@mui/material';
import EditIcon from '@mui/icons-material/Edit';
import { useNavigate } from 'react-router';

function TablePaginationActions(props) {
    const theme = useTheme();
    const { count, page, rowsPerPage, onPageChange } = props;


    /////PAGE CHANGE FUNCTIONS
    const handleFirstPageButtonClick = (event) => {
        onPageChange(event, 0);
    };

    const handleBackButtonClick = (event) => {
        onPageChange(event, page - 1);
    };

    const handleNextButtonClick = (event) => {
        onPageChange(event, page + 1);
    };

    const handleLastPageButtonClick = (event) => {
        onPageChange(event, Math.max(0, Math.ceil(count / rowsPerPage) - 1));
    };
    ////////////////////


    return (
        <Box sx={{ flexShrink: 0, ml: 2.5 }}>
            <IconButton
                onClick={handleFirstPageButtonClick}
                disabled={page === 0}
                aria-label="first page"
            >
                {theme.direction === 'rtl' ? <LastPageIcon /> : <FirstPageIcon />}
            </IconButton>
            <IconButton
                onClick={handleBackButtonClick}
                disabled={page === 0}
                aria-label="previous page"
            >
                {theme.direction === 'rtl' ? <KeyboardArrowRight /> : <KeyboardArrowLeft />}
            </IconButton>
            <IconButton
                onClick={handleNextButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="next page"
            >
                {theme.direction === 'rtl' ? <KeyboardArrowLeft /> : <KeyboardArrowRight />}
            </IconButton>
            <IconButton
                onClick={handleLastPageButtonClick}
                disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                aria-label="last page"
            >
                {theme.direction === 'rtl' ? <FirstPageIcon /> : <LastPageIcon />}
            </IconButton>
        </Box>
    );
}

TablePaginationActions.propTypes = {
    count: PropTypes.number.isRequired,
    onPageChange: PropTypes.func.isRequired,
    page: PropTypes.number.isRequired,
    rowsPerPage: PropTypes.number.isRequired,
};

export default function TableMain(props) {
    const [page, setPage] = React.useState(0);
    const [count, setCount] = React.useState(0);
    const [rowsPerPage, setRowsPerPage] = React.useState(5);
    const [rowData, setRowData] = React.useState([]);
    const navigate = useNavigate();
    let uniqueKey = 1;

    const fetchData = async () => {
        let params = props.dataUrl + "/getAll?page=" + page + "&size=" + rowsPerPage + "&searchValue=";
        let result = await getRequest(params);
        debugger
        setRowData(result);
    }

    const countData = async () => {
        let params = props.dataUrl + "/count";
        const count = await getRequest(params);
        setCount(count);
    }

    React.useEffect(() => {
        fetchData();
        countData();
    }, [page, rowsPerPage])




    // Avoid a layout jump when reaching the last page with empty rows.
    const emptyRows =
        page > 0 ? Math.max(0, (1 + page) * rowsPerPage - rowData.length) : 0;

    const handleChangePage = (event, newPage) => {
        setPage(newPage);
    };

    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    let column = [];
    if (rowData != undefined) {
        if (rowData.length > 0) {
            // get table column
            column = Object.keys(rowData[0]);
        }
    }
    // get table heading data
    const thData = () => {
        return column.map((data) => {
            if (data != 'id')
                return <TableCell key={data} style={{ width: 50 }} className="uppercase">{data}</TableCell>
        })
    }

    // get table row data
    const tdData = () => {
        if (rowData == undefined) {
            return <></>
        }
        else {
            return rowData.map((data) => {
                return (
                    <TableRow key={++uniqueKey}>{
                        column.map((v) => {
                            if (v != 'id')
                                return (
                                    <TableCell style={{ width: 50 }} key={++uniqueKey + data[v]}>{data[v]} </TableCell>
                                )
                        })
                    }
                        <TableCell style={{ width: 50 }}>
                            <Button onClick={() => { navigate(props.editUrl + data.id) }} variant="contained" color="success" className='button-custom'>Edit</Button>
                            <Button onClick={() => { navigate(props.deleteUrl + data.id) }} variant="contained" color="warning" className='button-custom'>Delete</Button>
                            <Button onClick={() => { navigate(props.detailUrl + data.id) }} variant="contained" color="secondary" className='button-custom'>Detail</Button>
                            {(props.addComment ?
                                <Button onClick={() => { navigate('/Comments/' + data.id) }} variant="contained" color="primary" className='button-custom'>Comment</Button>
                                :
                                ''
                            )}
                        </TableCell>

                    </TableRow>

                )
            })
        }
    }

    return (
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 500 }} aria-label="pagination table">
                <TableHead>
                    <TableRow key={++uniqueKey}>
                        {thData()}
                        <TableCell key={++uniqueKey} style={{ width: 50 }} className="uppercase">Actions</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {tdData()}

                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination
                            rowsPerPageOptions={[5, 10, 25, { label: 'All', value: -1 }]}
                            colSpan={3}
                            count={
                                count
                            }
                            rowsPerPage={rowsPerPage}
                            page={page}
                            SelectProps={{
                                inputProps: {
                                    'aria-label': 'rows per page',
                                },
                                native: true,
                            }}
                            onPageChange={handleChangePage}
                            onRowsPerPageChange={handleChangeRowsPerPage}
                            ActionsComponent={TablePaginationActions}
                        />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    );
}
