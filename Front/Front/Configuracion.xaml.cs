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
using System.Diagnostics;

namespace Front
{
    /// <summary>
    /// Interaction logic for Configuracion.xaml
    /// </summary>
    public partial class Configuracion : Window
    {
        private bool ExisteHormiga = false;
        private bool ExisteConfig = false;
        private string tHormiga;
        private string tDepredador;
        private string tClima;
        public Configuracion()
        {
            InitializeComponent();
        }

        private void btnHormigas_Click(object sender, RoutedEventArgs e)
        {
            Hormigas ventana_hormigas = new Hormigas();
            ventana_hormigas.ShowDialog();
            string tipo_hormiga = ventana_hormigas.TipoSeleccionado;
            if (tipo_hormiga != null){
                ExisteHormiga = true ;
                tHormiga = tipo_hormiga;
            }
            else { MessageBox.Show("No selecciono opción"); }
        }

        private void btnConstantes_Click(object sender, RoutedEventArgs e)
        {
            Constanes ventana_constantes = new Constanes();
            ventana_constantes.ShowDialog();
            string TipoAmbiente = ventana_constantes.TipoAmbiente;
            string TipoDepredador = ventana_constantes.TipoDepredador;

            if (TipoAmbiente != null & TipoDepredador != null)
            {
                ExisteConfig = true;
                tDepredador = TipoDepredador;
                tClima = TipoAmbiente;
            }
            else { MessageBox.Show("No selecciono opción"); }

        }

        private void btnVolver_Click(object sender, RoutedEventArgs e)
        {
            MainWindow nueva_principal = new MainWindow();
            nueva_principal.Show();
            this.Close();
        }

        private void btnSimular_Click(object sender, RoutedEventArgs e)
        {
            if (ExisteHormiga & ExisteConfig)
            {
                MessageBox.Show("Encendiendo Java");
                AbrirCmd();
                simulacion ventana_simulacion = new simulacion(tHormiga, tDepredador, tClima);
                ventana_simulacion.Show();
                this.Close();
            }
            else { MessageBox.Show("No cumplieron las opciones"); }
        }

        private void AbrirCmd()
        {
            Process process = new Process();
            process.StartInfo.FileName = "cmd.exe";
            process.StartInfo.Arguments = "/C cd Hormigas\\src && java clases_hormiga.Main"; //K para no morir, C para morir

            
            process.StartInfo.CreateNoWindow = false; //
            process.StartInfo.UseShellExecute = true;//
            //process.StartInfo.WindowStyle = ProcessWindowStyle.Hidden;

            process.Start();
            GlobalState.ProcesoConsola = process;
        }


    }
}


public static class GlobalState
{
    public static Process ProcesoConsola;
}