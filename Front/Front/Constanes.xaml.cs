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
    /// Interaction logic for Constanes.xaml
    /// </summary>
    public partial class Constanes : Window
    {
        public string TipoAmbiente { get; set; }
        public string TipoDepredador { get; set; }

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
    }

}