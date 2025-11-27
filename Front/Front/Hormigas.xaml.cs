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
    /// Interaction logic for Hormigas.xaml
    /// </summary>
    public partial class Hormigas : Window
    {
        public string TipoSeleccionado { get; set; }

        public Hormigas()
        {
            InitializeComponent();
        }

        private void CambiarHormiga(string tipo)
        {
            TipoSeleccionado = tipo;
            txtTipoHormiga.Text = tipo;
        }


        private void btnVolver_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void btnCamponotus_Click(object sender, RoutedEventArgs e)
        {
            CambiarHormiga("Camponotus");
        }

        private void btnBala_Click(object sender, RoutedEventArgs e)
        {
            CambiarHormiga("Hormiga Bala");
        }

        private void btnHoja_Click(object sender, RoutedEventArgs e)
        {
            CambiarHormiga("Hormiga de la hoja");
        }
    }
}
