import React from 'react';
import { PieChart, Pie, Cell, Tooltip, Legend, ResponsiveContainer } from 'recharts';

const UserRolePieChart = ({ data }) => {
  const chartData = [
    { name: 'Admins', value: data.adminCount || 0, color: '#916ed6' },
    { name: 'Users', value: data.userCount || 0, color: '#28a745' }
  ].filter(item => item.value > 0);

  if (chartData.length === 0) {
    return <p>No user data available</p>;
  }

  return (
    <ResponsiveContainer width="100%" height={300}>
      <PieChart>
        <Pie data={chartData} dataKey="value" cx="50%" cy="50%" outerRadius={100} label>
          {chartData.map((entry, index) => (
            <Cell key={`cell-${index}`} fill={entry.color} />
          ))}
        </Pie>
        <Tooltip />
        <Legend />
      </PieChart>
    </ResponsiveContainer>
  );
};

export default UserRolePieChart;
