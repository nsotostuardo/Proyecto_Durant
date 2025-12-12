using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
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
    /// Interaction logic for Constanes.xaml
    /// </summary>
    public partial class Constanes : Window
    {
        public string TipoAmbiente { get; set; }
        public string TipoDepredador { get; set; }
        public string filePath { get; set; }

        public Constanes()
        {
            InitializeComponent();
        }

        private void btnVolver_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void cmbxAmbiente_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (cmbxAmbiente.SelectedItem is ComboBoxItem item)
                TipoAmbiente = item.Content.ToString();
        }

        private void cmbxDepredadores_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (cmbxDepredadores.SelectedItem is ComboBoxItem item)
                TipoDepredador = item.Content.ToString();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
           
            var openFileDialog = new OpenFileDialog();

            string basePath = AppDomain.CurrentDomain.BaseDirectory;
            string proyectoRoot = System.IO.Path.GetFullPath(System.IO.Path.Combine(basePath, @"..\..\..\..\.."));
            string rutaGenerador = System.IO.Path.Combine(proyectoRoot, @"Generador Datos\tarea_proyecto");
            openFileDialog.InitialDirectory = rutaGenerador;
            openFileDialog.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";
            openFileDialog.FilterIndex = 2;
            openFileDialog.RestoreDirectory = true;

            bool? result = openFileDialog.ShowDialog();

            if (result == true)
            {
                filePath = openFileDialog.FileName;
                MessageBox.Show("Ruta archivo: " + filePath);
            }
            else
            {
                MessageBox.Show("No se seleccionó ningún archivo.");
            }
        }
    }

}