using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Front 
{ 
    public partial class VentanaInfo : Window
    {
        public VentanaInfo(int n_hormigas, int n_depredadores)
        {
            InitializeComponent();
            txtHormigas.Text = n_hormigas + "";
            txtDepredadores.Text = n_depredadores + "";
        }

    }
}
