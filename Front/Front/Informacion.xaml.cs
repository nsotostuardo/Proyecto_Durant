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
    /// <summary>
    /// Interaction logic for Informacion.xaml
    /// </summary>
    public partial class Informacion : Window
    {

        public Informacion(string hormiga, string clima, string depredador)
        {
            InitializeComponent();
            CambiarTextos(hormiga, clima, depredador);

        }

        private void btnVolver_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void CambiarTextos(string hormiga, string clima, string depredador)
        {
            txtHormigaselect.Text = hormiga;
            txtClimaselect.Text = clima;
            txtDepredaroselect.Text = depredador;
        }

    }
}
