import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

export default function Home() {

    const [users, setUsers] = useState([]);

    useEffect(() => {

        loadUsers();

    }, []);
    const loadUsers = async () => {

        const result = await axios.get("http://localhost:8085/api/users/get/all");

        setUsers(result.data);
    }
    const deleteUser = async (id) => {

        await axios.delete(`http://localhost:8085/api/users/delete/${id}`);
        loadUsers();
    }
    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Username</th>
                            <th scope="col">Email</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map((user, index) => (
                            <tr>
                                <th scope="row" key={index}>{index + 1}</th>
                                <td >{user.name}</td>
                                <td >{user.username}</td>
                                <td>{user.email}</td>
                                <td>
                                    <Link to={`/viewuser/${user.id}`} className="btn btn-primary mx-2">View</Link>
                                    <Link className="btn btn-outline-primary mx-2" to={`/edituser/${user.id}`}>Edit </Link>
                                    <Link onClick={() => deleteUser(user.id)} className="btn btn-danger mx-2">Delete</Link>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
