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
    /// Interaction logic for Estadisticas.xaml
    /// </summary>
    public partial class Estadisticas : Window
    {
        public Estadisticas(String mensaje)
        {
            InitializeComponent();
            ActualizarTextos(mensaje);
        }

        private void ActualizarTextos(String mensaje){
            string[] partes = mensaje.Split(';');
            txtNumHormigas.Text = partes[0];
            txtReinas.Text = partes[1];
            txtObreras.Text = partes[2];
            txtComida.Text = partes[3];
            txtTerritorio.Text = partes[4];
            txtCazados.Text = partes[5];
            txtPuntuacion.Text = partes[6];

        }

        private void Salir_Click(object sender, RoutedEventArgs e)
        {
            GlobalState.ProcesoConsola.Kill();
            Application.Current.Shutdown(); 
        }

        private void Cerrar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }
    }
}
