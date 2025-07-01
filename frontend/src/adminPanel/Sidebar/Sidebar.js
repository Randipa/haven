import React from 'react';
import { NavLink } from 'react-router-dom';
import { FaHome, FaPaw, FaFileInvoice, FaUser, FaClipboardList, FaSignOutAlt, FaEnvelope, FaTachometerAlt } from 'react-icons/fa';

import './Sidebar.css';

const Sidebar = ({ onLogout }) => { 

  return (
    <div>
      {/* Top Bar */}
      <div className="topbar">
      </div>

      {/* Sidebar */}
      <div className="sidebar">
        <div className="sidebar-logo">
          {/* Use the logo from src/assets or public */}
          <img alt="Logo" className="sidebar-logo-img"  src='/images/paww.png'/>
        </div>
        <h2 className="sidebar-title">Paws Haven</h2>
        <ul className="sidebar-list">
          <li>
            <NavLink
              to="/admin/dashboard"
              end
              className={({ isActive }) => (isActive ? "active-link" : "")}
            >
              <FaTachometerAlt className="sidebar-icon" />
              Dashboard
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/admin/pets"
              className={({ isActive }) => (isActive ? "active-link" : "")}
            >
              <FaPaw className="sidebar-icon" />
              Requested Pets
            </NavLink>
          </li>

          <li>
            <NavLink
              to="/admin/users"
              className={({ isActive }) => (isActive ? "active-link" : "")}
            >
              <FaUser className="sidebar-icon" />
              User Management
            </NavLink>
          </li>
          <li>
            <NavLink
              to="/admin/messages"
              className={({ isActive }) => (isActive ? "active-link" : "")}
            >
              <FaEnvelope className="sidebar-icon" />
              Contact Messages
            </NavLink>
          </li>
         
         
        </ul>

        {/* Logout Button */}
        <div className="sidebar-logout" onClick={onLogout}> {/* Call onLogout on click */}
          <FaSignOutAlt className="sidebar-icon" />
        
        </div>
      </div>
      <div className="Bellbar"></div>
    </div>
  );
};

export default Sidebar;
